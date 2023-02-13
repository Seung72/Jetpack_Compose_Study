package com.cholee.e05_image_card_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isFavoriteB1 by rememberSaveable {
                mutableStateOf(false)
            }
            var isFavoriteB2 by rememberSaveable {
                mutableStateOf(false)
            }
            Column() {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp),
                    isFavorite = isFavoriteB1,
                    R.drawable.book1
                ) {
                        favorite ->
                    isFavoriteB1 = favorite
                }
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp),
                    isFavorite = isFavoriteB2,
                    R.drawable.book2
                ) {
                        favorite ->
                    isFavoriteB2 = favorite
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    image: Int,
    onTabFavorite: (Boolean) -> Unit) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
            ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = "book1",
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,) {
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    Icon(
                        imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White)
                }
            }
        }
    }
}
@Preview(backgroundColor = 0xffffff, showBackground = true)
@Composable
private fun Preview() {
}
