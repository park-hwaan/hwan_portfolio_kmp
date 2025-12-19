package com.example.hwanportfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
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
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { TitleSection() }
            item { Spacer(modifier = Modifier.height(40.dp)) }
            item { AboutTitleSection() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { ProjectSection() }
        }
    }

}

@Composable
fun TitleSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
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
            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "박환\n안드로이드 개발자 포트폴리오",
                fontSize = 45.sp,
                lineHeight = 52.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "안녕하세요.\n끈기있는 안드로이드 개발자\n박환입니다.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily,
                fontWeight = FontWeight.Thin
            )
        }
    }
}

@Composable
fun AboutTitleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ABOUT ME",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily
        )

        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.width(250.dp).height(2.dp).background(Color.LightGray))
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .widthIn(max = 1000.dp)
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                AboutItem("이름", "박환", Modifier.weight(1f))
                AboutItem("생년월일", "00.11.29", Modifier.weight(1f))
                AboutItem("주소", "서울특별시 강동구", Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                AboutItem("연락처", "010-7557-5986", Modifier.weight(1f))
                AboutItem("이메일", "pahw001129@naver.com", Modifier.weight(1f))
                AboutItem("학력", "한국공학대학교\n(컴퓨터공학부)", Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun AboutItem(title: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.width(250.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, shape = androidx.compose.foundation.shape.CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = FontFamily
                )
                Text(
                    text = value,
                    fontSize = 17.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 18.sp
                )
            }
        }
    }
}




