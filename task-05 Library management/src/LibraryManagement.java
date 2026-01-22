import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    List<String> books = new ArrayList<>();
    int noOfBooks;

    public void addBook(String title) {
        books.add(title);
        noOfBooks++;
        System.out.println(title+" book added");
    }

    public void displayBooks() {
        if (!books.isEmpty()) {
            System.out.println("Available Books : "+books);
        }
        else System.out.println("No books found");
        System.out.println("Total number of books : "+noOfBooks);
    }

    public void searchBook(String searchTitle) {
        if (books.contains(searchTitle)) System.out.println(searchTitle+" book exists.");
        else System.out.println("No such book found with title : "+searchTitle);
    }

    public void deleteBook(String deleteBookTitle) {
        if (books.contains(deleteBookTitle)){
            books.remove(deleteBookTitle);
            System.out.println(deleteBookTitle +" book deleted");
            noOfBooks--;
        }
        else System.out.println("No such book found with title : "+ deleteBookTitle);
    }
}

public class LibraryManagement {

    static String getInput(Scanner sc) {
        System.out.print("Enter book's title : ");
        sc.nextLine();
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
        System.out.println("\n----------Welcome to Library-----------------");
        System.out.println("1. Add new books \n2. Display all books \n3. Search a book by title \n4. Remove a book \n5. Exit");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        if (choice>5) System.out.println("Enter a valid option .");
        switch (choice) {
            case 1:
                lib.addBook(getInput(sc));
                break;
            case 2:
                lib.displayBooks();
                break;
            case 3:
                lib.searchBook(getInput(sc));
                break;
            case 4:
                lib.deleteBook(getInput(sc));
                break;
            case 5:
                System.exit(0);
            }
        }
    }
}
