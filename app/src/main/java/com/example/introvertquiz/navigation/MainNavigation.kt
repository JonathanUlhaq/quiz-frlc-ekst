package com.example.introvertquiz.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.example.introvertquiz.navigation.BotNavRoute
import com.example.introvertquiz.view.dashboard.DashboardView
import com.example.introvertquiz.view.detailmateri.DetailMaterView
import com.example.introvertquiz.view.grade.GradeView
import com.example.introvertquiz.view.materi.MateriView
import com.example.introvertquiz.view.quiz.QuizView
import com.example.introvertquiz.view.recomend.RecomendView
import com.example.introvertquiz.view.task.TaskView
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavigation(navController:NavHostController,
                   contentId: MutableState<Int?>,
                   contentShow: MutableState<Boolean>,
                   clickDrawer:() -> Unit) {

    AnimatedNavHost(navController = navController, startDestination = BotNavRoute.Dashboard.route) {
        composable(BotNavRoute.Dashboard.route) {
            contentId.value = null
            contentShow.value = false
            DashboardView(navController) {
                clickDrawer.invoke()
            }
        }
        composable(BotNavRoute.Calendar.route) {

        }
        composable(BotNavRoute.Notification.route) {

        }
        composable(BotNavRoute.Value.route) {
            contentId.value = null
            contentShow.value = false
           GradeView(navController)
        }

        composable(ContentRoute.Materi.route) {
            contentShow.value = true
            contentId.value = 0
            MateriView(navController)
        }
        composable(ContentRoute.Recomend.route) {
            contentShow.value = true
            contentId.value = 3
            RecomendView(navController)
        }
        composable(ContentRoute.Task.route) {
            contentShow.value = true
            contentId.value = 3
            TaskView(navController = navController)
        }
        composable(ContentRoute.Quiz.route) {
            contentShow.value = true
            contentId.value = 0
            QuizView(navController)
        }
        composable(ContentRoute.DetailMateri.route) {
            contentShow.value = true
            contentId.value = 0
            DetailMaterView(navController)
        }

    }
}