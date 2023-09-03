# Library Management System

This is a simple Java-based Library Management System (LMS) application that allows users to manage a library's books and members. It provides features for both librarians and members.

## Table of Contents

1. [LibraryManagementApp class file](#1-librarymanagementapp-class-file)
2. [Library class file](#2-library-class-file)
3. [Member class file](#3-member-class-file)
4. [Book class file](#4-book-class-file)
5. [Transaction class file](#5-transaction-class-file)

---

### 1. LibraryManagementApp class file

The `LibraryManagementApp` class is the main class that serves as the entry point for the library management application. It provides a text-based user interface for librarians and members to interact with the library system.

### Features:

- Librarians can:
  - Register a member
  - Remove a member
  - Add a book
  - Remove a book
  - View all members along with their books and fines to be paid
  - View all books
- Members can:
  - List available books
  - List their borrowed books
  - Issue a book
  - Return a book
  - Pay fines (if any)
- Exiting the application

### Usage:

1. Compile and run the `LibraryManagementApp` class to start the application.
2. Follow the on-screen menu prompts to navigate through the available options.

---

### 2. Library class file

The `Library` class is responsible for managing library-related operations, such as registering members, adding/removing books, and handling book transactions. It also maintains lists of members, books, and transactions.

### Features:

- Registering members
- Removing members
- Adding books
- Removing books
- Viewing all members and their borrowed books
- Viewing all books
- Handling member-related operations (borrowing and returning books, paying fines)

### Usage:

This class is used internally by the `LibraryManagementApp` class to perform library management operations.

---

### 3. Member class file

The `Member` class represents a library member. It stores information about each member, including their unique ID, name, phone number, and a list of books they have borrowed.

### Usage:

This class is used internally by the `Library` class to manage member-related operations.

---

### 4. Book class file

The `Book` class represents a book in the library. It stores information about each book, including its unique ID, title, author, and the number of available copies.

### Usage:

This class is used internally by the `Library` class to manage book-related operations.

---

### 5. Transaction class file

The `Transaction` class represents a transaction when a member borrows a book. It stores information about the member's ID, the book's ID, and the date of the transaction.

### Usage:

This class is used internally by the `Library` class to track book transactions.

---

Feel free to explore and use this Library Management System as a reference or as a starting point for your own Java projects related to library management.
