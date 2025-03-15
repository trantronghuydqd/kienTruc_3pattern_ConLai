# Observer Design Pattern

Observer Design Pattern là một mẫu thiết kế thuộc nhóm hành vi (Behavioral Pattern), cho phép một đối tượng (gọi là Subject) thông báo cho nhiều đối tượng khác (gọi là Observer) khi trạng thái của nó thay đổi.

## Các thành phần chính trong Observer Pattern

1. **Subject**: Đối tượng được quan sát, chứa danh sách các observer và cung cấp các phương thức để thêm, xóa và thông báo cho các observer.
2. **Observer**: Interface hoặc lớp trừu tượng định nghĩa phương thức update() sẽ được gọi khi Subject thay đổi trạng thái.
3. **ConcreteSubject**: Triển khai Subject, lưu trữ trạng thái và thông báo cho các observer khi trạng thái thay đổi.
4. **ConcreteObserver**: Triển khai Observer, lưu trữ tham chiếu đến ConcreteSubject và cập nhật trạng thái của nó khi nhận được thông báo.

## Ví dụ 1: Hệ thống theo dõi cổ phiếu

Trong ví dụ này, chúng ta triển khai Observer Pattern để thông báo cho các nhà đầu tư và môi giới khi giá cổ phiếu thay đổi.

### Các thành phần:

- **Subject**: Interface `Subject` định nghĩa các phương thức để đăng ký, hủy đăng ký và thông báo cho các observer.
- **ConcreteSubject**: Lớp `Stock` triển khai interface `Subject`, lưu trữ thông tin về cổ phiếu và thông báo cho các observer khi giá thay đổi.
- **Observer**: Interface `StockObserver` định nghĩa phương thức `update()` sẽ được gọi khi giá cổ phiếu thay đổi.
- **ConcreteObserver**: Các lớp `Investor` và `StockBroker` triển khai interface `StockObserver`, nhận thông báo và phản ứng khi giá cổ phiếu thay đổi.

## Ví dụ 2: Hệ thống theo dõi công việc trong dự án phần mềm

Trong ví dụ này, chúng ta triển khai Observer Pattern để thông báo cho các thành viên trong nhóm khi trạng thái công việc thay đổi.

### Các thành phần:

- **Subject**: Interface `TaskSubject` định nghĩa các phương thức để đăng ký, hủy đăng ký và thông báo cho các observer.
- **ConcreteSubject**: Lớp `Task` triển khai interface `TaskSubject`, lưu trữ thông tin về công việc và thông báo cho các observer khi trạng thái thay đổi.
- **Observer**: Interface `TaskObserver` định nghĩa phương thức `update()` sẽ được gọi khi trạng thái công việc thay đổi.
- **ConcreteObserver**: Các lớp `Developer` và `ProjectManager` triển khai interface `TaskObserver`, nhận thông báo và phản ứng khi trạng thái công việc thay đổi.

## Ưu điểm của Observer Pattern

1. **Loose Coupling**: Subject và Observer không phụ thuộc chặt chẽ vào nhau, chúng chỉ tương tác thông qua interface.
2. **Broadcast Communication**: Subject có thể thông báo cho nhiều Observer cùng một lúc.
3. **Dễ mở rộng**: Có thể thêm Observer mới mà không cần thay đổi Subject.

## Nhược điểm của Observer Pattern

1. **Memory Leaks**: Nếu không hủy đăng ký Observer khi không cần thiết, có thể gây ra rò rỉ bộ nhớ.
2. **Unexpected Updates**: Observer có thể nhận được thông báo không mong muốn hoặc không cần thiết.
3. **Order of Notification**: Thứ tự thông báo cho các Observer có thể không xác định.

## Cách chạy ứng dụng

1. Biên dịch các file Java:
```bash
javac -d out src/main/java/com/observer/*.java src/main/java/com/observer/stock/*.java src/main/java/com/observer/task/*.java
```

2. Chạy ứng dụng:
```bash
java -cp out com.observer.ObserverPatternDemo
``` 