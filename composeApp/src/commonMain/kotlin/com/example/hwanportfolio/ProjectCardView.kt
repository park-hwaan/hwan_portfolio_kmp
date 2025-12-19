package com.example.hwanportfolio

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
        modifier = Modifier.fillMaxWidth().padding(vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("PROJECTS", fontSize = 60.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(40.dp))

        FlowRow(
            modifier = Modifier.widthIn(max = 1200.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
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

    Surface(
        modifier = Modifier
            .padding(16.dp)
            .width(450.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Surface(
                color = Color(0xFFDA54E8),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = project.title,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = project.date, fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFEEEEEE)))
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = project.description,
                fontSize = 18.sp,
                fontFamily = FontFamily,
                fontWeight = FontWeight.Bold,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

           project.content.forEach { list->
               ProjectBulletPoint(list)
           }

            Spacer(modifier = Modifier.height(8.dp))

            ClickableText(
                text = AnnotatedString(project.storeUrl),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp,
                    color = Color(0xFF1E88E5),
                    textDecoration = TextDecoration.Underline
                ),
                onClick = {
                    uriHandler.openUri(project.storeUrl)
                }
            )
        }
    }
}

@Composable
fun ProjectBulletPoint(text: String) {
    Row{
        Text("• ", fontWeight = FontWeight.Bold)
        Text(text, fontSize = 14.sp, color = Color.DarkGray)
    }
}