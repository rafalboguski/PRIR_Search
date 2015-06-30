import java.util.*;
import java.util.concurrent.*;

public class Book {


    public class Data{

        private String filename;
        private String[] data;
        private String folder;

        public Data(String filename, String[] lines, String folder) {
            this.filename = filename;
            this.data = lines;
            this.folder = folder;
        }
    }

    public Data getData(){
        return this.data;
    }

    private Data data;


        ExecutorService executor = Executors.newCachedThreadPool();


        public Book(String filename, String data, String folder) {
            this.data = new Data(filename,data.split(System.getProperty("line.separator")),folder);
        }


        public Result search(String word) {


            ArrayList<Result.row> positions = new ArrayList<Result.row>();
            List<Future<ArrayList<Result.row>>> list = new ArrayList<Future<ArrayList<Result.row>>>();

            int n = Runtime.getRuntime().availableProcessors();

            int len = getLines().length;

            int div = (int)((float)len/(float)(n));


            ArrayList<BoyerMoore> workers = new ArrayList<>();
            for(int i =0;i<n;i++){

                int pos =0;
                for(int j=0;j< getLines().length && j<div*i;j++){
                    pos+= getLines()[j].length();
                }
                //System.out.println(pos);

                //System.out.println(div*i);
                workers.add(new BoyerMoore(this, word,div*i,div*(i+1),pos));
            }

            if(div*(n)<len){
                workers.get(workers.size()-1).setTo(len);
            }



            for(int i=0; i< n; i++){
                list.add( executor.submit(workers.get(i)));
                //pos += lines[i].length() + 2; // \n kodowany jako 2 znaki
            }

            for(Future<ArrayList<Result.row>> fut : list)
                try { positions.addAll(fut.get()); }  catch (InterruptedException | ExecutionException e) {}


            Result x = new Result(34, data.filename, data.folder);
            x.positions = positions;

            //System.out.println("-- "+positions);


            return x;
        }




        public String getFolder() {
            return data.folder;
        }
    public String [] getLines() {
        return data.data;
    }

        public String getFilename() {
            return data.filename;
        }

    }


