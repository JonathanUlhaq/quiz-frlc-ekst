package com.example.introvertquiz.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceAround
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.introvertquiz.R

class DashboardDialog {

    @Composable
    fun SearchDropDown(
        boolean:MutableState<Boolean>,
        text:MutableState<String>
    ) {
        Dialog(onDismissRequest = { boolean.value = false }) {
            Column {
                TextField(value = text.value , onValueChange = {text.value = it},
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        trailingIconColor = Color.Black
                    ),
                    trailingIcon = {
                        IconButton(onClick = { boolean.value = false }) {
                            Icon(painter = painterResource(id = R.drawable.close_icon),
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(14.dp))
                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(270.dp)
                ) {

                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun CourseDropDown(show: MutableState<Boolean>) {
        val listTitle = listOf(
            "Download course",
            "Remove from view",
            "Star this course"
        )
        val listIcon = listOf(
            R.drawable.download_source_icon,
            R.drawable.remove_from_view_icon,
            R.drawable.star_icon
        )
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(15.dp))) {
            DropdownMenu(expanded = show.value, onDismissRequest = { show.value = false }) {
                Column(
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp)
                ) {
                    listTitle.forEachIndexed { index, item ->
                           Row(
                               verticalAlignment = CenterVertically,
                               modifier = Modifier
                                   .width(186.dp)
                                   .padding(start = 20.dp, top = 2.dp, bottom = 2.dp)
                                   .clickable { show.value = false },

                               
                           ) {
                               Icon(
                                   painter = painterResource(id = listIcon[index]),
                                   contentDescription = null,
                                   tint = Color.Black,
                                   modifier = Modifier
                                       .size(26.dp)
                                       .padding(end = 12.dp)
                               )

                               Text(
                                   text = item,
                                   fontSize = 12.sp,
                                   style = MaterialTheme.typography.body2,
                                   color = Color.Black,
                                   textAlign = TextAlign.Start
                               )
                           }


                        if (index < 2) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Divider(color = Color.LightGray)
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }


            }
        }

    }

    @Composable
    fun TaskDropdown(show: MutableState<Boolean>) {
        val listOption = listOf(
            "All",
            "Overdue",
            "Next 3 Days",
            "Next 7 Days",
            "Next 14 Days",
            "Next 1 Month",
            "Next 2 Month",
            "Next 4 Month"
        )
        val currentIndex = remember {
            mutableStateOf(0)
        }
        MaterialTheme(shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(15.dp))) {
            DropdownMenu(expanded = show.value, onDismissRequest = { show.value = false }) {
                Column(
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 1.dp)

                ) {

                    listOption.forEachIndexed { index, item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (index == currentIndex.value),
                                    onClick = {
                                        currentIndex.value = index
                                    }
                                )
                                .width(180.dp)
                                .padding(start = 8.dp, end = 14.dp),
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = SpaceBetween
                        ) {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.h4,
                                fontSize = 14.sp,
                                color = if (index == currentIndex.value) MaterialTheme.colors.primary else Color.Black
                            )

                            RadioButton(
                                selected = (index == currentIndex.value),
                                onClick = { currentIndex.value = index },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colors.primary,
                                    unselectedColor = Color.Black
                                ),
                                modifier = Modifier.size(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}