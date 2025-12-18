package com.example.hwanportfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FontFamily
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.image_title_background

@Composable
@Preview
fun App() {
    MaterialTheme {
        // 1. 전체를 위에서 아래로 배치하기 위한 최상위 Column 추가
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // 2. 상단 배경 이미지 영역 (Box)
            Box(modifier = Modifier.fillMaxWidth().height(400.dp)) {
                Image(
                    painter = painterResource(Res.drawable.image_title_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeContentPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "박환\n안드로이드 개발자 포트폴리오",
                        color = Color.Black,
                        fontSize = 45.sp,
                        lineHeight = 52.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "안녕하세요.\n끊기있는 안드로이드 개발자\n박환입니다.",
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily,
                        fontWeight = FontWeight.Thin
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 40.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ABOUT ME",
                    color = Color.Black,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily
                )
            }
        }
    }
}