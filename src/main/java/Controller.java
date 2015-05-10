import java.util.ArrayList;

/*
    kontroler ma model w korym wykonujemy bezposrednie akcje jak doanie albo szukanie,
    sam nie powinien nimi operowaca ale obslugiwac watki, i przekazywac sterowanie
 */

public class Controller {

    Model library;


    // na potzreby testwoania szybkosci
    public int THREADS_NUM = 0;

    public Controller() {
        library = new Model();
    }

    public ArrayList<Book> getBooks() {
        return library.getBooks();
    }

    public void addBook(String filename, String data, String folder) {
        library.addBook(filename, data, folder);
    }

    public ArrayList<Result> search(String word) {

        ArrayList<Result> results = new ArrayList<>();
        //System.out.println("threads: "+THREADS_NUM);
        Seeker[] seekers = new Seeker[THREADS_NUM];
        int[] range = new int[THREADS_NUM];
        for (int i = 0; i < THREADS_NUM; i++)
            range[i] = 0;

        range = library.divideEqually(range, library.getNumberOfBooks());

        int tmp = 0;
        for (int i = 0; i < THREADS_NUM; i++) {
            seekers[i] = new Seeker(getBooks(), tmp, tmp += range[i], word, results);
        }

        for (int i = 0; i < THREADS_NUM; i++)
            seekers[i].start();

        try {

            for (int i = 0; i < THREADS_NUM; i++)
                seekers[i].join();

        } catch (InterruptedException e) {e.printStackTrace();}


        return results;
    }
}
