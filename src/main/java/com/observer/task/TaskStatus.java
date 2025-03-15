package com.observer.task;

/**
 * Enum dinh nghia cac trang thai co the co cua mot cong viec
 */
public enum TaskStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    IN_REVIEW("In Review"),
    TESTING("Testing"),
    DONE("Done"),
    BLOCKED("Blocked");
    
    private final String displayName;
    
    TaskStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
} 