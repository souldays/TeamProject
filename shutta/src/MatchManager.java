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
    private Player _winner;
    private Player _looser;

    public void setTie(boolean tie){
        _tie = tie;
    }
    public int getCashPrize(){
        return _cashPrize;
    }
    public Player getWinner(){
       return _winner;
    }
    public Player getLooser(){
        return _looser;
    }
    public boolean isGameOver(){
        return _gameOver;
    }
    public void setGameOver(boolean gameOver){
        if (_gameOver != gameOver)
            _gameOver = gameOver;
    }

    public boolean isTie(){
        return _tie;
    }

    private MatchManager(int cashPrize){
        _cashPrize = cashPrize;
        _gameOver = false;
        _tie = false;
        _playCount = 0;
         _winner = null;
         _looser = null;
        _matchFactory = MatchFactory.getInstance();
    }

    static {
        _instance = new MatchManager(100);
    }

    public static MatchManager getInstance()
    {
        return _instance;
    }

    public boolean isAffordable(Player firstPlayer, Player secondPlayer){
        if(firstPlayer.getMoney() >= _cashPrize && secondPlayer.getMoney() >= _cashPrize)
            return true;
        else
            return false;
    }

    public void setDoubleCashPrize(){
           _cashPrize *= 2;
           _winner = null;
            _looser = null;
    }

    public void resetCashPrize(int cashPrize){
        _cashPrize = cashPrize;
        _winner = null;
        _looser = null;
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

        int firstScore = (int)scores.get(firstPae);
        int secondScore = (int)scores.get(secondPae);

        if(firstScore > secondScore) {
            _winner = firstPlayer;
            _looser = secondPlayer;
            _tie= false;
        }else if(secondScore > firstScore) {
            _winner = secondPlayer;
            _looser = firstPlayer;
            _tie = false;
        }else {
            _winner = null;
            _looser = null;
            _tie = true;
        }
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
                case 20: return Jocbo.장땡;
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
