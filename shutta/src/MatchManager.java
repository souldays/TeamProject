import java.util.HashMap;

public class MatchManager {

    private static MatchManager _instance;

    private int _cashPrize;
    private boolean _gameOver;
    private int _playCount;
    private MatchFactory _matchFactory;
    private boolean _tie;
    private HashMap scores;
    private Jocbo firstPae, secondPae;


    public boolean getGameOver(){
        return _gameOver;
    }
    public void setGameOver(boolean gameOver){
        if (_gameOver != gameOver)
            _gameOver = gameOver;
    }

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
        firstPae = getPlayerPae(firstPlayer);
        secondPae = getPlayerPae(secondPlayer);
        
    }
    public Jocbo getPlayerPae(Player player){

        if(player.getCard1().getGwang() && player.getCard2().getGwang()) {
            // 광땡
            int sum = player.getCard1().getNum() + player.getCard2().getNum();
            switch (sum){
                case 4: return Jocbo.일삼광땡;
                case 9: return Jocbo.일팔광땡;
                case 11: return Jocbo.삼팔광땡;
            }

        } else if(player.getCard1().getNum() == player.getCard2().getNum()) {
            // 땡
            int sum = player.getCard1().getNum() + player.getCard2().getNum();
            switch (sum){
                case 2: return Jocbo.일땡;
                case 4: return Jocbo.이땡;
                case 6: return Jocbo.삼땡;
                case 8: return Jocbo.사땡;
                case 10: return Jocbo.오땡;
                case 12: return Jocbo.육땡;
                case 14: return Jocbo.칠땡;
                case 16: return Jocbo.팔땡;
                case 18: return Jocbo.구땡;
            }
        } else {
            // 끗
            int sum = (player.getCard1().getNum() + player.getCard2().getNum())%10;
            switch (sum){
                case 1: return Jocbo.일끗;
                case 2: return Jocbo.이끗;
                case 3: return Jocbo.삼끗;
                case 4: return Jocbo.사끗;
                case 5: return Jocbo.오끗;
                case 6: return Jocbo.육끗;
                case 7: return Jocbo.칠끗;
                case 8: return Jocbo.팔끗;
                case 9: return Jocbo.구끗;
                case 0: return Jocbo.망통;
            }
        }
        return  Jocbo.망통;
    }

}
