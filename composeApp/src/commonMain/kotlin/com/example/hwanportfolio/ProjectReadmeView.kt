package com.example.hwanportfolio

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ContentDetail
import com.example.FontFamily
import com.example.ProjectDataClass
import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.icon_close
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.text.chunked

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

                Spacer(modifier = Modifier.height(40.dp))

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

                ExecutionScreenSection(project.screenShots)

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun TitleAndInfoSection(project: ProjectDataClass, onDismiss: () -> Unit) {
    val uriHandler = LocalUriHandler.current

    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = project.title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily,
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
            modifier = Modifier.padding(top = 24.dp),
            thickness = 1.dp,
            color = Color(0xFFEEEEEE)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {

            //프로젝트 기간
            Text(text = project.date, fontSize = 14.sp, color = Color.Gray, fontFamily = FontFamily)

            //프로젝트 참여인원
            Text(text = project.participants, fontSize = 14.sp, color = Color.Gray, fontFamily = FontFamily)

            // 스토어 링크
            ClickableText(
                text = AnnotatedString("Github Link"),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E88E5),
                    textDecoration = TextDecoration.Underline
                ),
                onClick = { uriHandler.openUri(project.githubLink) }
            )
        }
    }
}

@Composable
fun DevelopmentHeader() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "개발기능",
            fontSize = 26.sp,
            fontFamily = FontFamily,
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

        Text(
            text = detail.featTitle,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )


        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            detail.featDetail.forEach { text ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "• ",
                        fontSize = 15.sp,
                        fontFamily = FontFamily,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFFE91E63)
                    )
                    Text(
                        text = text,
                        fontSize = 15.sp,
                        fontFamily = FontFamily,
                        color = Color(0xFF333333),
                        lineHeight = 22.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ExecutionScreenSection(screenShots: List<DrawableResource>) {
    var isLoaded by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(targetValue = if (isLoaded) 1f else 0f, animationSpec = tween(500))
    val scale by animateFloatAsState(targetValue = if (isLoaded) 1f else 0.95f, animationSpec = tween(500))

    if (screenShots.isEmpty()) return

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "실행화면",
            fontSize = 24.sp,
            fontFamily = FontFamily,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        HorizontalDivider(
            modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
            thickness = 1.dp,
            color = Color(0xFFEEEEEE)
        )

        Spacer(modifier = Modifier.height(32.dp))

        val chunkedScreenshots = screenShots.chunked(7)

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            chunkedScreenshots.forEach { rowItems ->
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(rowItems) { res ->
                        Surface(
                            modifier = Modifier.width(140.dp).height(300.dp),
                            shape = RoundedCornerShape(16.dp),
                            shadowElevation = 8.dp,
                            color = Color.White
                        ) {
                            Image(
                                painter = painterResource(res), // res는 DrawableResource
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                }
            }
        }
    }
}

