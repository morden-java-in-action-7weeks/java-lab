## Error log 

## 프로젝트 

### 실습 진행할 자바환경 구축

1. 수동으로 실행하기
```shell
java src/main/java/sendkite/FilteringApples.java  
```
2. maven 사용해서 컴파일 후 실행
- maven과 java로 클레스 실행 명령어
  - -cp : classpath의 약자
```shell
mvn clean
mvn compile
java -cp target/classes/ FilteringApples
mvn package
java -jar 파일명.jar <- manifest 정보가 없다고 알림 -> 인텔리제이로 maven 재설정 이후에는 문제 없음
```

3. 인텔리제이로 설정

```shell
1. command + ; 명령어 project structure에 project를 sendkite로 변경
2. sendkite 폴더에 마우스 커서 왼쪽 클릭 > new > add module로 directory 생성 > 이때 Java, frameworks 설정 config 창이 뜬다.
3. maven으로 생성
4. java 코드 run
```