package org.advancedprogramming;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final int memberId;
    private final String name;

    private final String phoneNo;

    private final List<Book> borrowedBooks;


    public Member(int memberId, String name, String phoneNo) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }


    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}

