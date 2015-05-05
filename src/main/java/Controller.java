import java.util.ArrayList;

public class Controller {


    public static ArrayList<Book> getBooks() {
        return Model.getBooks();
    }

    public static void addBook(String filename, String data, String folder) {
        Model.addBook(filename, data, folder);
    }

    public static String search(String word) {
        ArrayList<Book> books = Model.getBooks();
        String result = "";


        for(Book book:books){
            if(book.getData().contains(word)){
                result+=book.getFilename()+" ";
            }
        }

        return result;
    }
}
