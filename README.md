# 1주차 YouTube 홈 화면

- 실행화면
![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fef567cb-1d55-44b9-ae74-ef97cfabdd03/Untitled.png)

- 새로 알게 된 오류와 기능
1. 버튼 drawble이 먹히지 않음
→ [https://curryyou.tistory.com/398](https://curryyou.tistory.com/398) 로 해결

2. 버튼 안에 text와 icon 같이 담기
→ <Button>의 drawableLeft 속성: 왼편에 아이콘 넣음
→ 아이콘이 너무 클 경우 size조절 xml로 만들어 넣음
→ [https://ddolcat.tistory.com/86](https://ddolcat.tistory.com/86)

3. 액션바 제거하기
→ res/values/themes.xml 에서 `<style name="앱이름" parent="Theme.AppCompat.DayNight.NoActionBar">` 로 변경

-좀 더 수정해야할 것

1. 본문의 유튜브 영상+구독정보 스크롤뷰로 내리기 위해 한가지 태그 사용
→ Linear안 VideoView랑 TableLayout이용하기..

2. 동영상뷰 위에 영상 시간 겹치기
→ FrameLayout이용해 중첩

3. 채널계정 - 원형이미지뷰로
→ [https://jeong9216.tistory.com/9](https://jeong9216.tistory.com/9) 참고
