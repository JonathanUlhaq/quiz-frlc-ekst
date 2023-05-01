package com.example.introvertquiz.widget.grade

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.introvertquiz.components.GradeComponent

class GradeWidget {
    private val component = GradeComponent()

    @Composable
    fun CourseWidge(navController: NavController) {
        LazyColumn(content = {
            items(8) {
                component.CourseCard(navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        })
    }
}