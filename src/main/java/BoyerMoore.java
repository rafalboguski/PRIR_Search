/**
 * Created by monum_000 on 2015-06-01.
 */
import java.util.*;

public class BoyerMoore {

    private ArrayList<Result.row> matches;
    public BoyerMoore(String pattern, String text, int lineAt){
        this.matches = match(pattern,text,lineAt);
    }

    public ArrayList<Result.row> match(String pattern, String text, int lineAt) {
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
                    Result.row buf = new Result.row(lineAt+1, alignedAt);
                    matches.add(buf);
                    alignedAt++;
                }

            }
        }

        return matches;
    }
    private static Map<Character, Integer> preprocessForBadCharacterShift(String pattern){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = pattern.length() - 1; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
        }
        return map;
    }


    public static void main(String[] args) {
      /*  List<Integer> matches = BoyerMoore.match("Ala ", "Ala ma kota, kot ma Ala");
        List<Integer> matches2 = BoyerMoore.match(" Ala ", "Ala ma kota, kot ma Ala");
        List<Integer> matches3 = BoyerMoore.match(" Ala", "Ala ma kota, kot ma Ala");
        System.out.println(matches.toString());
        System.out.println(matches2.toString());
        System.out.println(matches3.toString());
        matches.addAll(BoyerMoore.match(" Ala", "Ala ma kota, kot ma Ala"));
        System.out.println(matches.toString());
        for (Integer integer : matches) System.out.println("Match at: " + integer);
        //System.out.println((matches.equals(Arrays.asList(1, 3)) ? "OK" : "Failed")); */
    }

    public ArrayList<Result.row> getMatches() {
        return matches;
    }


}
