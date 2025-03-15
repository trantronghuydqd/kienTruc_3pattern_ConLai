package com.observer.task;

/**
 * Interface cho Observer trong Observer Pattern
 * Dinh nghia phuong thuc update se duoc goi khi co su thay doi ve trang thai cong viec
 */
public interface TaskObserver {
    /**
     * Phuong thuc duoc goi khi co su thay doi ve trang thai cong viec
     * @param taskId ID cua cong viec
     * @param taskName Ten cong viec
     * @param oldStatus Trang thai cu
     * @param newStatus Trang thai moi
     */
    void update(int taskId, String taskName, TaskStatus oldStatus, TaskStatus newStatus);
} 