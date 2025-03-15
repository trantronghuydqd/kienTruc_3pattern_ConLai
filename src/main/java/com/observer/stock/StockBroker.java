package com.observer.stock;

/**
 * Lop dai dien cho mot moi gioi chung khoan
 * Day la Concrete Observer trong Observer Pattern
 */
public class StockBroker implements StockObserver {
    private String name;
    
    /**
     * Khoi tao mot moi gioi chung khoan moi
     * @param name Ten moi gioi
     */
    public StockBroker(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String stockSymbol, double price, double changePercent) {
        System.out.printf("Moi gioi %s nhan thong bao: Co phieu %s thay doi %.2f%% - Gia hien tai: %.2f\n", 
                name, stockSymbol, changePercent, price);
        
        // Phan tich va dua ra loi khuyen cho khach hang
        if (changePercent > 5) {
            System.out.printf("Moi gioi %s: Khuyen nghi khach hang xem xet ban co phieu %s de chot loi\n", 
                    name, stockSymbol);
        } else if (changePercent < -5) {
            System.out.printf("Moi gioi %s: Khuyen nghi khach hang xem xet mua them co phieu %s o muc gia thap\n", 
                    name, stockSymbol);
        }
    }
    
    /**
     * Lay ten moi gioi
     * @return Ten moi gioi
     */
    public String getName() {
        return name;
    }
} 