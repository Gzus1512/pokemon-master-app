package com.jrb.pokemonmaster.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jrb.pokemonmaster.R
import com.jrb.pokemonmaster.ui.theme.PurpleGrey80

@Composable
fun RoundedImageView(
    image: String,
    modifier: Modifier,
    imageSize: Dp = 100.dp
) {
    Box(
        modifier
            .clip(CircleShape)
            .background(color = PurpleGrey80),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.size(imageSize),
            model = image,
            placeholder = placeholder(preview = R.drawable.ic_pokeball),
            contentDescription = stringResource(id = R.string.pokemon_image_description),
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
fun PreviewRoundedImage() {
    RoundedImageView("", Modifier)
}
