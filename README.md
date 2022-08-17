# java-lab

## 🚩목적
* 서로 동기부여 
* 1~7장까지 완독하기

## 📋스터디 규칙
- 매주 화요일 밤 8시 30분 스터디 모임
- 매주 정해진 챕터를 읽고 중요한 핵심문장을 공유하고 토론한다. 
- [삼색펜 공부법](http://m.egloos.zum.com/agile/v/3684946)
- 책에 있는 실습 코드는 커밋한다.


## 📌이슈
- 읽으면서 토론하면 좋을 것 같은 주제는 자유롭게 등록한다.
- 이슈 등록은 템플릿을 따른다.

## 🧬프로젝트 구조 
[tree 만드는 법](https://yeoon.tistory.com/91)

```shell
.
├── README.md
├── archive
│   └── 0725
│       └── chapter01.md
├── sendkite
│   ├── README.md
│   ├── pom.xml
│   ├── sendkite.iml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── modern
│   │   │   │       ├── ExecuteAround.java
│   │   │   │       ├── FilteringAppls.java
│   │   │   │       ├── LambdaFilterApples.java
│   │   │   │       ├── StreamPractive.java
│   │   │   │       ├── data.txt
│   │   │   │       ├── domain
│   │   │   │       │   ├── Apple.java
│   │   │   │       │   ├── Dish.java
│   │   │   │       │   └── type
│   │   │   │       │       ├── Color.java
│   │   │   │       │       └── Type.java
│   │   │   │       └── util
│   │   │   │           ├── formatter
│   │   │   │           │   ├── AppleFormatter.java
│   │   │   │           │   ├── ApplePrintFormatter.java
│   │   │   │           │   └── ApplePrintWeightFormatter.java
│   │   │   │           └── predicator
│   │   │   │               ├── AppleGreenColorPredicate.java
│   │   │   │               ├── AppleHeavyWeightPredicate.java
│   │   │   │               └── ApplePredicate.java
│   │   │   └── resources
│   │   └── test
│   │       └── java
│   └── target
│       ├── classes
│       │   └── modern
│       │       ├── ExecuteAround$BufferedReaderProcessor.class
│       │       ├── ExecuteAround.class
│       │       ├── FilteringAppls.class
│       │       ├── LambdaFilterApples.class
│       │       ├── StreamPractive$1.class
│       │       ├── StreamPractive.class
│       │       ├── data.txt
│       │       ├── domain
│       │       │   ├── Apple.class
│       │       │   ├── Dish.class
│       │       │   └── type
│       │       │       ├── Color.class
│       │       │       └── Type.class
│       │       └── util
│       │           ├── formatter
│       │           │   ├── AppleFormatter.class
│       │           │   ├── ApplePrintFormatter.class
│       │           │   └── ApplePrintWeightFormatter.class
│       │           └── predicator
│       │               ├── AppleGreenColorPredicate.class
│       │               ├── AppleHeavyWeightPredicate.class
│       │               └── ApplePredicate.class
│       ├── generated-sources
│       │   └── annotations
│       ├── maven-archiver
│       │   └── pom.properties
│       ├── maven-status
│       │   └── maven-compiler-plugin
│       │       ├── compile
│       │       │   └── default-compile
│       │       │       ├── createdFiles.lst
│       │       │       └── inputFiles.lst
│       │       └── testCompile
│       │           └── default-testCompile
│       │               └── inputFiles.lst
│       └── sendkite-1.0-SNAPSHOT.jar
└── 형민
    └── chapter2_동작파라미터
        ├── ApplePredicate.java
        ├── Chapter2_1_녹색사과필터링.java
        ├── Chapter2_2_색을파라미터화.java
        ├── Chapter2_3_가능한_모든_속성으로필터링.java
        ├── Chapter2_4_추상조건으로_필터링.java
        ├── Chapter2_5_익명클래스.java
        ├── Chapter2_6_람다표현식.java
        ├── Chapter2_7_리스트형식으로_추상화.java
        └── common
            ├── Apple.java
            └── Color.java


```

## 🐾 Schedule

| No. |    일시    |                         주제                         |
| :-: | :--------: | :--------------------------------------------------: |
|  1  | 2022-07-25 | [1장] 자바 8, 9, 10, 11 : 무슨 일이 일어나고 있는가? |
|  2  | 2022-08-04 |         [2장] 동작 파라미터화 코드 전달하기          |
|  3  | 2022-08-11 |         [3장] 람다 표현식          |
|  4  | 2022-08-18 |         [4장] 스트림 소개          |

