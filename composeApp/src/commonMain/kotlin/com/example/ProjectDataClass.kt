package com.example

enum class ProjectDataClass(
    val title: String,
    val date: String,
    val description: String,
    val content: List<String>,
    val storeUrl: String
) {
    BOOMBIM(
        title = "붐빔",
        date = "2025.05.01 ~ 2025.06.01",
        description = "사용자에게 혼잡도를 보여주는 앱입니다",
        content = listOf("로그인 기능", "카카오맵 연결 및 마커 핀 표시"),
        storeUrl = "https://play.google.com/store/apps/details?id=com.boombim.android&hl=ko"
    ),
    AUDI(
    title = "어디",
    date = "2025.05.01 ~ 2025.06.01",
    description = "사용자에게 혼잡도를 보여주는 앱입니다",
    content = listOf("로그인 기능", "카카오맵 연결 및 마커 핀 표시"),
    storeUrl = "https://play.google.com/store/apps/details?id=com.audiwhere.android&hl=ko"
    ),

    STUDYMATE(
    title = "스터디메이트",
    date = "2025.05.01 ~ 2025.06.01",
    description = "사용자에게 혼잡도를 보여주는 앱입니다",
    content = listOf("로그인 기능", "카카오맵 연결 및 마커 핀 표시"),
    storeUrl = "https://play.google.com/store/apps/details?id=com.studymate154.studymate&hl=ko"
    )
}
