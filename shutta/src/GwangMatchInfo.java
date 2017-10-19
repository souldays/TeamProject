import java.util.ArrayList;
import java.util.HashMap;

public class GwangMatchInfo implements Matchable {


    private  Jocbo[] jocbo;
    private HashMap<Jocbo,Integer> scores;

    public GwangMatchInfo() {
        jocbo = Jocbo.values();
        scores = new HashMap<>();
    }

    @Override
    public HashMap<Jocbo, Integer> createMatchInfo() {

        int i = jocbo.length;
        for (Jocbo jocbo : Jocbo.values()) {
            scores.put(jocbo, i--);
        }
        return scores;
    }

}
