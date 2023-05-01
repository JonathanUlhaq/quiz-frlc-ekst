package com.example.introvertquiz.view.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.introvertquiz.R
import com.example.introvertquiz.components.BotNavBar
import com.example.introvertquiz.components.BotNavBarContent
import com.example.introvertquiz.navigation.BotNavRoute
import com.example.introvertquiz.navigation.MainNavigation
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainView() {
    val navController = rememberAnimatedNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val listIcon = listOf(
        R.drawable.ocw_icon,
        R.drawable.category_icon
    )

    val listTitle = listOf(
        "OCW",
        "Kategori Kursus"
    )

    val contentBotNav = remember {
        mutableStateOf(false)
    }

    val contentId = remember {
        mutableStateOf<Int?>(null)
    }

    val drawerEnabled = remember {
        mutableStateOf(false)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    drawerEnabled.value = currentRoute == BotNavRoute.Dashboard.route

    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerEnabled.value,
        drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
        drawerContent = {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.celoe_icon),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                listIcon.forEachIndexed { index, i ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = i),
                                contentDescription = null,
                                tint = MaterialTheme.colors.primary
                            )
                            Spacer(modifier = Modifier.width(9.dp))
                            Text(
                                text = listTitle[index],
                                style = MaterialTheme.typography.h1,
                                fontSize = 16.sp,
                                color = MaterialTheme.colors.primary
                            )
                        }
                        Icon(painter = painterResource(id = R.drawable.icon_dropdown),
                            contentDescription = null,
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .rotate(-90F))
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
        }
    ) {
        Scaffold(
            bottomBar = {
                if (!contentBotNav.value) {
                    BotNavBar(nav = navController)
                } else {
                    BotNavBarContent(id = contentId.value , nav = navController )
                }
            }
        ) {
            Surface(modifier = Modifier.padding(it), color = Color.Transparent) {
                MainNavigation(navController = navController,contentId, contentBotNav) {
                    scope.launch {
                        drawerState.open()
                    }
                }
            }
        }
    }

}