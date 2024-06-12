# icecream
**아이스크림 주문 포스기** 입니다.<br><br><br>
23년 8월, 선생님이 각자 crud가 되는 사이트를 하나 만들어 보라고 하셨다.<br>
왠지 게시판 만들기가 재미없었던 나는 아이스크림 가게 포스기를 만들어 보기로 했다.<br>
그 때 배우고 있던 **Spring5**와 **JSP**를 사용했다.<br>
일단 알아둘 것은 이 때의 나는 아직 자바스크립트를 배우는 중이라 객체 만드는 법을 몰랐다...<br>
그래서 **주문을 문자열로** 쭉 찍어보내기로 했다.<br>
여기서 어떤 아이스크림에 어떤 토핑이 들어가는지 구분해야 하는 것이 핵심이였다.<br>
일단 장바구니에 있는 하나의 아이스크림 조합(아이스크림 + 토핑)의 div에 1부터 순서대로 숫자를 준다. 숫자가 같은 상품들을 하나로 친다.<br>
숫자와 상품코드를 이어붙인 문자열을 가공해서 주문 한 건을 만든다.<br>
이 작업을 하면서 자바스크립트와 JQuery 실력이 많이 늘었다.<br>
요소를 숨겨놨다가 쓰는 법이나, 동적으로 생성된 버튼을 선택할 때 등 여러가지 상황에 대처하는 법도 배웠다.<br>
지금 보면 소스가 복잡하고 아쉬운 점도 많지만 그 2주간이 가장 많이 늘었던 시기였던 것 같다.<br><br><br>

아래는 기능설명 입니다.<br><br>

![스크린샷 2024-06-10 200122](https://github.com/tyt9/icecream/assets/143326223/bbdd6058-7eed-4186-bb57-0fe8606113fa)<br>
첫 화면 입니다.<br>
*아이스크림은 한번에 한 종류만 선택할 수 있습니다. 토핑은 선택하지 않거나 여러개 선택할 수 있습니다.<br><br><br>

**①** 담기 버튼 : 아이스크림과 토핑을 선택한 후 누르면 장바구니에 담깁니다.<br>
![스크린샷 2024-06-12 145704](https://github.com/tyt9/icecream/assets/143326223/4fd14b28-cbaa-442e-a13b-a2371399849f)<br><br><br>

**②** 주문하기 버튼 : 장바구니에 담긴 아이스크림들이 주문 결정 됩니다.<br>
![스크린샷 2024-06-12 150051](https://github.com/tyt9/icecream/assets/143326223/361b38e8-6969-498a-93db-a0b7463c5513)<br><br><br>

**③** 초기화 버튼 : 장바구니에 담긴 모든 상품이 초기화 됩니다.<br><br>
**④** 이전 주문 내역 버튼 : 이전에 주문했던 내역이 뜹니다.<br>
![스크린샷 2024-06-12 150413](https://github.com/tyt9/icecream/assets/143326223/b2f7d48f-9ba8-4189-841c-55b3656fdd20)<br><br><br>

**⑤** 관리 버튼 : 아이스크림과 토핑 종류를 추가할 수 있습니다.<br>
![스크린샷 2024-06-12 150535](https://github.com/tyt9/icecream/assets/143326223/720ba573-eeb4-467f-ba1e-66756c539395)<br>
↓↓↓<br>
![스크린샷 2024-06-12 151436](https://github.com/tyt9/icecream/assets/143326223/b66e123d-35e7-4277-a404-b5846341af79)<br>
![스크린샷 2024-06-12 151500](https://github.com/tyt9/icecream/assets/143326223/de146170-f694-4185-ac41-dab86d86f9b3)<br>

추가하면 메인 화면에 추가됩니다.<br>

![스크린샷 2024-06-12 151018](https://github.com/tyt9/icecream/assets/143326223/5e752500-1a47-4788-94d3-f59f853682e2)<br><br><br>

**ERD** 참고하세요.<br>
![IceCreamERD](https://github.com/tyt9/icecream/assets/143326223/d2a6b223-9679-4997-b4ba-0b5739735958)


