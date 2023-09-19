package ru.alexandrorlov.smarthome.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val SHTypography = Typography(
    //TopBarTitle
    titleLarge = TextStyle(
        fontFamily = CircleFamily,
        fontWeight = FontWeight.W400,
        fontSize = 21.sp,
        lineHeight = 32.sp,
        color = fontPrimary
    ),
    //Tab
    titleMedium = TextStyle(
        fontFamily = CircleFamily,
        fontWeight = FontWeight.W400,
        fontSize = 17.sp,
        lineHeight = 16.sp,
        color = fontPrimary,
    ),
    //
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    //C
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = Color.Black,
    ),
    //
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = Color.Black,
    ),
    //REC
    bodyLarge = TextStyle(
        fontFamily = CircleFamily,
        fontWeight = FontWeight.W400,
        fontSize = 8.sp,
        lineHeight = 12.sp,
        color = fontItemRecord,
    ),
    //Card body
    bodyMedium = TextStyle(
        fontFamily = CircleFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
        lineHeight = 26.sp,
        color = fontPrimary,
    ),
    //
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = Color.Black,
    ),
)