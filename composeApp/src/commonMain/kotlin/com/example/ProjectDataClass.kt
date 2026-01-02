package com.example

data class ContentDetail(
    val featTitle: String,
    val featDetail: List<String>
)

enum class ProjectDataClass(
    val title: String,
    val date: String,
    val description: String,
    val content: List<String>,
    val participants: String,
    val storeUrl: String,
    val usedSkill: String,
    val contentDetail: List<ContentDetail>
) {
    BOOMBIM(
        title = "붐빔(Boom Bim)",
        date = "2025.08.01 ~ 2025.09.07",
        description = "사용자에게 지도를 통해 혼잡도를 보여주는 앱",
        content = listOf("소셜로그인을 활용한 사용자 인증", "카카오맵 연동 및 마커,클러스터링 표시","FCM을 통한 알림 연동","마이페이지 및 Api 연결"),
        participants = "7인 프로젝트(PM 1, BackEnd 2, Designer 2, Aos 1, Ios 1)",
        storeUrl = "https://play.google.com/store/apps/details?id=com.boombim.android&hl=ko",
        usedSkill = "MVVM, Clean Architecture, Coroutine/Flow, Hilt(DI), Retrofit, Kakao Map SDK, Firebase FCM, Kakao Search Api, Glide, Navigation",
        contentDetail = listOf(
            ContentDetail(
                featTitle = "사용자 인증",
                featDetail = listOf(
                    "카카오/네이버 SDK를 활용한 OAUTH2 기반 소셜 로그인 구현",
                    "DATASTORE 기반 사용자 설정 및 로그인 상태 관리",
                    "FLOW 기반으로 로그인 상태를 관찰하여 UI 상태를 실시간으로 동기화"
                )
            ),
            ContentDetail(
                featTitle = "홈 화면",
                featDetail = listOf(
                    "RECYCLERVIEW + VIEWTYPE을 활용한 다중 뷰 타입 리스트 구성",
                    "DIFFUTIL을 적용하여 리스트 갱신 시 불필요한 UI 리렌더링 최소화"
                )
            ),
            ContentDetail(
                featTitle = "알림 연동",
                featDetail = listOf(
                    "FIREBASE CLOUD MESSAGING 기반 푸시 알림 수신",
                    "알림 수신 시 RECYCLERVIEW 실시간 갱신 처리"
                )
            ),
            ContentDetail(
                featTitle = "지도 연동",
                featDetail = listOf(
                    "KAKAO MAPS SDK 기반 지도 화면 구현",
                    "마커 클릭 시 BOTTOMSHEET로 상세 정보 노출",
                    "줌 레벨에 따른 마커 렌더링 최적화 적용"
                )
            ),
            ContentDetail(
                featTitle = "마이페이지",
                featDetail = listOf(
                    "RETROFIT + COROUTINE 기반 비동기 API 통신",
                    "프로필 수정 -> 서버 반영 -> 화면 즉시 갱신까지 단방향 데이터 흐름으로 처리"
                )
            )
        )
    ),
    AUDI(
        title = "어디(Audi)",
        date = "2025.02.01 ~ 2025.05.01",
        description = "모임.일정을 정하고 알림을 제공하는 모임 관리 앱",
        content = listOf("카카오.네이버를 활용한 사용자 인증", "버전 비교를 통한 앱 업데이트 관리","Fcm을 통한 앱 데이터 갱신 및 알림 연동","설정 기능 관련 Api 연동"),
        participants = "8인 프로젝트(BackEnd 2, Designer 2, Aos 2, Ios 2)",
        storeUrl = "https://play.google.com/store/apps/details?id=com.audiwhere.android&hl=ko",
        usedSkill = "MVVM, Retrofit, okhttp, Fcm, Flow, Coroutine, Room, Datastore, Glide, Hilt, Navigation",
        contentDetail = listOf(
            ContentDetail(
                featTitle = "사용자 인증",
                featDetail = listOf(
                    "네이버, 카카오 SDK를 활용해 간편 로그인 및 회원가입 처리",
                    "각 소설의 ACCESS TOKEN과 REFRESH TOKEN을 서버에 전송하여 검증 후, 서버에서 새롭게 발급받은 토큰을 DATASTORE에 저장 및 관리"
                )
            ),
            ContentDetail(
                featTitle = "앱 업데이트",
                featDetail = listOf(
                    "서버에서 최신 앱 버전을 받아 현재 버전과 비교",
                    "SPLASH 화면에서 버전이 낮은 경우 강제 업데이트를 유도하여 최신 버전 유지"
                )
            ),
            ContentDetail(
                featTitle = "설정 기능",
                featDetail = listOf(
                    "알림 설정, FAQ, 공지사항, 계정 설정 등 다양한 설정 기능과 API 연동",
                    "사용자 맞춤형 설정과 앱 관리 기능 제공"
                )
            ),
            ContentDetail(
                featTitle = "알림 연동",
                featDetail = listOf(
                    "FCM을 통해 상황별 알림을 수신하고, 이를 기반으로 NOTIFICATION을 표시",
                    "포그라운드 상태에서는 FCM 데이터로 앱 내 데이터를 실시간 갱신 및 상태 관리",
                    "수신한 FCM 알림 데이터를 ROOM에 저장하여 알림 목록으로 제공"
                )
            )
        )
    ),

    STUDYMATE(
    title = "스터디메이트(StudyMate)",
    date = "2024.04.01 ~ 2025.01.01",
    description = "멘토.멘티 매칭을 통한 학습 도움 플랫폼",
    content = listOf("게시판 기능", "SSE를 사용한 매칭 요청 알림","멘토 멘티간의 실시간 채팅 기능"),
        participants = "5인 프로젝트(BackEnd 2, Aos 1, FrontEnd 2)",
    storeUrl = "https://play.google.com/store/apps/details?id=com.studymate154.studymate&hl=ko",
        usedSkill = "Retrofit, okhttp, Coroutine, Stomp, EventSource, SharedPreferences, Glide",
        contentDetail = listOf(
            ContentDetail(
                featTitle = "게시판",
                featDetail = listOf(
                    "게시글 작성, 조회, 삭제 기능 제공",
                    "검색 기능: SEARCHVIEW를 활용하여 게시물 제목이나 내용을 검색",
                    "카테고리 필터링: FILTER를 사용하여 게시물을 카테고리별로 구분 및 조회"
                )
            ),
            ContentDetail(
                featTitle = "매칭 요청 알림",
                featDetail = listOf(
                    "실시간 알림 수신: SSE(SERVER-SENT EVENTS) 연결을 통해 매칭 요청 및 다양한 상황별 알림을 실시간으로 수신"
                )
            ),
            ContentDetail(
                featTitle = "채팅 기능",
                featDetail = listOf(
                    "실시간 채팅: STOMP 라이브러리를 사용해 상대방과 같은 채팅방에서 실시간 대화",
                    "자동 채팅방 연결: 멘토와 매칭 시 자동으로 해당 채팅방 정보를 불러와 접속",
                    "연결 안정성 강화: 채팅방 연결이 끊어질 경우 5초마다 자동으로 재연결을 시도하는 RECONNECT 함수 구현"
                )
            )
        )
    )
}
