package com.observer.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Lop dai dien cho mot cong viec trong du an
 * Day la Concrete Subject trong Observer Pattern
 */
public class Task implements TaskSubject {
    private int id;
    private String name;
    private String description;
    private TaskStatus status;
    private TaskStatus previousStatus;
    private List<TaskObserver> observers;
    
    /**
     * Khoi tao mot cong viec moi
     * @param id ID cua cong viec
     * @param name Ten cong viec
     * @param description Mo ta cong viec
     */
    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.previousStatus = TaskStatus.TODO;
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(TaskObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    @Override
    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(id, name, previousStatus, status);
        }
    }
    
    /**
     * Cap nhat trang thai cong viec
     * @param newStatus Trang thai moi
     */
    public void setStatus(TaskStatus newStatus) {
        this.previousStatus = this.status;
        this.status = newStatus;
        notifyObservers();
    }
    
    /**
     * Lay ID cua cong viec
     * @return ID cong viec
     */
    public int getId() {
        return id;
    }
    
    /**
     * Lay ten cong viec
     * @return Ten cong viec
     */
    public String getName() {
        return name;
    }
    
    /**
     * Lay mo ta cong viec
     * @return Mo ta cong viec
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Lay trang thai hien tai cua cong viec
     * @return Trang thai hien tai
     */
    public TaskStatus getStatus() {
        return status;
    }
} 