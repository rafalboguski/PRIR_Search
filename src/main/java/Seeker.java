import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;


public class Seeker implements Runnable {

    private ArrayList<Book> books= new ArrayList<>();
    private ArrayDeque<Result> results;

    private String word;

    public Seeker( ArrayList<Book> books, String word, ArrayDeque<Result> results) {
        this.books = books;
        this.results = results;
        this.word = word;
    }

    @Override
    public void run(){

        long time = System.currentTimeMillis();

//        for(Book b:books){
//            try { Thread.sleep(1); } catch (InterruptedException e) {}
//        }
//
//        results.add(new Result(3,"sdfsdf","sdfsdf"));

        Result tmp;
        for(Book b:books){
            //try { Thread.sleep(1); } catch (InterruptedException e) {}
            tmp=b.search(word);
            if(tmp!=null)
                results.add(tmp);
        }

        System.out.println(  "_"+ (System.currentTimeMillis() - time));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
