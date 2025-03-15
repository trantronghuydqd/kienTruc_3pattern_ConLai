# Design Patterns trong Java

Dự án này minh họa việc triển khai các mẫu thiết kế (Design Patterns) phổ biến trong Java.

## 1. Composite Design Pattern

Composite Design Pattern là một mẫu thiết kế thuộc nhóm cấu trúc (Structural Pattern), cho phép bạn tổ chức các đối tượng thành cấu trúc cây để biểu diễn mối quan hệ "phần-toàn" (part-whole hierarchy). Mẫu thiết kế này cho phép khách hàng xử lý các đối tượng riêng lẻ và các tổ hợp đối tượng một cách thống nhất.

### Ví dụ: Hệ thống quản lý thư mục và tập tin

Trong ví dụ này, chúng ta triển khai Composite Pattern để xây dựng hệ thống quản lý thư mục và tập tin theo mô hình cây.

#### Các thành phần:

- **Component**: Interface `FileSystemComponent` định nghĩa các phương thức chung cho cả thư mục và tập tin.
- **Leaf**: Lớp `File` đại diện cho tập tin, triển khai interface `FileSystemComponent`.
- **Composite**: Lớp `Directory` đại diện cho thư mục, triển khai interface `FileSystemComponent` và chứa danh sách các thành phần con.

#### Cấu trúc thư mục:

```
src/main/java/com/filemanager/
├── FileSystemComponent.java  # Interface chung cho cả File và Directory
├── File.java                 # Lớp đại diện cho tập tin (Leaf)
├── Directory.java            # Lớp đại diện cho thư mục (Composite)
└── Main.java                 # Lớp chính để chạy thử ứng dụng
```

## 2. Observer Design Pattern

Observer Design Pattern là một mẫu thiết kế thuộc nhóm hành vi (Behavioral Pattern), cho phép một đối tượng (gọi là Subject) thông báo cho nhiều đối tượng khác (gọi là Observer) khi trạng thái của nó thay đổi.

### Ví dụ 1: Hệ thống theo dõi cổ phiếu

Trong ví dụ này, chúng ta triển khai Observer Pattern để thông báo cho các nhà đầu tư và môi giới khi giá cổ phiếu thay đổi.

#### Các thành phần:

- **Subject**: Interface `Subject` định nghĩa các phương thức để đăng ký, hủy đăng ký và thông báo cho các observer.
- **ConcreteSubject**: Lớp `Stock` triển khai interface `Subject`, lưu trữ thông tin về cổ phiếu và thông báo cho các observer khi giá thay đổi.
- **Observer**: Interface `StockObserver` định nghĩa phương thức `update()` sẽ được gọi khi giá cổ phiếu thay đổi.
- **ConcreteObserver**: Các lớp `Investor` và `StockBroker` triển khai interface `StockObserver`, nhận thông báo và phản ứng khi giá cổ phiếu thay đổi.

### Ví dụ 2: Hệ thống theo dõi công việc trong dự án phần mềm

Trong ví dụ này, chúng ta triển khai Observer Pattern để thông báo cho các thành viên trong nhóm khi trạng thái công việc thay đổi.

#### Các thành phần:

- **Subject**: Interface `TaskSubject` định nghĩa các phương thức để đăng ký, hủy đăng ký và thông báo cho các observer.
- **ConcreteSubject**: Lớp `Task` triển khai interface `TaskSubject`, lưu trữ thông tin về công việc và thông báo cho các observer khi trạng thái thay đổi.
- **Observer**: Interface `TaskObserver` định nghĩa phương thức `update()` sẽ được gọi khi trạng thái công việc thay đổi.
- **ConcreteObserver**: Các lớp `Developer` và `ProjectManager` triển khai interface `TaskObserver`, nhận thông báo và phản ứng khi trạng thái công việc thay đổi.

#### Cấu trúc thư mục:

```
src/main/java/com/observer/
├── ObserverPatternDemo.java  # Lớp chính để chạy cả hai ví dụ
├── stock/                    # Ví dụ về hệ thống theo dõi cổ phiếu
│   ├── Subject.java          # Interface cho Subject
│   ├── StockObserver.java    # Interface cho Observer
│   ├── Stock.java            # Concrete Subject
│   ├── Investor.java         # Concrete Observer
│   ├── StockBroker.java      # Concrete Observer
│   └── StockDemo.java        # Lớp demo cho ví dụ cổ phiếu
└── task/                     # Ví dụ về hệ thống theo dõi công việc
    ├── TaskSubject.java      # Interface cho Subject
    ├── TaskObserver.java     # Interface cho Observer
    ├── TaskStatus.java       # Enum định nghĩa các trạng thái công việc
    ├── Task.java             # Concrete Subject
    ├── Developer.java        # Concrete Observer
    ├── ProjectManager.java   # Concrete Observer
    └── TaskDemo.java         # Lớp demo cho ví dụ công việc
```

## Cách chạy ứng dụng

### Chạy ví dụ Composite Pattern:

```bash
javac -d out src/main/java/com/filemanager/*.java
java -cp out com.filemanager.Main
```

### Chạy ví dụ Observer Pattern:

```bash
javac -d out src/main/java/com/observer/*.java src/main/java/com/observer/stock/*.java src/main/java/com/observer/task/*.java
java -cp out com.observer.ObserverPatternDemo
``` 