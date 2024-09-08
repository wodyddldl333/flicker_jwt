## flicker_jwt

spring cloud gateway port 8080으로 설정하고 회원관리 마이크로서비스의 경우 port 8081로 설정
gateway에서 jwt 검증을 수행하고 jwt 발급 및 로그인 회원가입은 user 마이크로서비스에서 진행!

- localhost:8080이 주소인 경우 login의 경우에는 api 호출 시 : http://localhost:8080/login

- 회원가입의 경우에는 http://localhost:8080/user/api/join

login과 join 모두 post 호출입니다. 

***login request(post)***

```json
{   
    "username" : "admin",
    "password" : "1234"
}
```

response에서는 request body에 담겨오는 정보는 없고 성공 시 200 응답 실패 시 401이나 403에러 발생합니다.

access 토큰의 경우에는 response 헤더의 Authorization 태그에 담겨와서 태그에 있는 값을 빼서 로컬 스토리지에 저장하는 방식을 사용하시면 될 것 같습니다.

refresh 토큰의 경우에는 http Cookie에 담겨있습니다. 아직 토큰 재발급 로직은 없는 코드입니다.

refresh 토큰의 경우에는 로컬환경과 배포환경 처럼 서로 다른 도메인에서 테스트하는 경우에는 cookie가 저장되지 않을 수 있으니 참고바랍니다.

refresh 토큰의 경우에는 로그아웃 등과 같은 경우 서버에서 처리할 부분이니 프론트에서는 신경 많이 안써도 될 것 같습니다.

***join도 마찬가지로***

***join request(post)***

```json
{   
    "username" : "admin",
    "password" : "1234"
}
```

response에서는 request body에 담겨오는 정보는 없고 성공 시 200 응답 실패 시 500번 대 에러 발생합니다.

아직 도커 파일과 컴포즈 파일을 작성하지 못하여서 혹시 제가 월요일까지 만들 수 있으면 만들어 놓겠습니다. 도와주실 분 있으면 부탁드립니다.

