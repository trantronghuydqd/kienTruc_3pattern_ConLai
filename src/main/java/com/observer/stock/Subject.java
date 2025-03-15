package com.observer.stock;

/**
 * Interface cho Subject trong Observer Pattern
 * Dinh nghia cac phuong thuc de quan ly va thong bao cho cac observer
 */
public interface Subject {
    /**
     * Dang ky mot observer moi
     * @param observer Observer can dang ky
     */
    void registerObserver(StockObserver observer);
    
    /**
     * Huy dang ky mot observer
     * @param observer Observer can huy dang ky
     */
    void removeObserver(StockObserver observer);
    
    /**
     * Thong bao cho tat ca cac observer da dang ky
     */
    void notifyObservers();
} 