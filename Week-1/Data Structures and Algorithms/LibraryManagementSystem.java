class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + " | " + title + " | " + author);
    }
}

public class LibraryManagementSystem {

    // Linear Search
    static void linearSearch(Book[] books, String title) {

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                book.display();
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    // Binary Search (Books must be sorted by title)
    static void binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                System.out.println("Book Found:");
                books[mid].display();
                return;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Book Not Found.");
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Algorithms", "Thomas Cormen"),
                new Book(102, "Computer Networks", "Andrew Tanenbaum"),
                new Book(103, "Database Systems", "Raghu Ramakrishnan"),
                new Book(104, "Java Programming", "Herbert Schildt"),
                new Book(105, "Operating Systems", "Galvin")
        };

        System.out.println("Linear Search:");
        linearSearch(books, "Java Programming");

        System.out.println();

        System.out.println("Binary Search:");
        binarySearch(books, "Java Programming");
    }
}