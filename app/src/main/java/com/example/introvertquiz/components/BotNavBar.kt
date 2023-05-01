package com.example.introvertquiz.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.introvertquiz.navigation.BotNavRoute

@Composable
fun BotNavBar(
    nav:NavController
) {
    val listItem = listOf(
        BotNavRoute.Dashboard,
        BotNavRoute.Calendar,
        BotNavRoute.Notification,
        BotNavRoute.Value,
        BotNavRoute.Account
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by nav.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        listItem.forEachIndexed {
            index,item ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon),
                        contentDescription = null,
                        )
                },
                label = {
                    Text(text = item.title, fontSize = 10.sp, style = MaterialTheme.typography.subtitle1)
                },
                selected = currentRoute == item.route,
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color(0xFF6C6C6C),
                onClick = {
                    if (item.route == "dashboard" || item.route == "value") {
                        nav.navigate(item.route) {

                            nav.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
//                                    saveState = true
                                }
                            }
//                            launchSingleTop = true
//                            restoreState = true
                        }
                    }

                },
                alwaysShowLabel = true
            ) 
        }
    }
}

@Composable
fun BotNavBarContent(
    id:Int?,
    nav:NavController
) {
    val listItem = listOf(
        BotNavRoute.Dashboard,
        BotNavRoute.Calendar,
        BotNavRoute.Notification,
        BotNavRoute.Value,
        BotNavRoute.Account
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by nav.currentBackStackEntryAsState()

        listItem.forEachIndexed {
                index,item ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 10.sp, style = MaterialTheme.typography.subtitle1)
                },
                selected =  id == index,
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color(0xFF6C6C6C),
                onClick = {
                    if (item.route == "dashboard" || item.route == "value") {
                        nav.navigate(item.route) {

                            nav.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
//                                    saveState = true
                                }
                            }
//                            launchSingleTop = true
//                            restoreState = true
                        }
                    }

                },
                alwaysShowLabel = true
            )
        }
    }
}