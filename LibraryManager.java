import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String ISBN;
    String author;
    String dateOfPublish;

    public Book(String title, String ISBN, String author, String dateOfPublish) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.dateOfPublish = dateOfPublish;
    }
}

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String ISBN, String author, String dateOfPublish) {
        Book book = new Book(title, ISBN, author, dateOfPublish);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void searchBook(String searchTitle) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.title);
                System.out.println("ISBN: " + book.ISBN);
                System.out.println("Author: " + book.author);
                System.out.println("Date of Publish: " + book.dateOfPublish);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        // Example usage
        libraryManager.addBook("Java Programming", "978-0135166307", "John Doe", "2020-10-01");
        libraryManager.addBook("Python Cookbook", "978-0596158095", "Jane Smith", "2013-05-10");

        System.out.println("Welcome to Library Manager!");
        System.out.println("1. Add a book");
        System.out.println("2. Search for a book");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.next();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.next();
                System.out.print("Enter author: ");
                String author = scanner.next();
                System.out.print("Enter date of publish: ");
                String dateOfPublish = scanner.next();
                libraryManager.addBook(title, isbn, author, dateOfPublish);
                break;
            case 2:
                System.out.print("Enter the title of the book to search: ");
                String searchTitle = scanner.next();
                libraryManager.searchBook(searchTitle);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
