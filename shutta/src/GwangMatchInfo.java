import java.util.ArrayList;
import java.util.HashMap;

public class GwangMatchInfo implements Matchable {          // 기본 전략 클래스

    private  Jocbo[] jocbo;                                    // 삼팔광 땡부터 망통(0끗) 순서대로 나열한 열거 타입으로부터 생성한 배열
    private HashMap<Jocbo,Integer> scores;

    public GwangMatchInfo() {
        jocbo = Jocbo.values();                             // 족보 열거 타입에서 각 요소들을 가져와 배열로 만든다.
        scores = new HashMap<>();                           // 족보(key) /  점수(value) 쌍으로 이루어진 해시 테이블을 생성한다.
    }

    @Override
    public HashMap<Jocbo, Integer> createMatchInfo() {      // 삼팔광 땡부터 망통(0끗)까지 내림 차순으로 점수를 부여함

        int i = jocbo.length;
        for (Jocbo jocbo : Jocbo.values()) {
            scores.put(jocbo, i--);
        }
        return scores;
    }

}
