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

        Date id = new Date();
        BoyerMoore bayerMoore = new BoyerMoore();
        ArrayList<Result.row> buf;
        Result x = new Result(id.getTime(), this.filename, this.folder);
        int pos = 0;
        for (int i = 0; i < lines.length; i++) {
            buf = bayerMoore.match(word, lines[i], i);
            for (Result.row match : buf){
                match.pos+=pos;
            }
            x.addPosition(buf);
            pos+=lines[i].length()+2; // \n kodowany jako 2 znaki
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
