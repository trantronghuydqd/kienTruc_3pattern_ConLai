package com.observer.stock;

/**
 * Lop dai dien cho mot nha dau tu
 * Day la Concrete Observer trong Observer Pattern
 */
public class Investor implements StockObserver {
    private String name;
    
    /**
     * Khoi tao mot nha dau tu moi
     * @param name Ten nha dau tu
     */
    public Investor(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String stockSymbol, double price, double changePercent) {
        System.out.printf("Thong bao cho nha dau tu %s: Co phieu %s da thay doi %.2f%% - Gia moi: %.2f\n", 
                name, stockSymbol, changePercent, price);
        
        if (changePercent > 0) {
            System.out.printf("Nha dau tu %s: Co phieu %s dang tang, co the la co hoi tot de mua them!\n", 
                    name, stockSymbol);
        } else if (changePercent < 0) {
            System.out.printf("Nha dau tu %s: Co phieu %s dang giam, can xem xet lai chien luoc!\n", 
                    name, stockSymbol);
        }
    }
    
    /**
     * Lay ten nha dau tu
     * @return Ten nha dau tu
     */
    public String getName() {
        return name;
    }
} 