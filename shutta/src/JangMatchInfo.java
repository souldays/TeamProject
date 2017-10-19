import java.util.HashMap;

public class JangMatchInfo implements Matchable {


    public enum Jocbo {
        JANG_DDANG,
        SAM_PAL_GWANG_DDANG,
        IL_PAL_GWANG_DDANG,
        IL_SAM_GWANG_DDANG,
        GOO_DDANG,
        PAL_DDANG,
        CHIL_DDANG,
        YOOK_DDANG,
        OH_DDANG,
        SA_DDANG,
        SAM_DDANG,
        YEE_DDANG,
        IL_DDANG,
        GOO_GGEUT,
        PAL_GGEUT,
        CHIL_GGEUT,
        YOOK_GGEUT,
        OH_GGEUT,
        SA_GGEUT,
        SAM_GGEUT,
        YEE_GGEUT,
        IL_GGEUT,
        MANGTONG
    }

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
        return scores;
    }
}
