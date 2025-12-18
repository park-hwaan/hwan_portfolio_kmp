package com.example

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.pretendard_bold
import hwanportfolio.composeapp.generated.resources.pretendard_medium
import hwanportfolio.composeapp.generated.resources.pretendard_regular
import hwanportfolio.composeapp.generated.resources.pretendard_semibold
import hwanportfolio.composeapp.generated.resources.pretendard_thin

val FontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(resource = Res.font.pretendard_medium, weight = FontWeight.Medium),
        Font(resource = Res.font.pretendard_semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.pretendard_thin, weight = FontWeight.Thin),
        Font(resource = Res.font.pretendard_bold, weight = FontWeight.Bold)

    )
