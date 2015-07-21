import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class Controller {

    private ArrayList<Book>[] books;
    private ArrayDeque<Result> results;

    ExecutorService executor;
    List<Future<ArrayDeque<Result>>> list;

    private int adding_quee_id = 0;

    // number of jobs for threads
    private int DATA_DIVIDER = Runtime.getRuntime().availableProcessors() * 10;


    public Controller() {

        books = new ArrayList[DATA_DIVIDER];
        results = new ArrayDeque<Result>();

        for (int i = 0; i < DATA_DIVIDER; i++)
            books[i] = new ArrayList<>();

        executor = Executors.newCachedThreadPool();
    }


    synchronized public void addBook(String filename, String data, String folder) {
        books[adding_quee_id++].add(new Book(filename, data, folder));
        if (adding_quee_id >= DATA_DIVIDER)
            adding_quee_id = 0;
    }

    synchronized public LinkedList<Book.Data> getBooks() {
        LinkedList<Book.Data> result = new LinkedList<>();
        for (int i = 0; i < DATA_DIVIDER; i++) {
            for (Book b : books[i]) {
                result.add(b.getData());
            }
        }
        return result;
    }


    synchronized public ResultWrapper search(String word) throws InterruptedException {

        long searchTime = System.currentTimeMillis();
        results = new ArrayDeque<Result>();
        list = new ArrayList<Future<ArrayDeque<Result>>>();

        // parallel begin

        for (int i = 0; i < DATA_DIVIDER; i++) {
            list.add(executor.submit(new PSearchBook(books[i], word)));
        }

        for(Future<ArrayDeque<Result>> fut : list)
            try { results.addAll(fut.get()); } catch (InterruptedException | ExecutionException e) {System.out.println(e);}

        // parallel end

       // results
        return new ResultWrapper(results,System.currentTimeMillis()-searchTime);
    }
}
