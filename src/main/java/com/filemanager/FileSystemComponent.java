package com.filemanager;

/**
 * Interface dai dien cho mot thanh phan trong he thong file
 * Day la thanh phan Component trong Composite Pattern
 */
public interface FileSystemComponent {
    /**
     * Hien thi thong tin cua thanh phan
     */
    void display();
    
    /**
     * Hien thi thong tin chi tiet cua thanh phan voi muc do thut le
     * @param indent Muc do thut le
     */
    void display(int indent);
    
    /**
     * Lay ten cua thanh phan
     * @return Ten cua thanh phan
     */
    String getName();
    
    /**
     * Lay kich thuoc cua thanh phan
     * @return Kich thuoc (bytes)
     */
    long getSize();
} 