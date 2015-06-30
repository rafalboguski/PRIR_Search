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
        Result x = new Result(id.getTime(), this.filename, this.folder);
        boolean init = false;
        int pos = 0;
        for (int i = 0; i < lines.length; i++) {
            BoyerMoore buf1 = new BoyerMoore(word, lines[i], i);
            ArrayList<Result.row> buf = buf1.getMatches();
            for (Result.row match : buf){
                match.pos+=pos;
            }
            x.addPosition(buf);

            // \n kodowany jako 2 znaki w windowsie
            // linuks jako 1 znak
            pos+=lines[i].length()+2;
        }

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
