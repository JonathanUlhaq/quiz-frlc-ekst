package com.example.introvertquiz.view.quiz

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.introvertquiz.components.QuizComponent
import com.example.introvertquiz.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuizView(navController: NavController) {

    val listAnswerOne = listOf(
        "A. Operasi konvolusi dapat dilakukan dalam beberapa lapis layer.",
        "B. Dapat melakukan ekstraksi fitur dalam high-level seperti edges dari gambar",
        "C. Mempermudah proses capturing pada low-level features.",
        "D. Networks memiliki pemahaman yang baik terhadap suatu gambar di dalam dataset"
    )
    val listAnswerTwo = listOf(
        "A. Menambahkan skip layer dengan aturan secara random.",
        "B. Menghilangkan lapisan pada posisi yang telah dipilih",
        "C. Menambahkan pooling layer dengan aturan tertentu.",
        "D. Mengganti nilai parameter dari block dengan random pada posisi yang dipilih."
    )
    val listTitle = listOf(
        "ConvNets tidak perlu dibatasi terhadap satu layer konvolusi saja, agar…",
        "Berikut ini yang merupakan bukan ciri offspring generating adalah…"
    )

    val currentIndex = remember {
        mutableStateOf(0)
    }
    val showDrop = remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutine = rememberCoroutineScope()
    val component = QuizComponent()
    val scrollState = rememberScrollState()
    ModalBottomSheetLayout(
        sheetContent = {
            component.QuizBottomContent() {
                coroutine.launch {
                    sheetState.hide()
                }
            }
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
    ) {
        Scaffold(topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 8.dp,
                title = {
                    Text(
                        text = "Kuis 01 / Pembelajaran Mesin Lanjut",
                        style = MaterialTheme.typography.h3,
                        fontSize = 16.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_dropdown),
                            contentDescription = null,
                            modifier = Modifier
                                .rotate(90f)
                                .size(12.dp)
                        )
                    }
                }
            )
        }) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp)
                    .fillMaxSize()
                    .padding(bottom = 8.dp)
                    .verticalScroll(scrollState)

            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .offset(y = 52.dp)



                    ) {

                        Spacer(modifier = Modifier.height(13.dp))
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color.Transparent,
                            border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.alert_icon),
                                    contentDescription = null,
                                    tint = MaterialTheme.colors.primary
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Jawaban akan otomatis tersimpan ketika waktu pengerjaan sudah habis",
                                    modifier = Modifier
                                        .width(256.dp),
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 12.sp,
                                    style = MaterialTheme.typography.h3
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(13.dp))
                        component.Question(title = listTitle[currentIndex.value],
                            answer = if (currentIndex.value == 0) listAnswerOne else listAnswerTwo,
                            nextAppear = currentIndex.value < 1,
                            backAppear = currentIndex.value > 0,
                            next = { currentIndex.value = currentIndex.value + 1 }) {
                            currentIndex.value = currentIndex.value - 1
                        }
                    }

                    Box(modifier = Modifier) {
                        if (showDrop.value) {
                            Surface(
                                Modifier
                                    .offset(y = 40.dp)
                                    .fillMaxWidth()
                                    .height(230.dp),
                                elevation = 8.dp,
                                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                            ) {
                                Row (
                                    modifier = Modifier
                                        .padding(18.dp)
                                ) {
                                    for (i in 0..1) {
                                        Surface(
                                            shape = RoundedCornerShape(5.dp),
                                            color = Color(0xFFBEBCBC),
                                            onClick = {
                                                currentIndex.value = i
                                                showDrop.value = false
                                            }) {
                                            Text(text = (1+i).toString(),
                                                style = MaterialTheme.typography.h1,
                                                color = Color.White,
                                                fontSize = 16.sp,
                                                modifier = Modifier
                                                    .padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp))
                                        }
                                        Spacer(modifier = Modifier.width(18.dp))
                                    }
                                }
                            }
//                            component.QuestionDropDown(show = showDrop, indexClick = {
//                                currentIndex.value = it
//                                showDrop.value = false
//                            } )
                        }
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colors.primary
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 9.dp, bottom = 9.dp, start = 13.dp, end = 13.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                component.MinuteCountdownWithTimeFormat()
                                component.QuestionSum(showDrop.value,currentIndex.value) {
                                    showDrop.value = !showDrop.value
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(0.5f))

                Button(
                    onClick = {
                        coroutine.launch {
                            sheetState.show()
                        }
                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Finish Attempt",
                        style = MaterialTheme.typography.h3,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }

}