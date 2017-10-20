import java.util.HashMap;

public class MatchFactory {                                                     // 싱글톤을 사용함

    private static MatchFactory _instance;
    private Matchable _matchInfo;                                               // Matchable 인터페이스를 구현한 클래스의 객체를 담을 멤버 필드
                                                                                   // 족보/점수와 관련된 전략 패턴
    static {
        _instance = new MatchFactory();
    }

    private MatchFactory(){ }

    public static MatchFactory getInstance() {
        return _instance;
    }

    public void setMatchInfo(Matchable matchInfo){
        _matchInfo = matchInfo;
    }   // 전략 클래스(광땡 혹은 장땡 클래스)를 멤버 필드에 설정

    public HashMap getMatchInfo(){
        return _matchInfo.createMatchInfo();
    }                                                                               // Matchable 인터페이스의 메서드를 오버라이딩한 메서드를 실행해줌
                                                                                     // 그 결과로 족보/점수 해시 테이블을 반환함
}
