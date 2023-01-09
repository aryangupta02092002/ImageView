package com.aryan.coilimage.util

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.aryan.coilimage.MainActivity

class CoilImageLibrary {
    @Composable
    fun imageLoading(
        img: String,
        showLoader: Boolean,
        cornerRad: Boolean,

        onImageClick: () -> Unit = {}) {


        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(img)
                .crossfade(10000)
                .crossfade(true)
                .build()


        )
        if(painter.state is AsyncImagePainter.State.Loading && showLoader == true){
            CircularProgressIndicator(
                modifier = Modifier.size(1.dp)
            )
        }

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .shadow(15.dp, RoundedCornerShape(15.dp))
                .clickable {
                    onImageClick()
                }
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = "Doge",
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }

}