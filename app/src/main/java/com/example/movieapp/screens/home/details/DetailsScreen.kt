package com.example.movieapp.screens.home.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.model.Movie

@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,
            elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                    modifier = Modifier.clickable { navController.popBackStack() })
            }
            Spacer(modifier = Modifier.width(100.dp))
            Text(text = "Movies")
        }
    }){
        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {

            Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
                MovieRow(newMovieList.first())
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Movie images")
                HorizontalImageView(newMovieList)
            }


//                Button(onClick = {
//                    navController.popBackStack()
//                }) {
//                    Text(text = "Go back")
//                }
            }
        }
    }

@Composable
private fun HorizontalImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(modifier = Modifier
                .padding(12.dp)
                .size(240.dp), elevation = 5.dp) {
                AsyncImage(
                    image,
                    contentDescription = "Movie Image"
                )
            }
        }

    }
}


