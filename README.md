# 출석 기능목록

## 📚 구현 기능 목록

### 💫입력

- [x] 기능을 입력받는다.
    ```
    오늘은 12월 13일 금요일입니다. 기능을 선택해 주세요.
    1. 출석 확인
    2. 출석 수정
    3. 크루별 출석 기록 확인
    4. 제적 위험자 확인
    Q. 종료
    ```
- [x] 닉네임을 입력받는다.
  ```
  닉네임을 입력해 주세요.
  ```

- [x] 등교시간을 입력받는다.
  ```
  등교 시간을 입력해 주세요.
  ```
- [x] 수정할 크루 닉네임을 입력받는다.
  ```
  출석을 수정하려는 크루의 닉네임을 입력해 주세요.
  ```
- [x] 수정할 날짜 입력받는다.
  ```
  수정하려는 날짜(일)를 입력해 주세요.
  ```
- [x] 수정할 시간 입력받는다.
  ```
  언제로 변경하겠습니까?
  ```

#### 💣예외처리

- [x] 빈 값이나 공백을 입력한 경우
- [x] 기능 선택 항목, 날짜 또는 시간을 잘못된 형식으로 입력한 경우
    - [x] [ERROR] 잘못된 형식을 입력하였습니다.
- [x] 등록되지 않은 닉네임을 입력한 경우
    - [x] [ERROR] 등록되지 않은 닉네임입니다.
- [x] 주말 또는 공휴일에 출석을 확인하거나 수정하는 경우
    - [x] [ERROR] 12월 14일 토요일은 등교일이 아닙니다.
- [ ] 미래 날짜로 출석을 수정하는 경우
    - [ ] [ERROR] 아직 수정할 수 없습니다.
- [x] 등교 시간이 캠퍼스 운영 시간이 아닌 경우
    - [x] [ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다.
- [ ] 이미 출석을 하였는데 다시 출석 확인을 하는 경우
    - [ ] [ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.

### 💫진행

- [x] 예외 발생 시 `[ERROR]`로 시작하는 에러 문구를 출력한 후 그 부분부터 입력을 다시 받는다.
  ```
  [ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.
  ```
- [x] 월요일은 13:00~18:00, 화요일~금요일은 10:00~18:00이다.
    - [x] 해당 요일의 시작 시각으로부터 5분 초과는 지각으로 간주한다.
    - [x] 해당 요일의 시작 시각으로부터 30분 초과는 결석으로 간주한다.
    - [ ] 출석 기록이 없는 날은 결석으로 간주한다.
- [x] 지각 3회는 결석 1회로 간주한다.
    - [x] 경고 대상자: 결석 2회 이상
    - [x] 면담 대상자: 결석 3회 이상
    - [x] 제적 대상자: 결석 5회 초과
- [x] 캠퍼스 운영 시간은 매일 08:00~23:00이다.
- [x] 주말 및 공휴일에는 출석을 받지 않는다.
- [x] 마지막 출석 데이터 저장된 시간을 기준으로 입력받는다.

### 💫출력

- [x] 날짜와 출석 시간을 출력한다.
  ```
  12월 13일 금요일 09:59 (출석)
  ```
- [x] 수정하기 전, 후 출석 상태를 입력받는다.
  ```
  12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!
  ```
- [x] 크루 한 명의 출석 기록을 출력한다.
    ```angular2html
    이번 달 빙티의 출석 기록입니다.
    
    12월 02일 월요일 13:00 (출석)
    12월 03일 화요일 09:58 (출석)
    12월 04일 수요일 10:02 (출석)
    12월 05일 목요일 10:06 (지각)
    12월 06일 금요일 10:01 (출석)
    12월 09일 월요일 --:-- (결석)
    12월 10일 화요일 10:08 (지각)
    12월 11일 수요일 --:-- (결석)
    12월 12일 목요일 --:-- (결석)
  
    출석: 4회
    지각: 2회
    결석: 3회

    면담 대상자입니다.
    ```
- [ ] 제적 위험자를 출력한다.
    - [ ] 제적 위험자는 제적 대상자, 면담 대상자, 경고 대상자순으로 출력하며, 대상 항목별 정렬 순서는 지각을 결석으로 간주하여 내림차순한다.
    - [ ] 출석 상태가 같으면 닉네임으로 오름차순 정렬한다.
        ```angular2html
        제적 위험자 조회 결과
        - 빙티: 결석 3회, 지각 2회 (면담)
        - 이든: 결석 2회, 지각 4회 (면담)
        - 쿠키: 결석 2회, 지각 2회 (경고)
        - 빙봉: 결석 1회, 지각 5회 (경고)
        ```

(생략 가능)

## 📚 프로그램 전체 흐름

```dtd
```
