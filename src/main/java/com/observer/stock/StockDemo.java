package com.observer.stock;

/**
 * Lop demo cho Observer Pattern trong he thong theo doi co phieu
 */
public class StockDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO OBSERVER PATTERN - HE THONG THEO DOI CO PHIEU ===");
        
        // Tao cac co phieu
        Stock appleStock = new Stock("AAPL", 180.0);
        Stock googleStock = new Stock("GOOGL", 140.0);
        Stock teslaStock = new Stock("TSLA", 250.0);
        
        // Tao cac nha dau tu
        Investor investor1 = new Investor("Nguyen Van A");
        Investor investor2 = new Investor("Tran Thi B");
        
        // Tao cac moi gioi
        StockBroker broker1 = new StockBroker("Le Van C");
        StockBroker broker2 = new StockBroker("Pham Thi D");
        
        // Dang ky theo doi co phieu
        System.out.println("\n=== DANG KY THEO DOI CO PHIEU ===");
        
        // Nha dau tu 1 theo doi Apple va Tesla
        appleStock.registerObserver(investor1);
        teslaStock.registerObserver(investor1);
        System.out.println("Nha dau tu " + investor1.getName() + " dang ky theo doi co phieu AAPL, TSLA");
        
        // Nha dau tu 2 theo doi Google va Tesla
        googleStock.registerObserver(investor2);
        teslaStock.registerObserver(investor2);
        System.out.println("Nha dau tu " + investor2.getName() + " dang ky theo doi co phieu GOOGL, TSLA");
        
        // Moi gioi 1 theo doi tat ca co phieu
        appleStock.registerObserver(broker1);
        googleStock.registerObserver(broker1);
        teslaStock.registerObserver(broker1);
        System.out.println("Moi gioi " + broker1.getName() + " dang ky theo doi co phieu AAPL, GOOGL, TSLA");
        
        // Moi gioi 2 chi theo doi Apple va Google
        appleStock.registerObserver(broker2);
        googleStock.registerObserver(broker2);
        System.out.println("Moi gioi " + broker2.getName() + " dang ky theo doi co phieu AAPL, GOOGL");
        
        // Cap nhat gia co phieu va gui thong bao
        System.out.println("\n=== CAP NHAT GIA CO PHIEU ===");
        
        // Apple tang gia
        System.out.println("\nCap nhat gia co phieu Apple (AAPL):");
        appleStock.setPrice(190.0);
        
        // Google giam gia
        System.out.println("\nCap nhat gia co phieu Google (GOOGL):");
        googleStock.setPrice(130.0);
        
        // Tesla tang gia manh
        System.out.println("\nCap nhat gia co phieu Tesla (TSLA):");
        teslaStock.setPrice(270.0);
        
        // Huy dang ky theo doi
        System.out.println("\n=== HUY DANG KY THEO DOI ===");
        teslaStock.removeObserver(investor1);
        System.out.println("Nha dau tu " + investor1.getName() + " huy dang ky theo doi co phieu TSLA");
        
        // Cap nhat gia Tesla lan nua
        System.out.println("\nCap nhat gia co phieu Tesla (TSLA) lan nua:");
        teslaStock.setPrice(260.0);
    }
} 