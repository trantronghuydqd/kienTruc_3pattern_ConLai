package com.observer.task;

/**
 * Lop demo cho Observer Pattern trong he thong theo doi cong viec
 */
public class TaskDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO OBSERVER PATTERN - HE THONG THEO DOI CONG VIEC ===");
        
        // Tao cac cong viec
        Task task1 = new Task(1001, "Phat trien tinh nang dang nhap", "Xay dung form dang nhap va xu ly xac thuc nguoi dung");
        Task task2 = new Task(1002, "Thiet ke giao dien nguoi dung", "Thiet ke UI/UX cho trang chu va cac trang con");
        Task task3 = new Task(1003, "Toi uu hoa co so du lieu", "Toi uu cac truy van va chi muc trong database");
        
        // Tao cac lap trinh vien
        Developer dev1 = new Developer("Nguyen Van A", "Frontend Developer");
        Developer dev2 = new Developer("Tran Thi B", "Backend Developer");
        Developer dev3 = new Developer("Le Van C", "Senior Developer");
        Developer dev4 = new Developer("Pham Thi D", "QA Engineer");
        
        // Tao quan ly du an
        ProjectManager manager = new ProjectManager("Hoang Van E");
        
        // Dang ky theo doi cong viec
        System.out.println("\n=== DANG KY THEO DOI CONG VIEC ===");
        
        // Task 1: Frontend Developer va QA Engineer theo doi
        task1.registerObserver(dev1);
        task1.registerObserver(dev4);
        task1.registerObserver(manager);
        System.out.println("Cong viec #" + task1.getId() + " duoc theo doi boi: " + dev1.getName() + ", " + dev4.getName() + ", " + manager.getName());
        
        // Task 2: Frontend Developer va Senior Developer theo doi
        task2.registerObserver(dev1);
        task2.registerObserver(dev3);
        task2.registerObserver(manager);
        System.out.println("Cong viec #" + task2.getId() + " duoc theo doi boi: " + dev1.getName() + ", " + dev3.getName() + ", " + manager.getName());
        
        // Task 3: Backend Developer va Senior Developer theo doi
        task3.registerObserver(dev2);
        task3.registerObserver(dev3);
        task3.registerObserver(manager);
        System.out.println("Cong viec #" + task3.getId() + " duoc theo doi boi: " + dev2.getName() + ", " + dev3.getName() + ", " + manager.getName());
        
        // Cap nhat trang thai cong viec va gui thong bao
        System.out.println("\n=== CAP NHAT TRANG THAI CONG VIEC ===");
        
        // Task 1: Tu TODO -> IN_PROGRESS
        System.out.println("\nCap nhat trang thai cong viec #" + task1.getId() + ":");
        task1.setStatus(TaskStatus.IN_PROGRESS);
        
        // Task 2: Tu TODO -> IN_PROGRESS -> IN_REVIEW
        System.out.println("\nCap nhat trang thai cong viec #" + task2.getId() + ":");
        task2.setStatus(TaskStatus.IN_PROGRESS);
        System.out.println("\nCap nhat trang thai cong viec #" + task2.getId() + " lan nua:");
        task2.setStatus(TaskStatus.IN_REVIEW);
        
        // Task 3: Tu TODO -> BLOCKED
        System.out.println("\nCap nhat trang thai cong viec #" + task3.getId() + ":");
        task3.setStatus(TaskStatus.BLOCKED);
        
        // Huy dang ky theo doi
        System.out.println("\n=== HUY DANG KY THEO DOI ===");
        task1.removeObserver(dev4);
        System.out.println("Lap trinh vien " + dev4.getName() + " huy dang ky theo doi cong viec #" + task1.getId());
        
        // Cap nhat trang thai Task 1 lan nua
        System.out.println("\nCap nhat trang thai cong viec #" + task1.getId() + " lan nua:");
        task1.setStatus(TaskStatus.TESTING);
        
        // Giai quyet van de cho Task 3 va cap nhat trang thai
        System.out.println("\nGiai quyet van de cho cong viec #" + task3.getId() + ":");
        task3.setStatus(TaskStatus.IN_PROGRESS);
        
        // Hoan thanh Task 2
        System.out.println("\nHoan thanh cong viec #" + task2.getId() + ":");
        task2.setStatus(TaskStatus.DONE);
    }
} 