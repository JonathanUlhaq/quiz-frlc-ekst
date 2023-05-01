package com.example.introvertquiz.components

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introvertquiz.R

class TaskComponent {

    @Composable
    fun TaskStatus(
        borderStroke: BorderStroke,
        color: Color,
        text:String
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = color,
            border = borderStroke,
            elevation = 8.dp
        ) {
            Text(text = text,
                style = MaterialTheme.typography.h4,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 6.dp, bottom = 6.dp, end = 16.dp, start = 16.dp))
        }
    }

    @Composable
    fun FolderCard(
        modifier: Modifier = Modifier
    ) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            elevation = 8.dp,
            color = Color.White,
            contentColor = MaterialTheme.colors.primary,
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, end = 18.dp, start = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.documnet_icon),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary)
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Tugas 01_13011914116.pdf",
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.primary,
                        fontSize = 14.sp)
                }

                Icon(painter = painterResource(id = R.drawable.download_icon),
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary)
            }
        }
    }
}