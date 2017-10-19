import java.util.HashMap;

public class MatchFactory {

    private static MatchFactory _instance;
    private Matchable _matchInfo;

    static {
        _instance = new MatchFactory();
    }

    private MatchFactory(){ }

    public static MatchFactory getInstance() {
        return _instance;
    }

    public void setMatchInfo(Matchable matchInfo){
        _matchInfo = matchInfo;
    }

    public HashMap getMatchInfo(){
        return _matchInfo.createMatchInfo();
    }

}
