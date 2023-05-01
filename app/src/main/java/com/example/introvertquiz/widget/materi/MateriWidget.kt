package com.example.introvertquiz.widget.materi

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.introvertquiz.components.MateriComponent

class MateriWidget {
    private val component = MateriComponent()

    @Composable
    fun AnnounceWidget() {
        val listTitle = listOf(
            "Link Zoom Perkuliahan",
            "Link Penting !",
            "Link Zoom Perkuliahan",
        )
        val listDesc = listOf(
            "https://us02web.zoom.us/j/88253203415",
            "Berikut adalah link penting untuk...",
            "https://us02web.zoom.us/j/88253203415",
        )

        LazyRow(content = {
            itemsIndexed(listTitle) {
                index,item ->
                component.AnnounceCard(title = item, desc = listDesc[index])
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }



    @Composable
    fun TaskQuizWidget(navController: NavController) {
        LazyRow(content = {
            items(5) {
                component.TaskCard(navController)
                Spacer(modifier = Modifier.width(14.dp))
            }
        })
    }
    @Composable
    fun MateriCardWidget(navController: NavController) {
        for (i in 0..3) {
            component.MateriCard(navController,i)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}