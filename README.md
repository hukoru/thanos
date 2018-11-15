[![Build Status](https://travis-ci.org/hukoru/thanos.svg?branch=master)](https://travis-ci.org/hukoru/thanos)

# 프로젝트 개요

<br /> 
<br /> 

## Getting Started

1. 레포지토리를 로컬 컴퓨터에 복제하고 코드 작업을 시작합니다.
```
git clone https://github.com/hukoru/thanos
```      
  
<br /> 

### Prerequisites

1. Git(1.7.9 이상 지원)
1. JDK 1.8
4. Gradle 4.2 이상

<br /> 

### Installing

Idea Lombok Plug-in 설치
Idea 설정

```
Build, Execution, Deployment -> Compiler -> Annotation Processors 

Enable annotation processing 체크
```

<br /> 

테스트 작업 시 자동으로 apt task를 먼저 수행하게 변경

```
Build, Execution, Deployment -> Gradle -> Runner

Delegate IDE build/run action to gradle 체크
Gradle Task Runner 으로 선택 
```

## Running the tests

Gradle 명령어로 Build 실행
```
gradle clean build
```

프로젝트별 실행 
```
Give an example
```

<br /> 

### Break down into end to end tests

API Module test를 하려면 아래처럼 :module명 기술 

```
gradle :api:build
```

<br /> 

## Deployment

Add additional notes about how to deploy this on a live system

<br /> 

## Built With

* [Gradle](https://gradle.org/) - Gradle Build Tool
* [IntelliJ IDEA ](https://www.jetbrains.com/idea/) - IntelliJ IDEA 

<br /> 

## Contributing


 
 <br /> 
 
## Versioning



<br /> 

## Authors

* **Frank Lim** - *Initial work* - [임세환](code437@gmail.com)

<br /> 

## License



<br /> 

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
