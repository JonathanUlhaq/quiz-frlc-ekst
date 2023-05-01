package com.example.introvertquiz.widget.dashboard

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.introvertquiz.components.DashboardComponent
import com.example.introvertquiz.components.DashboardDialog
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DashboardWidget  {
    val dashboardComponent = DashboardComponent()
    @Composable
    fun MainCardWidget() {
        val listTitle = listOf(
            "Pembelajaran  Mesin Lanjut - SUO",
            "Visualisasi Data - PHG",
            "Manajemen Proyek - SOL"
        )
        val listDesc = listOf(
            "Tugas Grey Wolf Algorithm",
            "Midterm Project",
            "Tugas Besar Tahap 01"
        )
        val listDate = listOf(
            "Selasa, 27 Maret",
            "Jum’at, 30 Maret",
            "Selasa, 01 April"
        )

        LazyRow(content = {
            itemsIndexed(listTitle) {
                index,item ->
                 dashboardComponent.MainCard(title = item, desc = listDesc[index], date = listDate[index] ) {

                 }
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }

    @Composable
    fun NewsCardWidget() {
        val listTitle = listOf(
            "Maintenance LMS",
            "Proctoring LMS...",
            "Maintenance LMS",
            "Perubahan Akun..."
        )

        val listDate = listOf(
            "30 Maret, 10:41",
            "18 Maret, 10:41",
            "7 Maret, 10:41",
            "1 Maret, 10:41"
        )

        LazyRow(content = {
            itemsIndexed(listTitle) {
                    index,item ->
                dashboardComponent.NewsCard(title = item , date = listDate[index])
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }

    @Composable
    fun CourseCardWidget(
        navController: NavController
    ) {
        val listTitle = listOf(
            "PEMBELAJARAN MESIN LANJUT - SUO",
            "VISUALISASI DATA - PHG",
            "TEORI BAHASA AUTOMATA - GIA",
            "Perubahan Akun..."
        )



        listTitle.forEach {
            item ->
            dashboardComponent.CourseCard(title = item,navController)
            Spacer(modifier = Modifier.height(14.dp))
        }
    }


}