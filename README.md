# Hệ Thống Quản Lý Thư Mục và Tập Tin

Đây là một ứng dụng Java minh họa việc sử dụng **Composite Design Pattern** để xây dựng hệ thống quản lý thư mục và tập tin theo mô hình cây (tree structure).

## Composite Design Pattern

Composite Design Pattern là một mẫu thiết kế thuộc nhóm cấu trúc (Structural Pattern), cho phép bạn tổ chức các đối tượng thành cấu trúc cây để biểu diễn mối quan hệ "phần-toàn" (part-whole hierarchy). Mẫu thiết kế này cho phép khách hàng xử lý các đối tượng riêng lẻ và các tổ hợp đối tượng một cách thống nhất.

### Các thành phần chính trong Composite Pattern:

1. **Component (FileSystemComponent)**: Interface hoặc lớp trừu tượng định nghĩa các phương thức chung cho tất cả các thành phần cụ thể.
2. **Leaf (File)**: Đại diện cho các đối tượng lá trong cấu trúc cây. Các đối tượng này không có con.
3. **Composite (Directory)**: Đại diện cho các đối tượng có con. Lưu trữ các thành phần con và triển khai các phương thức liên quan đến con trong interface Component.

## Cấu trúc dự án

```
src/main/java/com/filemanager/
├── FileSystemComponent.java  # Interface chung cho cả File và Directory
├── File.java                 # Lớp đại diện cho tập tin (Leaf)
├── Directory.java            # Lớp đại diện cho thư mục (Composite)
└── Main.java                 # Lớp chính để chạy thử ứng dụng
```

## Cách triển khai

1. **FileSystemComponent**: Interface định nghĩa các phương thức chung cho cả File và Directory như display(), getName(), getSize().
2. **File**: Lớp đại diện cho tập tin, triển khai interface FileSystemComponent.
3. **Directory**: Lớp đại diện cho thư mục, triển khai interface FileSystemComponent và chứa danh sách các thành phần con (có thể là File hoặc Directory khác).

## Ưu điểm của Composite Pattern trong bài toán này

1. **Tính đồng nhất**: Khách hàng có thể xử lý cả tập tin và thư mục một cách thống nhất thông qua interface chung.
2. **Dễ mở rộng**: Có thể dễ dàng thêm các loại thành phần mới mà không ảnh hưởng đến mã hiện có.
3. **Đơn giản hóa mã khách hàng**: Khách hàng không cần biết họ đang làm việc với loại đối tượng cụ thể nào (File hay Directory).
4. **Tính linh hoạt**: Có thể xây dựng cấu trúc cây phức tạp với nhiều cấp độ lồng nhau.

## Cách chạy ứng dụng

1. Biên dịch các file Java:
```bash
javac -d out src/main/java/com/filemanager/*.java
```

2. Chạy ứng dụng:
```bash
java -cp out com.filemanager.Main
```

## Kết quả

Khi chạy ứng dụng, bạn sẽ thấy:
1. Cấu trúc thư mục được hiển thị dưới dạng cây
2. Thông tin về kích thước của từng thư mục
3. Kết quả tìm kiếm các thành phần trong hệ thống file

## Áp dụng vào giao diện người dùng

Trong một giao diện người dùng, Composite Pattern có thể được áp dụng tương tự:
- **Component**: Interface chung cho tất cả các thành phần UI
- **Leaf**: Các thành phần UI cơ bản như Button, TextField, Label
- **Composite**: Các container như Panel, Frame, Dialog chứa các thành phần UI khác

Điều này cho phép xử lý các thành phần UI đơn giản và phức tạp một cách thống nhất, giúp việc phát triển giao diện người dùng trở nên dễ dàng và linh hoạt hơn. 