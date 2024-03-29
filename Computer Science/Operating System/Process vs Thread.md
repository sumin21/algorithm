# 프로세스 & 스레드

<br>

> **프로세스** : 메모리 상에서 실행 중인 프로그램. (OS로부터 자원을 할당받는 작업의 단위)
>
> **스레드** : 프로세스 안에서 실행되는 여러 흐름 단위. (프로세스의 특정한 수행 경로 / 프로세스가 할당받은 자원을 이용하는 실행의 단위)
<br>

기본적으로 프로세스마다 최소 1개의 스레드 소유 (메인 스레드 포함)

<br>

![img](https://camo.githubusercontent.com/3dc4ad61f03160c310a855a4bd68a9f2a2c9a4c7/68747470733a2f2f74312e6461756d63646e2e6e65742f6366696c652f746973746f72792f393938383931343635433637433330363036)

> #### 주소 공간!
>- Code : 코드 자체를 구성하는 메모리 영역(프로그램 명령)
>
>- Data : 전역변수, 정적변수, 배열 등
    - 초기화 된 데이터는 data 영역에 저장
    - 초기화 되지 않은 데이터는 bss 영역에 저장
>
>- Heap : 동적 할당 시 사용 (new(), malloc() 등)
>
>- Stack : 지역변수, 매개변수, 리턴 값 (임시 메모리 영역)

## 프로세스
- 최소 하나의 스레드 보유
- 각각 별도의 주소 공간을 독립적으로 할당 받음 (code, data, heap, stack) → 안정성
- CPU 시간도 OS로부터 할당 받음

### 문제점

- 프로세스 생성에 큰 오버헤드 존재 (프로세스 생성에 많은 시간 소요)
- Context Switching의 비효율성 (오버헤드)
- 프로세스 사이에 통신이 어려움 (IPC 사용 필요)

### 멀티 프로세스

하나의 응용프로그램을 여러 개의 프로세스로 구성하여 각 프로셋가 하나의 작업을 처리하도록 하는 것

- 장점
    - 여러 자식 프로세스 중 하나에 문제가 발생 → 영향이 확산되지 않음
    - 메모리 침범 문제를 OS 차원에서 해결 : 안정성
- 단점
   - Context Switching으로 인한 성능 저하 (오버헤드)
       - 과정에서 캐쉬 메모리 초기화 등 무거운 작업이 진행됨 → 많은 시간 소요
       - 발생 하면 캐쉬에 있는 모든 데이터 리셋 → 다시 캐쉬 데이터 불러와야 함
   - 자원 소모
     - 각각 독립된 메모리 영역을 갖고 있어, 작업량 많을 수록 오버헤드 발생.
     - 프로세스를 생성해 자원을 할당하는 시스템 콜이 존재
   - IPC는 어렵고 복잡한 통신 기법


<br>

### 여러 프로세스를 함께 돌리는 작업

- 동시적 (Concurrency) : Context Switching → 멀티 프로세싱 가능
- 병렬적 (Parallelism) : 프로세서 하나에 코어 여러개 → 각각 작업 수행 (멀티코어)
- 동시 + 병렬


- stack 영역만 각각 독립적으로 주소 공간을 할당 받음
- code, data, heap 영역은 스레드끼리 공유

### 출현 목적

- 프로세스보다 크기가 작은 실행 단위 필요
- 프로세스의 생성 및 소멸에 따른 오버헤드 감소
- Context Switching 빠름
- 프로세스들의 통신 시간, 방법 어려움 해소

### 스레드 주소 공간
![img](https://velog.velcdn.com/images/turningtwenty/post/8aac6e60-23a5-431f-87f2-cc11ecb4e7ac/image.png)
- 하나의 스레드가 동작하기 위해 6개의 공간 존재
    - 사적 공간
        - 스레드 코드 공간
        - 스레드 로컬 스토리지(TLS, Thread local storage)
        - 스택 공간
    - 공유 공간
        - 프로세스 코드
        - 데이터 공간 (로컬 스토리지 제외)
        - 힙 공간
    - 커널 스택

### 멀티 스레드

하나의 응용프로그램을 여러 개의 스레드로 구성하고 이게 모여 하나의 작업을 처리하도록 하는 것 (웹 서버)

- 장점
    - 시간, 시스템 자원 소모 감소 (자원의 효율성 증대)
        - 전역 변수와 정적 변수에 대한 자료 공유 가능 
        - 시스템 콜 감소
        - 스레드 사이의 작업량이 작아 Context Switching 빠름
    - 간단한 통신 방법 (프로그램 응답 시간 단축)
- 단점
    - 주의 깊은 설계 필요
    - 디버깅 까다로움
    - 단일 프로세스인 경우 효과 기대 X
        - 이유
        1. 단일 프로세스는 하나의 CPU 코어에만 접근할 수 있기 때문에, 멀티 스레드를 사용해도 CPU 코어를 동시에 사용하지 못합니다. 따라서 멀티 스레드를 사용하더라도 성능 향상을 기대하기 어렵습니다.
        2. 멀티 스레드는 동시에 공유자원에 접근하므로, 공유자원의 동기화가 필요합니다. 그러나 단일 프로세스에서는 프로세스 내의 스레드들이 모두 같은 메모리 공간을 공유하므로, 스레드 간의 동기화가 필요하지 않습니다. 이에 따라 멀티 스레드를 사용할 경우, 추가적인 동기화 비용이 발생하여 성능이 저하될 수 있습니다.
        3. 멀티 스레드를 사용할 경우, 스레드 간의 우선순위, 데드락 등의 문제가 발생할 수 있습니다. 이러한 문제는 멀티 프로세스 환경에서도 발생할 수 있지만, 멀티 스레
    - 동기화 문제 (자원 공유의 문제) : 안전성 문제
      - 멀티스레드의 안전성에 대한 단점은 Critical Section 기법을 통해 대비함
    - 하나의 스레드 문제 → 전체 프로세스 영향 받음 (공유 메모리를 갖기 때문)

<br>


### 멀티 프로세스 < 멀티 스레드 ?

프로그램을 여러개 키는 것보다 하나의 프로그램 내에서 여러 작업 수행하는 것

- 이유 : 자원의 효율성 증대 (시스템 콜), 통신 비용 적게 듦

<br>

<br>


***Context Switching*이란?**
> 프로세스의 상태 정보를 저장하고 복원하는 일련의 과정
>
> 즉, 동작 중인 프로세스가 대기하면서 해당 프로세스의 상태를 보관하고, 대기하고 있던 다음 순번의 프로세스가 동작하면서 이전에 보관했던 프로세스 상태를 복구하는 과정을 말함
>
> → 프로세스는 각 독립된 메모리 영역을 할당받아 사용되므로, 캐시 메모리 초기화와 같은 무거운 작업이 진행되었을 때 오버헤드가 발생할 문제가 존재함
<br>
<br>
> 
***IPC*이란?**
> 두 프로세스 사이에 코드를 제외한 메모리 공간이 공유되지 않음.
>
> 프로세스들이 서로 통신할 수 있도록 운영체제 커널에서 IPC를 지원
> 
> 대표적인 IPC : 공유 메모리, 신호, 파이프
>
<br>
<br>