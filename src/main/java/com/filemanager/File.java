package com.filemanager;

/**
 * Lop dai dien cho mot tap tin trong he thong
 * Day la thanh phan Leaf trong Composite Pattern
 */
public class File implements FileSystemComponent {
    private String name;
    private long size;
    private String extension;
    
    /**
     * Khoi tao mot tap tin moi
     * @param name Ten tap tin
     * @param size Kich thuoc tap tin (bytes)
     * @param extension Phan mo rong cua tap tin
     */
    public File(String name, long size, String extension) {
        this.name = name;
        this.size = size;
        this.extension = extension;
    }
    
    @Override
    public void display() {
        System.out.println("File: " + name + "." + extension + " (" + size + " bytes)");
    }
    
    @Override
    public void display(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append("|- File: ").append(name).append(".").append(extension)
          .append(" (").append(size).append(" bytes)");
        System.out.println(sb.toString());
    }
    
    @Override
    public String getName() {
        return name + "." + extension;
    }
    
    @Override
    public long getSize() {
        return size;
    }
    
    /**
     * Lay phan mo rong cua tap tin
     * @return Phan mo rong
     */
    public String getExtension() {
        return extension;
    }
} 