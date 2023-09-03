package org.advancedprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Library {

    Scanner sc = new Scanner(System.in);
    private final List<Member> members;
    private final List<Book> books;
    private final List<Transaction> transactions;
    private Member loggedInMember;

    public Library() {
        members = new ArrayList<>();
        books = new ArrayList<>();
        transactions = new ArrayList<>();
        loggedInMember = null;
    }



    public void registerMember(String name, String phoneNo) {

        for (Member member : members){
            if (member.getPhoneNo().equals(phoneNo)){
                System.out.println("Member already exists.");
                return;
            }
        }
        int memberId = members.size()+1;
        Member newMember = new Member(memberId, name, phoneNo);
        members.add(newMember);
//        System.out.println("........................");
        System.out.println("Member successfully registered with memberId: "+ memberId+" !");
//        System.out.println("........................");
    }

    public void removeMember(int memberId) {


        Member memberToRemove =null;
        for (Member member: members){
            if(member.getMemberId()==memberId) {
                memberToRemove = member;
                break;
            }
        }
        if(memberToRemove==null){
            System.out.println("Member with Id: "+memberId+" doesn't exists.");
            return;
        }
//         `if (!memberToRemove.getBorrowedBooks().isEmpty()){
//            System.out.println("Cannot remove a member who is holding library books." +
//                    "Ask them to return them first");
//            return;
//        }
        members.remove(memberToRemove);
        System.out.println("Member with Id: "+memberId+" removed successfully.");

    }

    public void addBook(String title, String author, int totalCopies) {


        for (Book book : books){
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)){
                System.out.println("This book already exists.");
                System.out.println("Adding this lot of book into existing lot.(increasing no. of copies)");
                for (int i =0; i<totalCopies; i++){
                    book.increaseAvailableCopies();
                }
                return;

            }
        }

        int bookId = books.size()+1;

        Book newBook = new Book(bookId, title, author, totalCopies);
        books.add(newBook);
//        System.out.println("........................");
        System.out.println("book added successfully!");
//        System.out.println("........................");

    }

    public void removeBook(int bookId) {
        Book bookToRemove = null;
        for (Book book : books){
            if(book.getBookId()==bookId){
                bookToRemove=book;
                break;
            }
        }
        if(bookToRemove==null){
            System.out.println("Book with Id: "+bookId+" doesn't exists.");
            return;
        }
//        `for (Member `member : members) {
//            for (Book borrowedBook : member.getBorrowedBooks()) {
//                if (borrowedBook.getBookId() == bookId) {
//                    System.out.println("Cannot remove a book that is currently Issued.");
//                    return;
//                }
//            }
//        }
        books.remove(bookToRemove);
        System.out.println("Book with Id: "+bookId+" removed successfully.");


    }

    public void viewAllMembers() {

        for (Member member : members){
            System.out.println("Member ID: "+ member.getMemberId());
            System.out.println("Name: "+ member.getName());
            System.out.println("phone No. " +member.getPhoneNo());

            List<Book> issuedBooks = member.getBorrowedBooks();
            if(!issuedBooks.isEmpty()){
                System.out.println("Books Issued: ");
                for (Book book : issuedBooks){
                    System.out.println("Book Id: "+ book.getBookId());
                    System.out.println("Title: "+ book.getTitle());
                    System.out.println("Author: "+ book.getAuthor());
//                    System.out.println("........................");
                }

                double fine=0.0d;
                for (int i=0; i<member.getBorrowedBooks().size();i++){
                    fine += calculateFine(member.getBorrowedBooks().get(i),member)-30;
                }
                System.out.println("Fine to be paid: "+ fine);

            }
            else {
                System.out.println("No books issued.");

            }



        }
    }

    public void viewAllBooks() {


        for (Book book :books){
            System.out.println("Book ID - "+ book.getBookId());
            System.out.println("Title - "+ book.getTitle());
            System.out.println("Author - "+book.getAuthor()+"\n");
        }
//        System.out.println("........................");
    }

    public void enterAsMember(String name, String phoneNo){
        int c=0;

        for(Member member: members){
            if (member.getName().equals(name) && member.getPhoneNo().equals(phoneNo)) {
                loggedInMember = member;
                c=1;
                break;
            }

        }
        if (c==1){
            boolean op = true;


            while(op){

                System.out.println("Welcome "+name+". Member ID: "+loggedInMember.getMemberId());
                System.out.println("""
                                            ........................
                                            1. List Available Books
                                            2. List My Books
                                            3. Issue book
                                            4. Return book
                                            5. Pay Fine
                                            6. Back
                                            ........................
                                            """);

                int choice = sc.nextInt();
                sc.nextLine();
                int bookId;

                switch (choice) {
                    case 1 -> listAvailableBooks();
                    case 2 -> listMyBooks();
                    case 3 -> {
                        System.out.print("Book Id: ");
                        bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Book Name: ");
                        String bookName = sc.nextLine();
                        issueBook(bookId, bookName);
                    }
                    case 4 -> {
                        System.out.print("Enter Book Id: ");
                        bookId = sc.nextInt();
                        sc.nextLine();
                        returnBook(bookId);
                    }
                    case 5 -> {
                        double fine = payFine();
                        if (fine == 0) {
                            System.out.println("You have no fine to pay.");
                        } else {
                            System.out.println("You had a total fine of Rs." + fine + ". It has been paid successfully");
                        }
                    }
                    case 6 -> op = false;
                    default -> System.out.println("Invalid Choice. Please try again!");
                }
            }
        }
        else{
            System.out.println("Member with Name: "+name+ " and phone No: "+phoneNo+" doesn't exists.");
        }


    }

    public void listAvailableBooks(){
        System.out.println("Available Books: ");

        for (Book book :books){
            if (book.getAvailableCopies()>0){
                System.out.println("Book Id: "+ book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
//                System.out.println("........................");

            }
        }

    }

    public void listMyBooks(){

        System.out.println("Books Issued by "+ loggedInMember.getName()+ "(Member ID: "+loggedInMember.getMemberId()+"):");
        List<Book> borrowedBooks = loggedInMember.getBorrowedBooks();
        if(borrowedBooks.isEmpty()){
            System.out.println("You haven't borrowed any books.");
        }
        else{
            for (Book book: borrowedBooks){
                System.out.println("Book ID: "+book.getBookId());
                System.out.println("Title: "+ book.getTitle());
                System.out.println("Author: "+ book.getAuthor());
//                System.out.println("........................");
            }
        }
    }
    public void issueBook(int bookId, String bookName){

        Book bookToBorrow = null;

        for (Book book : books){
            if (book.getBookId()== bookId && book.getTitle().equals(bookName)){
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow==null){
            System.out.println("Book with ID " + bookId + " doesn't exist.");
            return;
        }

        if (bookToBorrow.getAvailableCopies()<= 0){
            System.out.println("Book with Id: "+bookId+" is not available.");
            return;
        }
        if (loggedInMember.getBorrowedBooks().size()>=2){
            System.out.println("You have already borrowed the maximum allowed no of books." +
                    "\nReturn borrowed book(s) first to Issue this book");
            return;

        }

//        `if (loggedInMember.getBalance()>0.0){
//            System.out.println("You have Fines to be paid. Amount: "+ loggedInMember.getBalance());
//            System.out.println("you have to pay your penalty amount first to issue a book.");
//            return;
//        }
        if(loggedInMember.getBorrowedBooks().size()==1){
            double fine = calculateFine(loggedInMember.getBorrowedBooks().get(0),loggedInMember) - 30;
            if(fine>0){
                System.out.println("You have pending penalty amount: "+fine+" to pay. " +
                        "\nThus you are not allowed to issue any book." +
                        "\nyou have to pay your penalty amount first");
                return;
            }

        }


        bookToBorrow.setAvailableCopies(bookToBorrow.getAvailableCopies()-1);
        loggedInMember.getBorrowedBooks().add(bookToBorrow);

//        String transactionId = LocalDateTime.now().toString();
        Transaction transaction = new Transaction(loggedInMember.getMemberId(), bookId, LocalDateTime.now());
        transactions.add(transaction);

        System.out.println("Book Id: "+ bookId+ " Issued Successfully." +
                "\nReturn it before 10days to avoid penalties.");

    }
    public void returnBook(int bookId){

        Book bookToReturn =null;

        for(Book book : books ){
            if(book.getBookId()==bookId){
                bookToReturn=book;
                break;
            }
        }

        if (bookToReturn==null){
            System.out.println("Book with ID " + bookId + " doesn't exist.");
            return;
        }

        if(!loggedInMember.getBorrowedBooks().contains(bookToReturn)){
            System.out.println("you have not borrowed the book having book ID: "+bookId);
            return;
        }



        double fineAmount = calculateFine(bookToReturn,loggedInMember)-30;
        if ((fineAmount/3) > 10) {

            System.out.println("Book having Id: "+bookId+" returned successfully." +
                    "A penalty of "+fineAmount+" has been charged for a delay of "+fineAmount/3+ "days");
        }

        else{
            System.out.println("Book having Id: "+bookId+" returned successfully." +
                    " No penalty deducted as you have returned it before the 10days from Issue/pay-fine date.");
        }

        bookToReturn.setAvailableCopies(bookToReturn.getAvailableCopies()+1);

        transactions.removeIf(transaction -> transaction.getMemberId()==loggedInMember.getMemberId() && transaction.getBookId()==bookId);

    }

    public double calculateFine(Book book, Member member) {

//        LocalDateTime dueDate
        LocalDateTime currentTime = LocalDateTime.now();

        long secondsOverdue = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getMemberId() == member.getMemberId() && transaction.getBookId() == book.getBookId()) {
                LocalDateTime dueDate = transaction.getIssueDate();
                secondsOverdue = ChronoUnit.SECONDS.between(dueDate, currentTime);
                break;
            }
        }
        if(secondsOverdue<10){
            return 0;
        }
        else{
            return 3 * (secondsOverdue);
        }
    }

    public double payFine (){
        double fine=0.0d;
        if(loggedInMember.getBorrowedBooks().isEmpty()){
            return 0;
        }
        else {

            for (int i=0; i<loggedInMember.getBorrowedBooks().size();i++){
                fine += calculateFine(loggedInMember.getBorrowedBooks().get(i),loggedInMember);
                for (Transaction transaction : transactions){
                    if (transaction.getMemberId() == loggedInMember.getMemberId() && transaction.getBookId() == loggedInMember.getBorrowedBooks().get(i).getBookId()){
                        transaction.setIssueDate(LocalDateTime.now());
                    }

                }

            }
//            `fine = calculateFine(loggedInMember.getBorrowedBooks().get(0),loggedInMember);
//            fine+= calculateFine(loggedInMember.getBorrowedBooks().get(1),loggedInMember);
        }


        return fine;



    }



}
