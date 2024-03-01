#springBoot_Project

Develop a Library Management System for Librarians
---------------------------------------------------
Design and implement a library management system using core java, Hibernate, Lombok, SpringBoot and MySql.
---------------------------------------------------

Book Management:

--> Create a Book entity with attributes: id, title, author, isbn, publishedDate, and availableCopies.
--> Build REST API endpoints to cover CRUD operations for the Book entity
--> Implement a search functionality to find books by title, author, or isbn.


Member Management:

--> Create a Member entity with attributes: id, name, phone, registeredDate.
--> Build REST API endpoints to cover CRUD operations for the Member entity.


Borrowing Management:

--> Create a Borrow entity with attributes: id, memberId, bookId, borrowedDate, dueDate.
--> Build REST API endpoints to cover CRUD operations for the Borrow entity.
--> A librarian can lend a book to a member if it's available (i.e., availableCopies > 0). Update availableCopies by decrementing it by 1 and add a new Borrow record.
--> A librarian can accept a returned book. Update availableCopies by incrementing it by 1 and update the Borrow record.
--> For the API endpoints of Borrowing Management, join the Book and Member details with the Borrow entity. The response should include book and member attributes along with other attributes of the Borrow entity.
