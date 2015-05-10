import java.util.ArrayList;


public class Model {

    private ArrayList<Book> books = new ArrayList<Book>();
    public int numberOfBooks =0;

    public Model(){
        addBook("reymont-chlopi-zima.txt", "testoilewe ala zapytanie ile ala ma kotow", "/home/data/example");
        addBook("Orwell-1984.txt", "idhbibchushbcuxcvxvcsgfhdfsc  gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbdsfdsfshbcxcvxvcusdvcxfhdfsc  gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbdsfdcxcvxcxcvxvcvxcfsc  gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbibcscxcvxcvxcfsc  gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbibxcvxcvxcvcxvcxcvxcvxcfsc  gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbixxcvxcvxcvcxvcxcvxcvxc gfsd vf", "/home/data/");
        addBook("Orwell-1984.txt", "idhbixxilecvxcvxcvcxvxcvshbcusgfhdfsc  gfsd vf", "/home/data/");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(String filename, String data, String folder) {
        books.add(new Book(filename, data, folder));
        numberOfBooks++;
    }


    public int getNumberOfBooks() {
        return numberOfBooks;
    }

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
}
