package com.example.introvertquiz.widget.recomend

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.introvertquiz.components.RecomendComponent

class RecomendWidget {

    private val component = RecomendComponent()

    @Composable
    fun RecomendCard(navController: NavController) {
        val listTitle = listOf(
            "Kuis 1 - Pengenalan...",
            "Tugas 1 - Grey Wolf...",
            "Kuis 2 - Advance Mach...",
            "Kuis 4 - K-Means..."
        )
        LazyColumn(content = {
            items(listTitle) {item ->
                component.RecomendCard(title = item,navController)
                Spacer(modifier = Modifier.height(15.dp))
            }
        })
    }
}