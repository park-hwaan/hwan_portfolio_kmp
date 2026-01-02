package com.example.hwanportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ContentDetail
import com.example.FontFamily
import com.example.ProjectDataClass
import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.icon_close
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReadMeDialog(project: ProjectDataClass, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // 상단 헤더 및 기본 정보 섹션
                TitleAndInfoSection(project, onDismiss)

                // 중간 구분선 및 "개발기능"
                DevelopmentHeader()

                // 상세 기능 섹션 (세로로 하나씩 나열)
                Column(
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    project.contentDetail.forEach { detail ->
                        VerticalDetailBlock(detail)
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
fun TitleAndInfoSection(project: ProjectDataClass, onDismiss: () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = project.title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            IconButton(
                onClick = { onDismiss() },
                modifier = Modifier.align(Alignment.CenterEnd).size(32.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.icon_close),
                    contentDescription = "닫기",
                    tint = Color.Black
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(top = 16.dp),
            thickness = 1.dp,
            color = Color(0xFFEEEEEE)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.date, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = project.participants, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun DevelopmentHeader() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 40.dp, start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "개발기능",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp),
            thickness = 1.dp,
            color = Color(0xFFEEEEEE)
        )
    }
}

@Composable
fun VerticalDetailBlock(detail: ContentDetail) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // 소제목 (예: 사용자 인증)
        Text(
            text = detail.featTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // 불렛 포인트 리스트 (세로 나열)
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            detail.featDetail.forEach { text ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "• ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFE91E63)
                    )
                    Text(
                        text = text,
                        fontSize = 15.sp,
                        color = Color(0xFF333333),
                        lineHeight = 22.sp
                    )
                }
            }
        }
    }
}