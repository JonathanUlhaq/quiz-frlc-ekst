package com.example.introvertquiz.view.detailmateri

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.R
import com.example.introvertquiz.components.DetailMateriComponent

@Composable
fun DetailMaterView(
    navController: NavController
) {
    val component = DetailMateriComponent()
    val isLoading = remember {
        mutableStateOf(true)
    }
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 8.dp,
                title = {
                    Text(text = "Evolutionary Clustering",
                        style = MaterialTheme.typography.h4,
                        fontSize = 16.sp)
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.icon_dropdown),
                            contentDescription = null,
                            modifier = Modifier
                                .rotate(90f)
                                .size(12.dp))
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp)
                    .verticalScroll(scrollState)
            ) {
                Image(painter = painterResource(id = R.drawable.detail_materi_image),
                    contentDescription = null,
                    modifier = Modifier
                        .width(320.dp)
                        .height(120.dp))
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Evolutionary Clusturing, Apakah itu ?",
                    style = MaterialTheme.typography.h5,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.primary)
                Spacer(modifier = Modifier.height(9.dp))
                Text(text = "Clustering: Menemukan grup objek sedemikian rupa " +
                        "sehingga objek dalam grup akan serupa (atau terkait) " +
                        "satu sama lain dan berbeda dari (atau tidak terkait " +
                        "dengan) objek dalam kelompok lain.",
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Evolutionary Clustering: Penerapan algoritma " +
                        "evolusioner (juga dikenal sebagai genetik " +
                        "algoritma) " +
                        "untuk pengelompokan data (atau analisis cluster).",
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Yuk Nonton Videonya Dulu",
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.primary)
                Spacer(modifier = Modifier.height(9.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)) {
                    if (isLoading.value) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(CenterHorizontally)) {
                            CircularProgressIndicator()
                        }
                    }
                    Surface(
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        component.VideoPlayer {
                            isLoading.value = it
                        }
                    }
                }
                Spacer(modifier = Modifier.height(13.dp))
                Text(text = "Materi Lengkap, Unduh Disini",
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    color = Color.Black)
                Spacer(modifier = Modifier.height(9.dp))
                component.MateriDownload()
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}