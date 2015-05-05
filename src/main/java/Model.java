import java.util.ArrayList;


public class Model {

    private static ArrayList<Book> books = new ArrayList<>();

    public static void init(){
        books.add(new Book("reymont-chlopi-zima.txt", "data", "/home/data/example"));
        books.add(new Book("Orwell-1984.txt", "data", "/home/data/"));
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void addBook(String filename, String data, String folder) {
        books.add(new Book(filename, data, folder));
    }
}
