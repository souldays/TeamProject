import java.util.HashMap;

public class MatchManager {

    private static MatchManager _instance;

    private int _cashPrize;
    private boolean _gameOver;
    private int _playCount;
    private MatchFactory _matchFactory;
    private boolean _tie;
    private HashMap scores;



    private MatchManager(int cashPrize){
        _cashPrize = cashPrize;
        _gameOver = false;
        _tie = false;
        _playCount = 0;
        _matchFactory = MatchFactory.getInstance();
    }

    static {
        _instance = new MatchManager(100);
    }

    public static MatchManager getInstance()
    {
        return _instance;
    }

    public void setDoubleCashPrize(){
           _cashPrize *= 2;
    }

    public void resetCashPrize(int cashPrize){
        _cashPrize = cashPrize;
    }

    public void determineWinner(Player firstPlayer, Player secondPlayer){
        if(_tie){
            _matchFactory.setMatchInfo(new JangMatchInfo());
        }else{
            _matchFactory.setMatchInfo(new GwangMatchInfo());
        }

        scores = _matchFactory.getMatchInfo();
    }
  
}
