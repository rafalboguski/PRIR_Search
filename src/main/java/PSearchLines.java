import java.util.*;
import java.util.concurrent.Callable;


public class PSearchLines implements Callable<ArrayList<Result.row>> {

    private Book book = null;
    private String word = null;
    /*
        from and to are variables that restrict range of book in which this particular search is done
        pos is position of found match from beginning of whole text
     */
    private int from;
    private int to;
    private int pos;


    public PSearchLines(Book book, String word, int from, int to, int pos) {
        this.book = book;
        this.word = word;
        this.from = from;
        this.to = to;
        this.pos = pos;
    }


    /*
        Returns Array of matches (Result.row)
     */
    @Override
    public ArrayList<Result.row> call() {

        ArrayList<Result.row> buf = new ArrayList<>();
        for (int i = from; i < to; i++) {

            ArrayList<Result.row> tmp = match(word, book.getLines()[i], i);

            for (Result.row match : tmp)
                match.pos -= pos;

            buf.addAll(tmp);

            pos += book.getLines()[i].length() + 2;
        }

        return buf;
    }


    /*
        Boyer–Moore string search algorithm
     */

    private ArrayList<Result.row> match(String pattern, String text, int lineAt) {

        ArrayList<Result.row> matches = new ArrayList<>();
        int texLen = text.length();
        int patLen = pattern.length();
        Map<Character, Integer> rightMostIndexes = preprocessForBadCharacterShift(pattern);
        int alignedAt = 0;
        while (alignedAt + (patLen - 1) < texLen) {
            for (int indexInPattern = patLen - 1; indexInPattern >= 0; indexInPattern--) {
                int indexInText = alignedAt + indexInPattern;
                char x = text.charAt(indexInText);
                char y = pattern.charAt(indexInPattern);
                if (indexInText >= texLen)
                    break;
                if (x != y) {
                    Integer r = rightMostIndexes.get(x);
                    if (r == null) {
                        alignedAt = indexInText + 1;
                    } else {
                        int shift = indexInText - (alignedAt + r);
                        alignedAt += shift > 0 ? shift : alignedAt + 1;
                    }
                    break;

                } else if (indexInPattern == 0) {
                    Result.row buf = new Result.row(lineAt + 1, alignedAt);
                    matches.add(buf);
                    alignedAt++;
                }

            }
        }
        return matches;
    }

    private static Map<Character, Integer> preprocessForBadCharacterShift(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
        }
        return map;
    }


    public void setTo(int to) {
        this.to = to;
    }


}
