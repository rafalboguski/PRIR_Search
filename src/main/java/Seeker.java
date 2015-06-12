import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Callable;


public class Seeker implements Callable<ArrayDeque<Result>> {

    private ArrayList<Book> books= new ArrayList<>();

    private String word;

    public Seeker( ArrayList<Book> books, String word) {
        this.books = books;
        this.word = word;
    }

    ArrayDeque<Result> results = new ArrayDeque<>();
    Result tmp=null;

    @Override
    public ArrayDeque<Result> call() throws Exception {
        long time = System.currentTimeMillis();

        for (Book b : books) {
            //try { Thread.sleep(1); } catch (InterruptedException e) {}
            if ((tmp = b.search(word)) != null )
                if(tmp.positions.size()>0)
                    results.add(tmp);
        }

        //System.out.println(  "_"+ (System.currentTimeMillis() - time)+"  books__"+books.size());
        return results;
    }

//    public ArrayList<Book> getBooks() {
//        return books;
//    }
}
