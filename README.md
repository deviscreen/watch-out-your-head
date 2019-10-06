# Getting Started


## Guides
### API Server
API server : watchout-api ( Spring Boot - gradle )
동작 확인 : http://localhost:8081
h2-console : http://localhost:8080/h2-console/

### WEB server
WEB server : watchout-web ( React - npm )


1. npm  설치하기 !!

2. web server start  
`cd ./watchout-web`<br/>

`npm install` 을 해준 뒤 <br/> 
`npm start` 입력 <br/>

참고사항
`npm install ` 시 멈춰있을경우 <br/>
`npm install -g npm@latest` npm을 이전 버전으로 설치하고 다시 npm install 한다<br/>
동작 확인 : http://localhost:3000

###TODO
* CORS 문제 해결하기
* application 로직 정의에 따른 코드 작성 
### API Server Development Note
2019-09-28 watchout-api 서버 환경 구축 
2019-10-06 핵심 도메인 생성 및 h2 JPA 연결 
### WEB Server Development Note
2019-09-28 watchout-web 서버 환경 구축