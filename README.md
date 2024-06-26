# icecream 1.0
**아이스크림 주문 포스기** 입니다.<br><br><br>

### 개발 기간
* 2023.08.01 ~ 2023.08.15 (약 2주)<br><br>

### 개발 환경
* Java 11
* **프레임워크** : Spring5(Maven)
* **데이터베이스** : mysql - jdbcTemplate
* **프론트** : JSP, javascript, jQuery<br><br>

### 특징
* 장바구니에 담긴 아이스크림들이 한 줄의 문자열로 보내짐
* 컨트롤러에서 받은 문자열을 다시 분해해서 주문을 생성함(insert)

### 기능 소개
<details><summary><b>아이스크림 담기</b></summary>
  <div>
    <img src="icecream/WebContent/스크린샷 2024-06-12 145442.png">
  </div>
</details>

     * 아이스크림 한 종류와 토핑(0개 또는 여러개)을 선택하고 담기 버튼을 누르면 장바구니에 추가됨
     
<details><summary><b>주문하기</b></summary>
  <div>
    <img src="icecream/WebContent/스크린샷 2024-06-12 150051.png">
  </div>
</details>

     * 장바구니에 담긴 아이스크림들이 주문 결정됨

<details><summary><b>이전 주문 내역</b></summary>
  <div>
    <img src="icecream/WebContent/스크린샷 2024-06-12 150413.png">
  </div>
</details>

     * 주문 상세 내역이 최신순으로 정렬됨

<details><summary><b>관리</b></summary>
  <div>
    <img src="icecream/WebContent/스크린샷 2024-06-12 150640.png">
  </div>
</details>

     * 아이스크림과 토핑 종류 추가

<details><summary><b>ERD</b></summary>
  <div>
    <img src="icecream/WebContent/IceCreamERD.png">
  </div>
</details>

     * 일대다 관계에 유의하여 구성함















<details><summary><b>특징</b></summary>
  <div>
    23년 8월, 선생님이 각자 crud가 되는 사이트를 하나 만들어 보라고 하셨다.<br>
왠지 게시판 만들기가 재미없었던 나는 아이스크림 가게 포스기를 만들어 보기로 했다.<br>
그 때 배우고 있던 **Spring5**와 **JSP**를 사용했다.<br>
일단 알아둘 것은 이 때의 나는 아직 자바스크립트를 배우는 중이라 객체라는 것 자체를 몰랐다...<br>
그래서 **주문을 문자열로** 쭉 찍어보내기로 했다.<br>
여기서 어떤 아이스크림에 어떤 토핑이 들어가는지 구분해야 하는 것이 핵심이였다.<br>
일단 장바구니에 있는 하나의 아이스크림 조합(아이스크림 + 토핑)의 div에 1부터 순서대로 숫자를 준다. 숫자가 같은 상품들을 하나로 친다.<br>
숫자와 상품코드를 이어붙인 문자열을 가공해서 주문 한 건을 만든다.<br>
이 작업을 하면서 자바스크립트와 JQuery 실력이 많이 늘었다.<br>
요소를 숨겨놨다가 쓰는 법이나, 동적으로 생성된 버튼을 선택할 때 등 여러가지 상황에 대처하는 법도 배웠다.<br>
지금 보면 소스가 복잡하고 아쉬운 점도 많지만 그 2주간이 가장 많이 늘었던 시기였던 것 같다.<br><br><br>
  </div>
</details>





