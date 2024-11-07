package com.example.coiledu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.coiledu.ui.theme.CoilEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoilEduTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    CoilImage()
                }
            }
        }
    }
}

@Composable
fun CoilImage(modifier: Modifier = Modifier){
    AsyncImage(
        model = "https://picsum.photos/200/300",
        contentDescription = "무료 이미지",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun CoilImage2(modifier: Modifier = Modifier){
    AsyncImage(
        model = R.drawable.imagecover,
        contentDescription = "무료 이미지",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun CoilImage3(modifier: Modifier = Modifier){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://picsum.photos/200/300")
            .crossfade(2000)
            .transformations(CircleCropTransformation())
            .build(),
        contentDescription = "무료 이미지",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        placeholder = painterResource(R.drawable.imagecover),
    )
}