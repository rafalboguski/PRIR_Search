/**
 * Created by monum_000 on 2015-06-01.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class BoyerMoore {


    public static void match(String pattern, String text, int lineAt, Result result) {
        List<Result.row> matches = new Vector<>();
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
                    result.addPosition(alignedAt, lineAt);
                    alignedAt++;
                }

            }
        }


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
}
