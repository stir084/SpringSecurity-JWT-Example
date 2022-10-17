### JWT + Thymeleaf + Spring Boot 회원가입 시스템 

### 메인페이지
![image](https://user-images.githubusercontent.com/47946124/196226640-99e0b6d4-1604-4429-b94a-e69a09ef6e11.png)

### 회원가입
![image](https://user-images.githubusercontent.com/47946124/196226399-72785dba-2f2a-4fca-8fcd-66cd3bc46786.png)

### 로그인 페이지
![image](https://user-images.githubusercontent.com/47946124/196226603-037ca0f3-221c-4dff-8294-072977b6fe8e.png)

Thymeleaf와 같은 SSR Template Engine은 Rest Api+JWT 구현 불가능 -> JS 영역에서 페이지 요청 시 localStorage에 있는 Authorization을 header에 setting해서 페이지를 요청할 수 없음.
