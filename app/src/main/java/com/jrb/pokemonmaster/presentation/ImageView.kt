package com.jrb.pokemonmaster.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jrb.pokemonmaster.R

@Composable
fun RoundedImageView() {
    Box(
        Modifier
            .size(100.dp, 100.dp)
            .clip(CircleShape)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model ="https://images.pexels.com/photos/1674752/pexels-photo-1674752.jpeg",
            placeholder = placeholder(preview = R.drawable.ic_pokeball),
            contentDescription = "Profile image",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun placeholder(@DrawableRes preview: Int) = if (LocalInspectionMode.current) {
    painterResource(id = preview)
} else {
    null
}

@Preview
@Composable
fun PreviewScreen() {
    RoundedImageView()
}
