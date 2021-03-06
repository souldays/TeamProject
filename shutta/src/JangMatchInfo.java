import java.util.HashMap;

public class JangMatchInfo implements Matchable {           // 전 판이 무승부일 경우 사용하는 전략 클래스

    private  Jocbo[] jocbo;
    private HashMap<Jocbo,Integer> scores;

    public JangMatchInfo(){
        jocbo = Jocbo.values();
        scores = new HashMap<>();
    }
    @Override
    public HashMap createMatchInfo() {                       // 장땡에 가장 큰 점수를 부여하고 나머지는  기존 족보 순서대로 내림차순으로 높은 점수를 부여한다.
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
