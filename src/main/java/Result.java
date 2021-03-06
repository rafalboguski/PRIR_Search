import java.util.ArrayList;

public class Result {

    public static class row {

        int line;
        int pos;

        public row(int line, int pos) {
            this.pos = pos;
            this.line = line;
        }

        @Override
        public String toString() {
            return "\n\t\trow{" +
                    "line=" + line +
                    ", pos=" + pos +
                    "}";
        }
    }

    public long id;
    public String filename;
    public String folder;

    public ArrayList<row> positions = new ArrayList<>();

    public Result(long id, String filename, String folder) {
        this.id = id;
        this.filename = filename;
        this.folder = folder;
    }

    public Result(long id, String filename, String folder, ArrayList<row> positions) {
        this.id = id;
        this.filename = filename;
        this.folder = folder;
        this.positions = positions;
    }


    @Override
    public String toString() {
        return "Result{" +
                "\n  id=" + id +
                "\n  filename='" + filename + '\'' +
                "\n  folder='" + folder + '\'' +
                "\n  positions=" + positions +
                "\n}";
    }
}
