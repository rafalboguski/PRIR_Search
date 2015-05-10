
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

        Result x = new Result(0, filename, folder);
        int occurances = 0;
        for (int i = 0; i < lines.length; i++) {
            for (int j = -1; (j = lines[i].indexOf(word, j + 1)) != -1; ) {
                x.addPosition(i + 1, j);
                occurances++;
            }
        }
        return occurances > 0 ? x : null;
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
