import java.util.HashMap;

public class MatchManager {

    private static MatchManager _instance;              // MatchManager 클래스를 싱글톤으로 생성하기 위해, 정적 멤버로 객체를 저장할 변수 생성

    static {
        _instance = new MatchManager(100);      // MatchManager 객체를 생성하고 초기화 한 후 _instance 멤버 변수에 객체의 주소 값을 저장한다.
    }

    public static MatchManager getInstance()            // 외부에서  MatchManager 객체를 받아오기 위한 메서드
    {
        return _instance;
    }

    private int _cashPrize;                      // 판돈
    private boolean _gameOver;                  // 게임 진행 여부
    private MatchFactory _matchFactory;         // 전략을 처리하는 객체
    private boolean _tie;                       // 전판의 무승부 여부  --> 무승부 시 판돈이 2배가 되고 장땡이 광땡보다 더 높은 (점수)우선순위를 갖는 전략을 사용하게 된다.
    private HashMap scores;                      // 족보와 족보에 따른 점수(우선순위)가 담겨 있는 해시 테이블
    private Jocbo firstPae, secondPae;         // 플레이어의 족보
    private Player _winner;                      // 승자
    private Player _looser;                      // 패자


    private MatchManager(int cashPrize){
        _cashPrize = cashPrize;
        _gameOver = false;
        _tie = false;
        _winner = null;
        _looser = null;
        _matchFactory = MatchFactory.getInstance();     //싱글톤, 팩토리, 전략 패턴을 구현한 객체의 인스턴스를 받아온다.
    }                                                     //이 객체는 Matchable이라는 전략을 멤버 필드로 가지고 있다.


    public boolean isTie(){                             //무승부에 대한 정보를 반환/설정
        return _tie;
    }
    public void setTie(boolean tie){
        _tie = tie;
    }


    public int getCashPrize(){                          // 판돈에 대한 정보를 반환/설정
        return _cashPrize;
    }
    public void setDoubleCashPrize(){                  // 판돈을 기존 판돈의 두 배로 설정함 (전판이 무승부 시)
        _cashPrize *= 2;
    }
    public void resetCashPrize(int cashPrize){
        _cashPrize = cashPrize;
    }


    public Player getWinner(){                          // 승자 반환
       return _winner;
    }
    public Player getLooser(){                          // 패자 반환
        return _looser;
    }
    public boolean isGameOver(){                       // 게임 진행 여부 반환/설정
        return _gameOver;
    }
    public void setGameOver(boolean gameOver){
        if (_gameOver != gameOver)
            _gameOver = gameOver;
    }

    public boolean isAffordable(Player firstPlayer, Player secondPlayer){                       // 플레이어가 여유 돈이 있는지 판단한다 -> 게임 진행 여부를 결정함
        if(firstPlayer.getMoney() >= _cashPrize && secondPlayer.getMoney() >= _cashPrize)     // 두 플레이어 모두 판돈과 같거나 더 많은 돈을 가지고 있을 경우 참 아닐 경우 거짓을 반환
            return true;
        else
            return false;
    }


    public void determineWinner(Player firstPlayer, Player secondPlayer){                       // 승자를 가리는 메서드
        if(_tie){                                                                                // 전 판의 무승부 여부를 판단하여 서로 다른 전략을 사용함
            _matchFactory.setMatchInfo(new JangMatchInfo());                                   // 무승부일 경우 장땡 전략 사용, 승패가 결정 난 경우 광땡 전략 사용
        }else{
            _matchFactory.setMatchInfo(new GwangMatchInfo());
        }

        scores = _matchFactory.getMatchInfo();                                                 // 전략에 따라 달라진 족보/점수 해시 테이블을 가져온다.
        firstPae = getPlayerPae(firstPlayer);                                                    // 첫 번째 플레이어의 족보를 저장
        secondPae = getPlayerPae(secondPlayer);                                                 // 두 번째 플레이어의 족보를 저장

        int firstScore = (int)scores.get(firstPae);                                            // 플레이어의 족보를 키(key)로 사용하여 그에 해당하는 점수(score)를 해시 테이블에서 가져온다.
        int secondScore = (int)scores.get(secondPae);

        if(firstScore > secondScore) {                                                          // 각 플레이어의 점수를 가지고 승/무/패를 결정한다.
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

    public Jocbo getPlayerPae(Player player){                                               // 플레이어가 가진 카드를 2장을 확인하여 족보를 알아낸다.

        if(player.getCard1().getGwang() && player.getCard2().getGwang()) {                  // 두 장 모두 광이면 광땡
            // 광땡
            int sum = player.getCard1().getNum() + player.getCard2().getNum();
            switch (sum){
                case 4: return Jocbo.일삼광땡;
                case 9: return Jocbo.일팔광땡;
                case 11: return Jocbo.삼팔광땡;
            }

        } else if(player.getCard1().getNum() == player.getCard2().getNum()) {           // 두 장의 숫자가 같으면 땡
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
        } else {                                                                            // 나머지는 끗
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
