package com.observer.task;

/**
 * Lop dai dien cho mot quan ly du an
 * Day la Concrete Observer trong Observer Pattern
 */
public class ProjectManager implements TaskObserver {
    private String name;
    
    /**
     * Khoi tao mot quan ly du an moi
     * @param name Ten quan ly du an
     */
    public ProjectManager(String name) {
        this.name = name;
    }
    
    @Override
    public void update(int taskId, String taskName, TaskStatus oldStatus, TaskStatus newStatus) {
        System.out.printf("Thong bao cho quan ly du an %s: Cong viec #%d - '%s' da thay doi trang thai tu %s thanh %s\n", 
                name, taskId, taskName, oldStatus.getDisplayName(), newStatus.getDisplayName());
        
        // Phan ung khac nhau tuy thuoc vao trang thai moi
        if (newStatus == TaskStatus.DONE) {
            System.out.printf("Quan ly du an %s: Cong viec #%d da hoan thanh, cap nhat tien do du an\n", name, taskId);
        } else if (newStatus == TaskStatus.BLOCKED) {
            System.out.printf("Quan ly du an %s: Cong viec #%d dang bi chan, can to chuc hop de giai quyet van de\n", name, taskId);
        } else if (oldStatus == TaskStatus.TODO && newStatus == TaskStatus.IN_PROGRESS) {
            System.out.printf("Quan ly du an %s: Cong viec #%d da bat dau duoc thuc hien\n", name, taskId);
        }
    }
    
    /**
     * Lay ten quan ly du an
     * @return Ten quan ly du an
     */
    public String getName() {
        return name;
    }
} 