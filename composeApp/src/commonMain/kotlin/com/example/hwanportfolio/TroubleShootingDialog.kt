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
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ContentDetail
import com.example.FontFamily
import com.example.ProjectDataClass
import hwanportfolio.composeapp.generated.resources.Res
import hwanportfolio.composeapp.generated.resources.icon_bulb
import hwanportfolio.composeapp.generated.resources.icon_close
import hwanportfolio.composeapp.generated.resources.icon_right_arrow
import hwanportfolio.composeapp.generated.resources.icon_warning
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.text.chunked

@Composable
fun TroubleShootingDialog(project: ProjectDataClass, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.85f),
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 상단 타이틀
                Text(
                    text = "트러블슈팅",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily
                )

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(thickness = 1.dp, color = Color.Black)
                Spacer(modifier = Modifier.height(40.dp))

                val ts = project.troubleShooting

                // 문제 배경 및 해결 방법 (중앙 아이콘 섹션)
                Row(
                    modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 문제 배경
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.icon_warning), // 경고 아이콘 리소스
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = Color.Unspecified
                        )
                        Text("문제 배경", fontFamily = FontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 12.dp))
                        Text(ts.problem, fontFamily = FontFamily, textAlign = TextAlign.Center, fontSize = 15.sp, color = Color.Black, lineHeight = 22.sp)
                    }

                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.icon_right_arrow),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color.Black
                        )
                    }

                    // 해결 방법
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.icon_bulb), // 전구 아이콘 리소스
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = Color.Unspecified
                        )
                        Text("해결 방법", fontFamily = FontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(vertical = 12.dp))
                        Text(ts.solution, fontFamily = FontFamily, textAlign = TextAlign.Center, fontSize = 15.sp, color = Color.Black, lineHeight = 22.sp)
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))

                // 하단 결과 섹션
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF8F9FA), RoundedCornerShape(12.dp))
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("코드 개선 사항 & 효과", fontFamily = FontFamily, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
                    Spacer(modifier = Modifier.height(20.dp))

                    // 구분선
                    Box(modifier = Modifier.width(300.dp).height(2.dp).background(Color.Black))

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = ts.effect,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        lineHeight = 26.sp,
                        fontFamily = FontFamily
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // 결과 강조 버튼 스타일
                    Surface(
                        color = Color(0xFF222222),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "개선효과: 마커 생성 속도 3초 -> 1.5초",
                            color = Color.White,
                            fontFamily = FontFamily,
                            modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}