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

        int temp = scores.get(Jocbo.SAM_PAL_GWANG_DDANG);
        scores.put(Jocbo.SAM_PAL_GWANG_DDANG, scores.get(Jocbo.IL_PAL_GWANG_DDANG));
        scores.put(Jocbo.IL_PAL_GWANG_DDANG, scores.get(Jocbo.IL_SAM_GWANG_DDANG));
        scores.put(Jocbo.IL_SAM_GWANG_DDANG, scores.get(Jocbo.JANG_DDANG));
        scores.put(Jocbo.JANG_DDANG, temp);

        return scores;
    }
}
