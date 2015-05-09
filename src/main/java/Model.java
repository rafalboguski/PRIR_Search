import java.util.ArrayList;


public class Model {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Model(){
        books.add(new Book("reymont-chlopi-zima.txt", "data", "/home/data/example"));
        books.add(new Book("Orwell-1984.txt", "data", "/home/data/"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(String filename, String data, String folder) {
        books.add(new Book(filename, data, folder));
    }
}
