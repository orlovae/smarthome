package ru.alexandrorlov.surf_test.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val SurfTestTypography = Typography(

    titleLarge = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 48.sp,
        color = Color.Black
    ),
    titleMedium = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        color = FontLightGray
    ),
    titleSmall = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 38.sp,
        color = Color.Black
    ),
    bodyLarge = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = didactGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        color = Color.Black
    ),

)