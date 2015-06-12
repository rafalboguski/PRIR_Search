import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
public class Book {

    private String filename;
    private String[] lines;
    private String folder;

    public Book(String filename, String data, String folder) {
        this.filename = filename;
        this.lines = data.split(System.getProperty("line.separator"));
        this.folder = folder;
    }




    public Result search(String word) {

        // To jest moje proste szukanie
        // Zrob tutaj jakis szybki algorytm to szukanie wzorcu (word) w tekscie (data albo lines)
        Date id = new Date();
       Result x = new Result(id.getTime(),this.filename,this.folder);
       boolean init = false;
       for (int i = 0; i < lines.length; i++) {
           ArrayList<Result.row> buf =  BoyerMoore.match(word,lines[i],i);
           x.addPosition(buf);
       }



        //////////////////////////////////////////////////////////
        //  to jest do testowania zrownoleglenia
        //  wykonuje sie prawie w takim samym czsie dla kazej ksiazki
        //  jak bedziesz robil szukanie to zakomentuj
        /*Random r = new Random();
        int x =0;
        for( int i =0;i<1000;i++){
            x+=r.nextInt();
        }
        return new Result(Integer.parseInt(filename),String.valueOf(x),"sdf");
        ////////////////////////////////////////////////////////// */
        return x;
    }




    public String[] getData() {
        return lines;
    }

    public String getFolder() {
        return folder;
    }

    public String getFilename() {
        return filename;
    }

}
