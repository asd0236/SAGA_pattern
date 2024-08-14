# SAGA Pattern 구현하기

![image](https://github.com/user-attachments/assets/547a4d27-7a39-4b70-87a1-02daf35fad16)

## 로직 설계

### Order

- Order Application은 Producer의 입장으로서 Product Application에 메시지 큐를 통해 요청을 보낸다.

### Product

- Product Application은 Consumer의 입장으로서 Order Application으로부터 메시지 큐를 통해 요청을 받는다.

- 동시에 Producer의 입장으로 Payment Application에 메시지 큐를 통해 요청을 보낸다.

### Payment

- Payment Application은 Consumer의 입장으로서 Product Application으로부터 메시지 큐를 통해 요청을 받는다.

## 에러 로직 설계

### Payment

- Payment Application에서 에러가 발생하였을 경우 Product Application에 발생한 에러 메시지와 함께 에러 메시지 큐를 통해 요청을 보낸다.

### Product
- Product Application에서 에러가 발생하였을 경우 Order Application에 발생한 에러 메시지와 함께 에러 메시지 큐를 통해 요청을 보낸다.

- 동시에 Consumer의 입장으로서 Payment Application에서 에러가 발생한 탓에 에러 메시지 큐를 통해 받아온 요청이 있을 경우에도 Order Application에 발생한 에러 메시지와 함께 에러 메시지 큐를 통해 요청을 보낸다.

### Order

- Order Application은 Consumer의 입장으로서 Product Application으로부터 에러 메시지 큐를 통해 요청을 받는다.
