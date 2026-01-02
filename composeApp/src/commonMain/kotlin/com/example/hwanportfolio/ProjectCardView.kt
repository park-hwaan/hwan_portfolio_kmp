package com.example.hwanportfolio

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FontFamily
import com.example.ProjectDataClass
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun AppPreview() {
  ProjectSection()
}

@Composable
fun ProjectSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 80.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 타이틀 강조 및 하단 선 추가
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "PROJECTS",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 2.sp
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(250.dp)
                    .height(4.dp)
                    .background(Color(0xFFE91E63))
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        // FlowRow 간격(Gap) 추가
        FlowRow(
            modifier = Modifier.widthIn(max = 1200.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            maxItemsInEachRow = 3
        ) {
            ProjectCard(ProjectDataClass.BOOMBIM)
            ProjectCard(ProjectDataClass.AUDI)
            ProjectCard(ProjectDataClass.STUDYMATE)
        }
    }
}

@Composable
fun ProjectCard(project: ProjectDataClass) {
    val uriHandler = LocalUriHandler.current
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        ReadMeDialog(
            project = project,
            onDismiss = { showDialog = false }
        )
    }

    Surface(
        modifier = Modifier
            .widthIn(min = 400.dp, max = 550.dp),
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 4.dp,
        color = Color.White,
        border = BorderStroke(1.dp, Color(0xFFF0F0F0))
    ) {
        Column(
            modifier = Modifier.padding(32.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Surface(
                color = Color(0xFFE91E63).copy(alpha = 0.1f),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = project.title,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    color = Color(0xFFE91E63),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 메인 설명 (폰트 크기 조절)
            Text(
                text = project.description,
                fontSize = 22.sp,
                fontFamily = FontFamily,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 30.sp,
                color = Color(0xFF222222)
            )

            Text(
                text = project.date,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFF5F5F5)))
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "담당기능",
                fontSize = 15.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 담당 기능 리스트 간격 조정
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                project.content.forEach { list ->
                    ProjectBulletPoint(list)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 스토어 링크
            ClickableText(
                text = AnnotatedString("View on PlayStore"),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E88E5),
                    textDecoration = TextDecoration.Underline
                ),
                onClick = { uriHandler.openUri(project.storeUrl) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Tech Stack",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            //기술 스택
            Surface(
                color = Color(0xFFF8F9FA),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFECEFF1))
            ) {
                Text(
                    text = project.usedSkill,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    color = Color(0xFF455A64),
                    fontSize = 13.sp,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.dp, color = Color.Black),
                onClick = {
                    showDialog = true
                }
            ) {
                Text(
                    text = "ReadMe",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    color = Color.Black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ProjectBulletPoint(text: String) {
    Row(verticalAlignment = Alignment.Top) {
        Text("• ", color = Color(0xFFE91E63), fontWeight = FontWeight.Black)
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF444444),
            lineHeight = 20.sp
        )
    }
}