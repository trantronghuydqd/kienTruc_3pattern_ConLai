package com.observer.task;

/**
 * Interface cho Subject trong Observer Pattern
 * Dinh nghia cac phuong thuc de quan ly va thong bao cho cac observer
 */
public interface TaskSubject {
    /**
     * Dang ky mot observer moi
     * @param observer Observer can dang ky
     */
    void registerObserver(TaskObserver observer);
    
    /**
     * Huy dang ky mot observer
     * @param observer Observer can huy dang ky
     */
    void removeObserver(TaskObserver observer);
    
    /**
     * Thong bao cho tat ca cac observer da dang ky
     */
    void notifyObservers();
} 