
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

        //try { Thread.sleep(1); } catch (InterruptedException e) {}
        Result x = null;
        boolean init = false;
        for (int i = 0; i < lines.length; i++) {
            for (int j = -1; (j = lines[i].indexOf(word, j + 1)) != -1; ) {
//                if(!init) {
//                    x = new Result(0, filename, folder);
//                    init = true;
//                }
//                x.addPosition(i + 1, j);
            }
        }

        return null;
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
