package com.example

enum class ProjectDataClass(
    val title: String,
    val date: String,
    val description: String,
    val content: List<String>,
    val storeUrl: String,
    val usedSkill: String
) {
    BOOMBIM(
        title = "붐빔(Boom Bim)",
        date = "2025.08.01 ~ 2025.09.07",
        description = "사용자에게 지도를 통해 혼잡도를 보여주는 앱",
        content = listOf("소셜로그인을 활용한 사용자 인증", "카카오맵 연동 및 마커,클러스터링 표시","FCM을 통한 알림 연동","마이페이지 및 Api 연결"),
        storeUrl = "https://play.google.com/store/apps/details?id=com.boombim.android&hl=ko",
        usedSkill = "Kotlin, MVVM, Clean Architecture, Coroutine/Flow, Hilt(DI), Retrofit, Kakao Map SDK, Firebase FCM, Kakao Search Api"
    ),
    AUDI(
    title = "어디(Audi)",
    date = "2025.02.01 ~ 2025.05.01",
    description = "모임.일정을 정하고 알림을 제공하는 모임 관리 앱",
    content = listOf("카카오.네이버를 활용한 사용자 인증", "버전 비교를 통한 앱 업데이트 관리","Fcm을 통한 앱 데이터 갱신 및 알림 연동","설정 기능 관련 Api 연동"),
    storeUrl = "https://play.google.com/store/apps/details?id=com.audiwhere.android&hl=ko",
        usedSkill = "MVVM, Retrofit, okhttp, Fcm, Gson, Flow, Coroutine, Room, Datastore, Glide, Hilt, Navigation"
    ),

    STUDYMATE(
    title = "스터디메이트(StudyMate)",
    date = "2024.04.01 ~ 2025.01.01",
    description = "멘토.멘티 매칭 및 채팅,화상미팅을 통한 학습 도움 플랫폼",
    content = listOf("게시판 기능", "SSE를 사용한 매칭 요청 알림","멘토 멘티간의 실시간 채팅 기능"),
    storeUrl = "https://play.google.com/store/apps/details?id=com.studymate154.studymate&hl=ko",
        usedSkill = "Retrofit, okhttp, Coroutine, Stomp, EventSource, SharedPreferences, Glide"
    )
}
