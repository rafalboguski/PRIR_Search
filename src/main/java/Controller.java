import java.util.ArrayList;

public class Controller {

    Model library;

    public Controller(){
        library = new Model();
    }

    public  ArrayList<Book> getBooks() {
        return library.getBooks();
    }

    public  void addBook(String filename, String data, String folder) {
        library.addBook(filename, data, folder);
    }

    public  String search(String word) {
        ArrayList<Book> books = library.getBooks();
        String result = "";


        for(Book book:books){
            if(book.getData().contains(word)){
                result+=book.getFilename()+" ";
            }
        }

        return result;
    }
}
