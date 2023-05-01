package com.example.introvertquiz.navigation

sealed class ContentRoute(val route:String) {
    object Materi:ContentRoute("materi")
    object Recomend:ContentRoute("recomend")
    object Task:ContentRoute("task")
    object Quiz:ContentRoute("quiz")
    object DetailMateri:ContentRoute("detailMateri")
}
