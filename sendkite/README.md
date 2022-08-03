## Error log 


### 실습 진행할 자바환경 구축

1. 수동으로 실행하기
```shell
java src/main/java/sendkitejava/FilteringApples.java  
```
2. maven 사용해서 컴파일 후 실행
- 클레스 실행 명령어
  - -cp : classpath의 약자
```shell
mvn clean
mvn compile
java -cp target/classes/ FilteringApples
mvn package
java -jar 파일명 <- manifest 정보가 없다고 뜬다 !! ㅜㅜ
```

3. 인텔리제이로 설정

```shell
1. command + ; 명령어로 project structure에 project를 내가 만든 폴더로 설정
2. 폴더에 마우스 커서 왼쪽 클릭 > new > add module로 directory 생성
3. maven으로 생성
```