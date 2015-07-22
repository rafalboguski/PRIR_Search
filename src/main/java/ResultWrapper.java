import java.util.ArrayDeque;

/**
 * Created by Rafa³ Boguski on 2015-07-21.
 */
public class ResultWrapper {
    public ArrayDeque data;
    public long searchTime;

    public ResultWrapper(ArrayDeque data, long searchTime) {
        this.data = data;
        this.searchTime = searchTime;
    }
}
