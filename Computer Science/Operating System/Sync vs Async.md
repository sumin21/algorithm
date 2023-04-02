# Synchronous vs Asynchronous

---
### 동기 vs 비동기
행위에 대한 이야기. (concurrent의 문제) (parallel X)
### 동기 (Synchronous)
- 데이터의 요청과 결과가 동시에 일어나는 것.
- 결과가 주어질 때까지 아무것도 못하고 대기해야 한다.
- 장점 : 설계가 간단. 직관적. 순서에 맞추어 진행된다.
- 단점 : 여러 요청이 동시에 처리되지 않는다.

### 비동기 (Asynchronous)
- 요청과 결과가 동시에 일어나지 않는다.
- 요청에 따른 결과가 반환되는 시간동안 다른 작업을 수행할 수 있다.
- A, B 사이에 인과관계가 있어야 비동기.
- 장점 : 여러 요청을 동시에 처리할 수 있다. 자원을 효율적으로 사용할 수 있다.
- 단점 : 설계가 복잠. 속도가 느릴 수 있다.

---
### 블럭 vs 논블럭
함수 호출에서의 이야기.
### 블럭 (Block)
- 호출된 함수가 할일을 마칠 때까지 제어권을 계속 가지고, 호출한 함수에게 바로 return하지 않는다.

### 논블럭 (Non-Block)
- 호출된 함수가 자신의 할일을 마치지 않았더라도 제어권을 바로 return하여 호출한 함수가 다른일을 진행할 수 있도록 한다.

---
### 동기 vs 비동기 vs 블럭 vs 논블럭
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fs4GhX%2Fbtry69JJgmj%2FLkjtlqXss4xSsMQUCnjx21%2Fimg.png)
- 동기/논블럭 : callback X, 계속 완료 확인 물어봄