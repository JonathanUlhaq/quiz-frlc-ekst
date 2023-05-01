package com.example.introvertquiz.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introvertquiz.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class QuizComponent {

    @Composable
    fun MinuteCountdownWithTimeFormat() {
        var seconds by remember { mutableStateOf(720) }
        LaunchedEffect(Unit) {
            withContext(Dispatchers.Default) {
                repeat(seconds) {
                    delay(1000)
                    seconds--
                }
            }
        }
        val formattedTime = remember(seconds) {
            // Convert seconds to minutes and seconds
            val minutes = seconds / 60
            val remainingSeconds = seconds % 60
            // Format the time as mm:ss
            String.format("00 : %02d : %02d", minutes, remainingSeconds)
        }
        Surface(
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp,
            color = MaterialTheme.colors.primary,
            contentColor = Color.White
        ) {
            Text(
                text = formattedTime,
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 9.dp, end = 9.dp, top = 6.dp, bottom = 6.dp)
            )
        }

    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun QuestionSum(
        boolean: Boolean,
        number:Int,
        onClick:() -> Unit
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colors.primary,
            contentColor = Color.White,
            elevation = 8.dp,
            modifier = Modifier
                .height(28.dp),
            onClick = {
                onClick.invoke()
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(74.dp)
            ) {
                Text(
                    text = "$number / 2",
                    style = MaterialTheme.typography.body1,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 6.dp, bottom = 6.dp)
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color.White,
                    contentColor = Color.Black,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(28.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.icon_dropdown),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                            .rotate(if (boolean) 180f else 0f)
                            .padding(top = 10.dp, bottom = 10.dp, end = 7.dp, start = 7.dp),
                    tint = Color.Black)
                }
            }
        }
    }

    @Composable
    fun QuizBottomContent(onClick: () -> Unit) {
        Surface(
            shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp),
            color = Color.White
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(18.dp)
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(72.dp)
                    .height(10.dp)
                    .background(Color(0xFF787878)))
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Apakah anda yakin ingin mengumpulkan quiz ini ?",
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    fontSize = 16.sp)
                Spacer(modifier = Modifier.height(40.dp))
                Surface(
                    shape = RoundedCornerShape(35.dp),
                    color = MaterialTheme.colors.primary,
                    elevation = 6.dp
                ) {
                    Text(text = "Ya",
                        style = MaterialTheme.typography.h4,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, start = 30.dp, end = 30.dp))
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(text = "Batalkan",
                    style = MaterialTheme.typography.h1,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable { onClick.invoke() }
               )
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun QuestionDropDown(show:MutableState<Boolean>,indexClick:(Int) -> Unit) {
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape( 15.dp))) {
            DropdownMenu(expanded = show.value, onDismissRequest = { show.value = false }, modifier =
            Modifier
                .width(326.dp)) {
                Row (
                    modifier = Modifier
                        .padding(18.dp)
                ) {
                    for (i in 0..1) {
                        Surface(
                            shape = RoundedCornerShape(5.dp),
                            color = Color(0xFFBEBCBC),
                            onClick = {
                                indexClick.invoke(i)
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
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun Question(
        title:String,
        answer:List<String>,
        backAppear:Boolean,
        nextAppear:Boolean,
        next:() -> Unit,
        back:() -> Unit
    ) {

        val currentIndex = remember  {
            mutableStateOf<Int?>(null)
        }

        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFD9D9D9),
                elevation = 8.dp
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Surface(
                        color = Color(0xFFA2A2A2),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 8.dp
                    ) {
                        Text(text = title,
                            modifier = Modifier
                                .width(235.dp)
                                .padding(start = 11.dp, top = 9.dp, bottom = 9.dp),
                            style = MaterialTheme.typography.h3,
                            color = Color.Black,
                            fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    answer.forEachIndexed { index, answer ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (index == currentIndex.value),
                                    onClick = {
                                        currentIndex.value = index
                                    }
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            RadioButton(
                                selected = (index == currentIndex.value),
                                onClick = { currentIndex.value = index },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colors.primary,
                                    unselectedColor = Color.Black
                                ),
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = answer,
                                style = MaterialTheme.typography.body1,
                                fontSize = 12.sp,
                                color = if (index == currentIndex.value) MaterialTheme.colors.primary else Color.Black,
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colors.primary,
                    elevation = 8.dp,
                    onClick = {
                        if (backAppear)back.invoke()
                    }
                ) {
                    Text(text = "Back",
                        modifier = Modifier
                            .padding(start = 24.dp, end = 24.dp, top = 6.dp, bottom = 6.dp),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.h4,
                        color = Color.White)
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colors.primary,
                    elevation = 8.dp,
                    onClick = {
                        if (nextAppear) next.invoke()

                    }
                ) {
                    Text(text = "Next",
                        modifier = Modifier
                            .padding(start = 24.dp, end = 24.dp, top = 6.dp, bottom = 6.dp),
                        fontSize = 12.sp,
                        style = MaterialTheme.typography.h4,
                        color = Color.White)
                }
            }
        }
    }
}