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
                case 4: return Jocbo.IL_SAM_GWANG_DDANG;
                case 9: return Jocbo.IL_PAL_GWANG_DDANG;
                case 11: return Jocbo.SAM_PAL_GWANG_DDANG;
            }

        } else if(player.getCard1().getNum() == player.getCard2().getNum()) {
            // 땡
            int sum = player.getCard1().getNum() + player.getCard2().getNum();
            switch (sum){
                case 2: return Jocbo.IL_DDANG;
                case 4: return Jocbo.YEE_DDANG;
                case 6: return Jocbo.SAM_DDANG;
                case 8: return Jocbo.SA_DDANG;
                case 10: return Jocbo.OH_DDANG;
                case 12: return Jocbo.YOOK_DDANG;
                case 14: return Jocbo.CHIL_DDANG;
                case 16: return Jocbo.PAL_DDANG;
                case 18: return Jocbo.GOO_DDANG;
            }
        } else {
            // 끗
            int sum = (player.getCard1().getNum() + player.getCard2().getNum())%10;
            switch (sum){
                case 1: return Jocbo.IL_GGEUT;
                case 2: return Jocbo.YEE_GGEUT;
                case 3: return Jocbo.SAM_GGEUT;
                case 4: return Jocbo.SA_GGEUT;
                case 5: return Jocbo.OH_GGEUT;
                case 6: return Jocbo.YOOK_GGEUT;
                case 7: return Jocbo.CHIL_GGEUT;
                case 8: return Jocbo.PAL_GGEUT;
                case 9: return Jocbo.GOO_GGEUT;
                case 0: return Jocbo.MANGTONG;
            }
        }
        return  Jocbo.MANGTONG;
    }

}
