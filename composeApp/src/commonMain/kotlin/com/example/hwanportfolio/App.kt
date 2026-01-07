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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import hwanportfolio.composeapp.generated.resources.icon_calender
import hwanportfolio.composeapp.generated.resources.icon_graduate
import hwanportfolio.composeapp.generated.resources.icon_mail
import hwanportfolio.composeapp.generated.resources.icon_person
import hwanportfolio.composeapp.generated.resources.icon_phone_call
import hwanportfolio.composeapp.generated.resources.icon_place
import hwanportfolio.composeapp.generated.resources.image_computer_brown
import hwanportfolio.composeapp.generated.resources.image_profile
import hwanportfolio.composeapp.generated.resources.image_title_background
import org.jetbrains.compose.resources.DrawableResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.White)
        ) {
            item { TitleSection() }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF8F9FA))
                ) {
                    Column {
                        AboutTitleSection()
                    }
                }
            }

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
            painter = painterResource(Res.drawable.image_computer_brown),
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
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "안녕하세요.\n끈기있는 안드로이드 개발자\n박환입니다.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily,
                fontWeight = FontWeight.Thin,
                color = Color(0xFFFECECEC)
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
        Box(modifier = Modifier.width(270.dp).height(2.dp).background(Color.LightGray))
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .widthIn(max = 1100.dp)
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // 1. 증명 사진 영역
            Image(
                painter = painterResource(Res.drawable.image_profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(250.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(60.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    AboutItem(Res.drawable.icon_person, "이름", "박환", Modifier.weight(1f))
                    AboutItem(Res.drawable.icon_calender, "생년월일", "00.11.29", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    AboutItem(Res.drawable.icon_place, "주소", "서울특별시 강동구", Modifier.weight(1f))
                    AboutItem(Res.drawable.icon_phone_call, "연락처", "010-7557-5986", Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    AboutItem(Res.drawable.icon_mail, "이메일", "pahw001129@naver.com", Modifier.weight(1f))
                    AboutItem(Res.drawable.icon_graduate, "학력", "한국공학대학교\n(컴퓨터공학부)", Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun AboutItem(icon: DrawableResource,title: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.width(270.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
           Icon(
               painterResource(icon),
               contentDescription = null,
               modifier = Modifier.size(30.dp),
               tint = Color.Unspecified
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




