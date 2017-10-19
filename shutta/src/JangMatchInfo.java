import java.util.HashMap;

public class JangMatchInfo implements Matchable {


    private  Jocbo[] jocbo;
    private HashMap<Jocbo,Integer> scores;

    public JangMatchInfo(){
        jocbo = Jocbo.values();
        scores = new HashMap<>();
    }
    @Override
    public HashMap createMatchInfo() {
        int i = jocbo.length;
        for (Jocbo jocbo : Jocbo.values()) {
            scores.put(jocbo, i--);
        }

        int temp = scores.get(Jocbo.삼팔광땡);
        scores.put(Jocbo.삼팔광땡, scores.get(Jocbo.일팔광땡));
        scores.put(Jocbo.일팔광땡, scores.get(Jocbo.일삼광땡));
        scores.put(Jocbo.일삼광땡, scores.get(Jocbo.장땡));
        scores.put(Jocbo.장땡, temp);

        return scores;
    }
}
