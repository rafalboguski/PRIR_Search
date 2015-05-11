import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class Controller {

    public Controller() {

        books = new ArrayList[THREADS_NUM];
        results = new ArrayDeque<Result>();

        for (int i = 0; i < THREADS_NUM; i++)
            books[i] = new ArrayList<>();

    }



    private int THREADS_NUM = 4;
    private ArrayList<Book>[] books;
    private ArrayDeque<Result> results;

    private int adding_quee_id = 0;

    public void addBook(String filename, String data, String folder) {
        books[adding_quee_id++].add(new Book(filename,data,folder));
        if(adding_quee_id>=THREADS_NUM)
            adding_quee_id=0;
    }

    public LinkedList<Book> getBooks() {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < THREADS_NUM; i++)
            result.addAll(books[i]);
        return result;
    }


    public ArrayDeque<Result>  search(String word) throws InterruptedException {

        results.clear();
        ArrayList<Thread> threads = new ArrayList<>();


        for (int i = 0; i < THREADS_NUM; i++)
            threads.add(new Thread(new Seeker(books[i], word, results)));


        long join = System.currentTimeMillis();


        for (Thread t : threads)
            t.start();

        for (Thread t : threads)
            t.join();

        System.out.println("    Join__time " + (System.currentTimeMillis() - join) + " ms");


        return results;
    }



}
