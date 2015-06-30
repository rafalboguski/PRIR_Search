import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;


public class PSearchBook implements Callable<ArrayDeque<Result>> {

    private ArrayList<Book> books = new ArrayList<>();
    private String word;
    private ArrayDeque<Result> results = new ArrayDeque<>();
    private Result tmp = null;

    public PSearchBook(ArrayList<Book> books, String word) {
        this.books = books;
        this.word = word;
    }


    /*
        Returns array of found matches (Result) in books assigned to this job
     */
    @Override
    public ArrayDeque<Result> call() throws Exception {

        for (Book b : books) {
            if ((tmp = b.search(word)) != null)
                if (tmp.positions.size() > 0)
                    results.add(tmp);
        }

        return results;

    }
}
