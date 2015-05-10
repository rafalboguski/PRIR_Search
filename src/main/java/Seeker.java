import java.util.ArrayList;


public class Seeker extends Thread {

    private ArrayList<Book> books= new ArrayList<>();
    private ArrayList<Result> results;

    private int from =0;
    private int to =0;

    private String word;

    public Seeker(ArrayList<Book> books, int from, int to, String word, ArrayList<Result> results) {
        this.books = books;
        this.from = from;
        this.to = to;
        this.word = word;
        this.results = results;
    }

    @Override
    public void run(){
        Result tmp;
        for(int i=from;i<to;i++){
            tmp =books.get(i).search(word);
            if(tmp!= null )
                results.add(tmp);
        }
    }


}
