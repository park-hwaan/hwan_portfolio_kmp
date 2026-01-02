package com.example.hwanportfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.FontFamily
import com.example.ProjectDataClass
import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.icon_close
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReadMeDialog(project: ProjectDataClass,onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false // 기본 너비 제한 해제
        )
    ) {
        TitleSection(project, onDismiss)
    }
}

@Composable
fun TitleSection(project: ProjectDataClass,onDismiss: () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.85f) // 가로 85% 차지
            .fillMaxHeight(0.66f), // 세로 2/3(약 66%) 차지
        shape = RoundedCornerShape(24.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = project.title,
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = { onDismiss() },
                    modifier = Modifier.align(Alignment.CenterEnd).width(25.dp).height(25.dp) // 오른쪽 끝 중앙 정렬
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.icon_close),
                        contentDescription = "닫기",
                        tint = Color.Gray
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(top = 12.dp), // 텍스트와의 간격
                thickness = 1.dp, // 선의 굵기
                color = Color(0xFFEEEEEE) // 옅은 회색
            )
        }
    }
}