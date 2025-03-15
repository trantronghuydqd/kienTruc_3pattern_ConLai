package com.observer.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Lop dai dien cho mot co phieu
 * Day la Concrete Subject trong Observer Pattern
 */
public class Stock implements Subject {
    private String symbol;
    private double price;
    private List<StockObserver> observers;
    private double previousPrice;
    
    /**
     * Khoi tao mot co phieu moi
     * @param symbol Ma co phieu
     * @param initialPrice Gia khoi diem
     */
    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
        this.previousPrice = initialPrice;
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(StockObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        double changePercent = ((price - previousPrice) / previousPrice) * 100;
        for (StockObserver observer : observers) {
            observer.update(symbol, price, changePercent);
        }
    }
    
    /**
     * Cap nhat gia moi cho co phieu
     * @param newPrice Gia moi cua co phieu
     */
    public void setPrice(double newPrice) {
        this.previousPrice = this.price;
        this.price = newPrice;
        notifyObservers();
    }
    
    /**
     * Lay ma co phieu
     * @return Ma co phieu
     */
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * Lay gia hien tai cua co phieu
     * @return Gia hien tai
     */
    public double getPrice() {
        return price;
    }
} 