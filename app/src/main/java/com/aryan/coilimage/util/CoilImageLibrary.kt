package com.aryan.coilimage.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

class CoilImageLibrary {
    @Composable
    fun imageLoading(img: String, showLoader: Boolean, cornerRad: Boolean) {
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
        Image(
            painter = painter,
            contentDescription ="",

            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(colorResource(id = com.aryan.coilimage.R.color.teal_700), CircleShape)
                .clip(CircleShape)



        )
    }

}