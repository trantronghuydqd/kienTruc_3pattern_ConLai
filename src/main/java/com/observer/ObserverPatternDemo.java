package com.observer;

import com.observer.stock.StockDemo;
import com.observer.task.TaskDemo;

/**
 * Lop chinh de chay ca hai vi du ve Observer Pattern
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        System.out.println("========== OBSERVER PATTERN DEMO ==========");
        System.out.println("\n1. VI DU VE HE THONG THEO DOI CO PHIEU");
        System.out.println("----------------------------------------");
        StockDemo.main(args);
        
        System.out.println("\n\n2. VI DU VE HE THONG THEO DOI CONG VIEC");
        System.out.println("----------------------------------------");
        TaskDemo.main(args);
        
        System.out.println("\n========== KET THUC DEMO ==========");
    }
} 