import java.util.ArrayList;


public class Model {

    private ArrayList<Book> books = new ArrayList<Book>();
    public int numberOfBooks =0;

    public Model(){

    }

    public void addBook(String filename, String data, String folder) {
        books.add(new Book(filename, data, folder));
        numberOfBooks++;
    }


    /*
        Rekursywnie dzieli elements na w miare rowne czesci i wkada je do results
     */
    public int[] divideEqually(int[] results, int elements) {
        int threads = results.length;
        int tmp = elements / threads;
        if (tmp > 0) {
            for (int i = 0; i < threads; i++) {
                results[i] += tmp;
            }
            if (threads * tmp < elements)
                results = divideEqually(results, elements - threads * tmp);
            return results;

        } else {
            tmp = elements;
            for (int i = 0; i < threads && tmp > 0; i++) {
                results[i]++;
                tmp--;
            }
            return results;
        }

    }


    public int getNumberOfBooks() {
        return numberOfBooks;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }


}
