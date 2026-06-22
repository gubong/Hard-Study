html 안의 스크립트 안에서 사용하는 언어 java script

html  /html

head > title

body

주석  <!--       -->

script



변수 



var a = 10;

var c = a+b + 10;

var a = 20.123  >>정수 혹은 실수

var a = "20.123"  >>이공.일이삼 개녀



var name = "홍길동";

var area = "대전";

var age = 25;

var info = area+"에 사는 "+age+"살 "+name+" 입니다"

document.write(info);



var a = "10";

var b = "20";

var c = a + b;

document.write(" c : " + c);            > 문자열+문자열 이라 

c : 1020  으로 출력됨.



\-평균

var kor = 71;

var eng = 80;

var mat = 90;

var total = kor + eng + mat;

document.write("총 점 : "+total+"<br>");

var ave = total / 3;

document.write("평 균 : "+ave+"<br>");	

var namege = kor % 10;

document.write("나머지 : "+namege);

&#x09;	

var a = 5;

var b = 10;

var result = a > b;

document.write(" 1번째 result : "+result+"<br>");



\-비교연산

result

>

==

!=

>=

<=



\-자신한테더하기

var a = 10;

&#x20;a = a + 10;     //a=20

&#x20;a += 10;        //a=30   위의두개가같은표현임



var b = 10;

b = b - 5;

b -= 5;        //b=0



c \*= 5;

d /=5;



프로그램은 1씩증가하는구조가많음. 특례로

e = e + 1;

e += 1;

e++;





//같은표현



\---논리연산자

var gender = "남자";

var age = 25;

&#x09;		

var result = gender == "남자" \&\& age >= 30;

document.write("1. result : "+result+"<br>");

//남자이고, 연령이25 이상이냐.

&#x09;		

var result = gender == "남자" || age >= 30;

document.write("2. result : "+result);

// 또는

















주석 // 

/\*      \*/

줄바꿈 <br>

글  document.write("ㅁㄴㅇ");



글 줄바꿈 document.write("ㅁㄴㅇ <br>"); 









단축키  ctrl+L  ctrl+D

&#x20;쉬프트+엔드 





위부터 프롬프트읽어가는구조



