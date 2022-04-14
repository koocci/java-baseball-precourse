# 요구사항 분석

## 기능 요구사항 정리

1. 1부터 9까지 이루어진 서로 다른 3자리 수 Generate 기능
2. 스트라이크 확인 기능 : 같은 수 AND 같은 자리
3. 볼 확인 기능 : 같은 수 AND 다른 자리
4. 낫싱 확인 기능 : 같은 수 없음
5. 플레이어 입력 기능
6. 결과 출력 기능
7. 승리 여부 확인 기능
8. 게임 재시작 기능
9. 게임 종료 기능
10. 예외 처리 (사용자의 잘못된 값 입력: IllegalArgumentException)

## 제약사항 정리

1. 시작점 확인 (baseball.Application.main())
2. JDK8에서 실행
3. camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    1. pickNumberInRange()로 Random 값 추출
    2. readLine()으로 사용자 입력 처리
4. baseball.ApplicationTest에 있는 2개의 Test Case 성공 필요
    1. 별도 Test Case 작성 추천
5. 자바 코드 컨벤션 확인
6. Indent Depth는 1까지만 허용
7. 람다를 제외한 stream API 사용 불가
8. else 예약어 사용 불가
9. 함수 (또는 메소드)의 길이는 10라인 이하
10. 함수 (또는 메소드)가 한 가지 일만 잘 하도록 구현
11. JUnit5와 AssertJ를 통한 단위 테스트 구현

# 요구사항 개발 우선순위 설정

## 1. 사전 설정

1. JDK8 설정
2. 자바 코드 컨벤션 설정
3. camp.nextstep.edu.missionutils 기능 확인
4. 시작점 확인
5. Test Case 확인

## 2. 기능 구현 우선 순위

1. 1부터 9까지 이루어진 서로 다른 3자리 수 Generate 기능
    1. 단위 테스트 구현
2. 스트라이크 확인 기능 : 같은 수 AND 같은 자리
    1. 단위 테스트 구현
3. 볼 확인 기능 : 같은 수 AND 다른 자리
    1. 단위 테스트 구현
5. 플레이어 입력 기능
    1. 예외 처리 (사용자의 잘못된 값 입력: IllegalArgumentException)
    2. 단위 테스트 구현
6. 결과 출력 기능
    1. 단위 테스트 구현
7. 승리 여부 확인 기능
    1. 단위 테스트 구현
8. 게임 재시작 OR 종료 기능
    1. 단위 테스트 구현

## 3. 구현 제약 사항 확인

1. Indent Depth는 1까지만 허용
2. 람다를 제외한 stream API 사용 불가
3. else 예약어 사용 불가
4. 함수 (또는 메소드)의 길이는 10라인 이하
5. 함수 (또는 메소드)가 한 가지 일만 잘 하도록 구현

## 4. 리팩토링

1. ENUM 가능 여부 확인
2. Configuration 가능 여부 확인
3. final 가능 여부 확인

## 5. 최종 테스트 및 빌드

1. 최종 전체 단위 테스트 통과 확인 및 빌드

## *. 기타 사항

1. 기능 목록 단위 또는 의미있는 단위로 Commit
2. 커밋메시지 컨벤션 참고하여 commit log 저장

# 구현 기능 목록

1. Computer Class
    1. setRandom3Numbers() : 1부터 9까지 이루어진 서로 다른 3자리 수 Generate
2. Player Class
    1. setInputNumbers() : 플레이어 입력
4. BaseBallGame Class
    1. start() : 게임 시작
    2. restart() : 게임 재시작
    3. end() : 게임 종료
    4. play() : 게임 진행
    5. isStrike() : 스트라이크 확인
    6. isBall() : 볼 확인
    7. playResult() : 게임 결과 저장
    8. getMatchResult() : 최종 결과 출력
    9. isWin() : 승리 여부
