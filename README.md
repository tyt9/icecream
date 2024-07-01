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
* 컨트롤러에서 받은 문자열을 다시 분해해서 주문을 생성함(insert)<br><br>

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
