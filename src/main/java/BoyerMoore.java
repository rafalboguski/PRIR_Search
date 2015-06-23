/**
 * Created by monum_000 on 2015-06-01.
 */
import java.util.*;

public class BoyerMoore {



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





}
