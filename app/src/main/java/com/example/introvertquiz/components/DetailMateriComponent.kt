package com.example.introvertquiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.introvertquiz.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailMateriComponent {
    @Composable
    fun VideoPlayer(isLoading:(Boolean) -> Unit) {
        AndroidView(factory = {
            var view = YouTubePlayerView(it)
            view.addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        super.onReady(youTubePlayer)
                        isLoading.invoke(false)
                        youTubePlayer.loadVideo("56JOMkPvoKs", 0f)
                    }
                }
            )
            view
        })
    }

    @Composable
    fun MateriDownload(
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            elevation = 8.dp,
            color = Color.White,
            contentColor = MaterialTheme.colors.primary,
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, end = 18.dp, start = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Evolutionary Clustering",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.primary,
                    fontSize = 14.sp
                )

                Icon(
                    painter = painterResource(id = R.drawable.download_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}