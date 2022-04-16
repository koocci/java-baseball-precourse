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

1. 컴퓨터 숫자 생성 기능
    1. 1부터 9까지 이루어진 서로 다른 3자리 수 Generate
    2. 단위 테스트 구현
2. 플레이어 입력 기능
    1. 예외 처리 (사용자의 잘못된 값 입력: IllegalArgumentException)
    2. 단위 테스트 구현
3. 결과 출력 기능
    1. 스트라이크 확인
    2. 볼 확인
    3. 낫싱 확인
    4. 문장 출력
    5. 단위 테스트 구현
4. 게임 재시작 OR 종료 기능
    1. 승리 여부에 따른 재시작 OR 종료 입력 기능
    2. 단위 테스트 구현

## 3. 구현 제약 사항 확인

1. Indent Depth는 1까지만 허용
2. 람다를 제외한 stream API 사용 불가
3. else 예약어 사용 불가
4. 함수 (또는 메소드)의 길이는 10라인 이하
5. 함수 (또는 메소드)가 한 가지 일만 잘 하도록 구현

## 4. 리팩토링

1. Configuration 가능 여부 확인
2. final 가능 여부 확인

## 5. 최종 테스트 및 빌드

1. 최종 전체 단위 테스트 통과 확인 및 빌드

## *. 기타 사항

1. 기능 목록 단위 또는 의미있는 단위로 Commit
2. 커밋메시지 컨벤션 참고하여 commit log 저장

# 구현 기능 목록

1. Computer Class
    1. setRandom3Numbers() : 1부터 9까지 이루어진 서로 다른 3자리 수 로직 적용
    2. resetNumbers() : 게임 재시작 시, 컴퓨터 숫자 리셋
    3. addNewNumber() : 랜덤 숫자 생성
    4. isUnique() : 숫자 유일성 확인
2. Player Class
    1. setInputNumbers() : 플레이어 입력 로직 적용
    2. resetNumbers() : 게임 승리 못할 시, 게임 재시작 시, 사용자 숫자 리셋
    3. getPlayerInput() : 플레이어 입력
    4. validate1DigitNumber() : 0을 제외한 integer 예외 처리
    5. validateUnique() : 유일성 예외 처리
    6. validateCount() : 숫자 갯수 예외 처리
3. BaseBallGame Class
    1. start() : 게임 시작 로직 적용
    2. resetScore() : 게임 스코어 리셋
    3. computerSetUp() : 컴퓨터 셋업
    4. gameOver() : 게임 종료
    5. endOrRestart() : 게임 종료 시, 완전 종료 및 재시작 확인
    6. getGameOverTypeInput() : 종료 및 재시작 입력 기능
    7. restart() : 게임 재시작
    8. play() : 게임 실행 로직 적용
    9. playerSetUp() : 플레이어 셋업
    10. isStrike() : 스트라이크 여부
    11. isBall() : 볼 여부
    12. setPlayResult() : 게임 결과 저장
    13. isWin() : 승리 여부
    14. setNothingHint() : 낫싱 힌트 문구 생성
    15. setBallHint() : 볼 힌트 문구 생성
    16. setStrikeHint() : 스트라이크 힌트 문구 생성
    17. getPlayHint() : 최종 결과 힌트 문구 생성
