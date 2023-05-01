package com.example.introvertquiz.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.introvertquiz.R

// Set of Material typography styles to start with
val fontFamily = FontFamily(
    Font(R.font.quicksand_regular, weight = FontWeight.Thin),
    Font(R.font.nunito_bold, weight = FontWeight.ExtraBold),
    Font(R.font.roboto_bold, weight = FontWeight.Black),
    Font(R.font.nunito_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_bold, weight = FontWeight.Bold),
    Font(R.font.robot_regular, weight = FontWeight.Normal),
    Font(R.font.quick_sand_light,weight = FontWeight.Light),
    Font(R.font.roboto_light,weight = FontWeight.ExtraLight),
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Thin
    ),
    h1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium
    ),
    h3 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Black
    ),
    h4 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraBold
    ),
    h5 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Black,
        textDecoration = TextDecoration.Underline
    ),
    caption = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraLight
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)