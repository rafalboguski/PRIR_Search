/**
 * Created by user on 2015-05-05.
 */
public class Book {

    private String filename;
    private String data;
    private String folder;

    public Book(String filename, String data, String folder) {
        this.filename = filename;
        this.data = data;
        this.folder = folder;
    }

    public String getData() {
        return data;
    }

    public String getFolder() {
        return folder;
    }

    public String getFilename() {
        return filename;
    }
}
