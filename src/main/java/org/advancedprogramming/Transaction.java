package org.advancedprogramming;

import java.time.LocalDateTime;

public class Transaction {
    private final int memberId;
    private final int bookId;
    private LocalDateTime issueDate;


    public Transaction(int memberId, int bookId, LocalDateTime issueDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate){
        this.issueDate = issueDate;
    }
}
