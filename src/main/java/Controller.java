import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class Controller {

    public Controller() {

        books = new ArrayList[DATA_DIVIDER];
        results = new ArrayDeque<Result>();

        for (int i = 0; i < DATA_DIVIDER; i++)
            books[i] = new ArrayList<>();

        executor = Executors.newCachedThreadPool(); // tutaj mozna sie bawic roznymi rodzajami executorow casched imo najlepszy
    }


    private int DATA_DIVIDER = 44; // Liczba ksiazek/DATA_DIVIDER = ksiazka w jednym zadaniu do pool-a
    private int THREADS_NUM = 4;  // tylko do testow innych executorow newCachedThreadPool daje zawsze max ilosc watkow

    private ArrayList<Book>[] books;
    private ArrayDeque<Result> results;

    private int adding_quee_id = 0;

    synchronized public void addBook(String filename, String data, String folder) {
        books[adding_quee_id++].add(new Book(filename,data,folder));
        if(adding_quee_id>= DATA_DIVIDER)
            adding_quee_id=0;
    }

    synchronized public LinkedList<Book.Data> getBooks() {
        LinkedList<Book.Data> result = new LinkedList<>();
        for (int i = 0; i < DATA_DIVIDER; i++) {
            for(Book b:books[i]){
                result.add(b.getData());
            }
        }
        return result;
    }

    ExecutorService executor;
    List<Future<ArrayDeque<Result>>> list;
    synchronized public ArrayDeque<Result> search(String word) throws InterruptedException {

        results = new ArrayDeque<Result>();

        list = new ArrayList<Future<ArrayDeque<Result>>>();
        long join = System.currentTimeMillis();

        for(int i=0; i< DATA_DIVIDER; i++){
            list.add( executor.submit(new PSearchBook(books[i], word)));
        }

        for(Future<ArrayDeque<Result>> fut : list)
            try { results.addAll(fut.get()); } catch (InterruptedException | ExecutionException e) {}


        //System.out.println((System.currentTimeMillis() - join));

        return results;
    }



}
