package org.advancedprogramming;

//import java.util.List;
import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {

        Library library = new Library();



        Scanner sc = new Scanner(System.in);
        boolean k = true;
        int choice;

        while(k) {

            System.out.println("""
                    
                    ................Library Portal Initialized................
                    
                    ........................
                    1. Enter as a Librarian
                    2. Enter as a Member
                    3. Exit
                    ........................
                    """);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case (1) -> {
                    boolean ca = true;
                    while (ca) {

                        System.out.println("""
                                ........................
                                1. Register a member
                                2. Remove a member
                                3. Add a book
                                4. Remove a book
                                5. View all members along with their books and fines to be paid
                                6. View all books
                                7. Back
                                ........................
                                """);
                        choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {
                            case 1 -> {
                                System.out.println("........................");
//                                sc.nextLine();
                                System.out.print("Name: ");
                                String name = sc.nextLine();
                                System.out.print("Age: ");
                                int age = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Phone no.: ");
                                String phoneNo = sc.nextLine();
//                                System.out.println(age);
                                library.registerMember(name, phoneNo);
                                System.out.println("........................");
                            }
//                                System.out.println("Member Successfully Registered");
                            case 2 -> {
                                System.out.print("Member Id: ");
                                int memberId = sc.nextInt();
                                sc.nextLine();
                                library.removeMember(memberId);
                            }
                            case 3 -> {
                                System.out.println("........................");
                                sc.nextLine();
                                System.out.print("Book title: ");
                                String title = sc.nextLine();
                                System.out.print("Author: ");
                                String author = sc.nextLine();
                                System.out.print("copies: ");
                                int copies = sc.nextInt();
                                sc.nextLine();
                                library.addBook(title, author, copies);
                                System.out.println("........................");
                            }
                            case 4 -> {
                                System.out.print("Book Id: ");
                                int bookId = sc.nextInt();
                                sc.nextLine();
                                library.removeBook(bookId);
                            }
                            case 5 -> library.viewAllMembers();
                            case 6 -> library.viewAllBooks();
                            case 7 -> ca = false;
                            default -> System.out.println("Invalid choice. Please try again.");
                        }

                    }
                }
                case (2) -> {
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone no: ");
                    String phoneNo = sc.nextLine();
                    library.enterAsMember(name, phoneNo);
                    System.out.println("........................");
                }
                case (3) -> {
                    System.out.println("thanks for visiting!");
                    k = false;
                    sc.close();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }


        }


//        while(true){
//            System.out.println("""
//                    Library Management System
//                    1. Add Book
//                    2. Remove Book
//                    3. Register Member
//                    4. Remove Member
//                    5. Issue Book
//                    6. Return Book
//                    7. List Books
//                    8. List Members
//                    9. Calculate Fine
//                    10. Exit""");
//            System.out.println("Enter your choice: ");
//
//            int choice = sc.nextInt();
//
//            switch(choice){
//                case 1:
//                    System.out.println("Enter book ID: ");
//            }


    }

}
