package com.observer.stock;

/**
 * Interface cho Observer trong Observer Pattern
 * Dinh nghia phuong thuc update se duoc goi khi co su thay doi ve gia co phieu
 */
public interface StockObserver {
    /**
     * Phuong thuc duoc goi khi co su thay doi ve gia co phieu
     * @param stockSymbol Ma co phieu
     * @param price Gia moi cua co phieu
     * @param changePercent Phan tram thay doi
     */
    void update(String stockSymbol, double price, double changePercent);
} 