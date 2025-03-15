package com.filemanager;

/**
 * Lop chinh de chay thu va minh hoa cach su dung Composite Pattern
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== HE THONG QUAN LY THU MUC VA TAP TIN ===");
        System.out.println("Su dung Composite Design Pattern");
        System.out.println();
        
        // Tao cau truc thu muc
        Directory root = new Directory("Root");
        
        // Tao cac thu muc con
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");
        Directory music = new Directory("Music");
        
        // Them cac thu muc con vao thu muc goc
        root.addComponent(documents);
        root.addComponent(pictures);
        root.addComponent(music);
        
        // Tao cac tap tin trong thu muc Documents
        File report = new File("Annual_Report", 2048, "pdf");
        File resume = new File("Resume", 1024, "docx");
        documents.addComponent(report);
        documents.addComponent(resume);
        
        // Tao thu muc con trong Documents
        Directory templates = new Directory("Templates");
        documents.addComponent(templates);
        
        // Them tap tin vao thu muc Templates
        File letterTemplate = new File("Letter_Template", 512, "docx");
        File invoiceTemplate = new File("Invoice_Template", 1024, "xlsx");
        templates.addComponent(letterTemplate);
        templates.addComponent(invoiceTemplate);
        
        // Tao cac tap tin trong thu muc Pictures
        File vacation = new File("Vacation_Photo", 4096, "jpg");
        File family = new File("Family_Photo", 3072, "png");
        pictures.addComponent(vacation);
        pictures.addComponent(family);
        
        // Tao cac tap tin trong thu muc Music
        File song1 = new File("Favorite_Song", 8192, "mp3");
        File song2 = new File("New_Album", 16384, "flac");
        music.addComponent(song1);
        music.addComponent(song2);
        
        // Hien thi cau truc thu muc
        System.out.println("=== CAU TRUC THU MUC ===");
        root.display(0);
        System.out.println();
        
        // Hien thi thong tin kich thuoc
        System.out.println("=== THONG TIN KICH THUOC ===");
        System.out.println("Tong kich thuoc thu muc Root: " + root.getSize() + " bytes");
        System.out.println("Kich thuoc thu muc Documents: " + documents.getSize() + " bytes");
        System.out.println("Kich thuoc thu muc Pictures: " + pictures.getSize() + " bytes");
        System.out.println("Kich thuoc thu muc Music: " + music.getSize() + " bytes");
        System.out.println("Kich thuoc thu muc Templates: " + templates.getSize() + " bytes");
        System.out.println();
        
        // Tim kiem thanh phan
        System.out.println("=== TIM KIEM THANH PHAN ===");
        FileSystemComponent foundComponent = root.findComponentByName("Resume.docx");
        if (foundComponent != null) {
            System.out.println("Da tim thay: " + foundComponent.getName() + " (" + foundComponent.getSize() + " bytes)");
        } else {
            System.out.println("Khong tim thay thanh phan");
        }
        
        foundComponent = root.findComponentByName("Invoice_Template.xlsx");
        if (foundComponent != null) {
            System.out.println("Da tim thay: " + foundComponent.getName() + " (" + foundComponent.getSize() + " bytes)");
        } else {
            System.out.println("Khong tim thay thanh phan");
        }
    }
} 