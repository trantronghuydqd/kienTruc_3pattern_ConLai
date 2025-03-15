package com.filemanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Lop dai dien cho mot thu muc trong he thong
 * Day la thanh phan Composite trong Composite Pattern
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;
    
    /**
     * Khoi tao mot thu muc moi
     * @param name Ten thu muc
     */
    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }
    
    /**
     * Them mot thanh phan vao thu muc
     * @param component Thanh phan can them (co the la File hoac Directory)
     */
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }
    
    /**
     * Xoa mot thanh phan khoi thu muc
     * @param component Thanh phan can xoa
     * @return true neu xoa thanh cong, false neu khong tim thay
     */
    public boolean removeComponent(FileSystemComponent component) {
        return components.remove(component);
    }
    
    /**
     * Lay danh sach cac thanh phan trong thu muc
     * @return Danh sach cac thanh phan
     */
    public List<FileSystemComponent> getComponents() {
        return components;
    }
    
    @Override
    public void display() {
        System.out.println("Directory: " + name + " (" + getSize() + " bytes)");
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
    
    @Override
    public void display(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append("|- Directory: ").append(name)
          .append(" (").append(getSize()).append(" bytes)");
        System.out.println(sb.toString());
        
        for (FileSystemComponent component : components) {
            component.display(indent + 1);
        }
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
    
    /**
     * Tim kiem mot thanh phan theo ten
     * @param name Ten thanh phan can tim
     * @return Thanh phan neu tim thay, null neu khong tim thay
     */
    public FileSystemComponent findComponentByName(String name) {
        for (FileSystemComponent component : components) {
            if (component.getName().equals(name)) {
                return component;
            }
            
            // Neu la thu muc, tim kiem de quy trong thu muc con
            if (component instanceof Directory) {
                FileSystemComponent found = ((Directory) component).findComponentByName(name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
} 