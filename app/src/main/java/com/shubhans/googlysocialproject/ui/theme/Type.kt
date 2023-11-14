package com.shubhans.googlysocialproject.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shubhans.googlysocialproject.R

val quicksand = FontFamily(
    Font(R.font.quicksand_light,FontWeight.Light),
    Font(R.font.quicksand_regular,FontWeight.Normal),
    Font(R.font.quicksand_medium,FontWeight.Medium),
    Font(R.font.quicksand_semibold,FontWeight.SemiBold),
    Font(R.font.quicksand_bold,FontWeight.Bold)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 24.sp,
        color = Color.White,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    )

)