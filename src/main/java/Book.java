import java.util.*;
import java.util.concurrent.*;

public class Book {

    public int getId() {
        return data.id;
    }

    public String getLine(int lineNumber) {
        return data.data[lineNumber];
    }

    /*
            fields were extracted for smooth json parsing
         */
    public class Data {

        private int id;
        private String filename;
        private String[] data;
        private String folder;

        public Data(String filename, String[] lines, String folder) {
            this.filename = filename;
            this.data = lines;
            this.folder = folder;
        }
    }


    private static int Global_id = 0;
    private Data data;
    private ExecutorService executor = Executors.newCachedThreadPool();


    public Book(String filename, String data, String folder) {
        this.data = new Data(filename,data.split("\n"), folder);
        this.data.id = Global_id;
        Global_id+=1;
    }


    /*
        Uses PSearchLines to get all positions of word in text and then contacts them into single
        Result object
     */
    public Result search(String word) {

        // Scattering lines of text to n jobs, needs to be redone

        int n = Runtime.getRuntime().availableProcessors();
        int len = getLines().length;
        int div = (int) ((float) len / (float) (n));

        ArrayList<PSearchLines> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int pos = 0;
            for (int j = 0; j < getLines().length && j < div * i; j++) {
                pos += getLines()[j].length();
            }

            workers.add(new PSearchLines(this, word, div * i, div * (i + 1), pos));
        }

        if (div * (n) < len) {
            workers.get(workers.size() - 1).setTo(len);
        }

        // ---


        ArrayList<Result.row> positions = new ArrayList<Result.row>();
        List<Future<ArrayList<Result.row>>> list = new ArrayList<Future<ArrayList<Result.row>>>();


        // Parallel begin
        for (int i = 0; i < n; i++) {
            list.add(executor.submit(workers.get(i)));
        }

        for (Future<ArrayList<Result.row>> fut : list)
            try { positions.addAll(fut.get()); }
            catch (InterruptedException | ExecutionException e) {System.err.println(e);}
        // Parallel end

        return new Result(data.id, data.filename, data.folder,positions);
    }


    public String[] getLines() {
        return data.data;
    }
    public Data getData() {
        return this.data;
    }

}


