package com.observer.task;

/**
 * Lop dai dien cho mot lap trinh vien
 * Day la Concrete Observer trong Observer Pattern
 */
public class Developer implements TaskObserver {
    private String name;
    private String role;
    
    /**
     * Khoi tao mot lap trinh vien moi
     * @param name Ten lap trinh vien
     * @param role Vai tro cua lap trinh vien
     */
    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }
    
    @Override
    public void update(int taskId, String taskName, TaskStatus oldStatus, TaskStatus newStatus) {
        System.out.printf("Thong bao cho lap trinh vien %s (%s): Cong viec #%d - '%s' da thay doi trang thai tu %s thanh %s\n", 
                name, role, taskId, taskName, oldStatus.getDisplayName(), newStatus.getDisplayName());
        
        // Phan ung khac nhau tuy thuoc vao trang thai moi
        if (newStatus == TaskStatus.IN_REVIEW && role.equals("Senior Developer")) {
            System.out.printf("Lap trinh vien %s: Can review code cho task #%d\n", name, taskId);
        } else if (newStatus == TaskStatus.TESTING && role.equals("QA Engineer")) {
            System.out.printf("Lap trinh vien %s: Can test task #%d\n", name, taskId);
        } else if (newStatus == TaskStatus.BLOCKED) {
            System.out.printf("Lap trinh vien %s: Task #%d dang bi chan, can kiem tra nguyen nhan\n", name, taskId);
        }
    }
    
    /**
     * Lay ten lap trinh vien
     * @return Ten lap trinh vien
     */
    public String getName() {
        return name;
    }
    
    /**
     * Lay vai tro cua lap trinh vien
     * @return Vai tro cua lap trinh vien
     */
    public String getRole() {
        return role;
    }
} 