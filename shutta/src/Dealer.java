import java.util.ArrayList;
import java.util.List;

class Dealer {   // 판돈 관리, 카드 나눠주는 딜러 클래스
    private static Dealer dealer = new Dealer();  // 싱글톤
    private List<Card> cards = new ArrayList<>();  // 20장 카드를 갖고 있는 어레이리스트
    private int _bettedMoney;  // 판돈

    //region
    public int getBattedMoney() {
        return _bettedMoney;
    }

    public void setBattedMoney(int battedMoney) {
        if (_bettedMoney != battedMoney)
            _bettedMoney = battedMoney;
    }
    //endregion

    //region
    public List<Card> getCards() {
        return cards;
    }

    //endregion
    private Dealer() {      // 생성자  -  객체가 생성될 때 어레이리스트에 카드 20장을 입력함
        for (int i = 1; i <= 10; i++) {   // 1월부터 10월까지 2장씩

            cards.add(new Card(i, false));
            cards.add(new Card(i, false));
        }
        cards.get(0).setGwang(true);   // 1,3,8월 각 한장씩 광
        cards.get(4).setGwang(true);
        cards.get(14).setGwang(true);

        //_bettedMoney=0;
    }

    static Dealer getDealer() {
        return dealer;
    }

    private void shuffleCards(int[] randomNum) {    // 중복되지않은 랜덤 숫자 4개를 뽑는 메소드
        // randomNum[0] = (int) (Math.random() * 20 );
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int) (Math.random() * 20);    //0~19까지 랜덤한 숫자
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {        // 중복 숫자가 있으면 다시 뽑기
                    i--;
                    break;
                }
            }
        }
    }

    void giveCard(Player p1, Player p2) {    // 카드를 나눠주는 메소드
        int[] randomNum = new int[4];            //4가지 랜덤 숫자를 받음
        shuffleCards(randomNum);

        p1.setCard1(cards.get(randomNum[0]));   //플레이어 1 부터 차례대로 카드를 나눠줌
        p1.setCard2(cards.get(randomNum[1]));
        p2.setCard1(cards.get(randomNum[2]));
        p2.setCard2(cards.get(randomNum[3]));

    }
    void payBackMoney(Player p1,Player p2){    // 무승부일때 배팅한 판돈을 플레이어들에게 돌려주는 메소드
        p1.setMoney(p1.getMoney()+_bettedMoney/2);
        p2.setMoney(p2.getMoney()+_bettedMoney/2);
    }
    void getMoney(Player p1, Player p2, int bettingMoney) {   // 게임 시작시 플레이어들로부터 판돈만큼 받아오는 메소드
        p1.setMoney(p1.getMoney() - bettingMoney);
        p2.setMoney(p2.getMoney() - bettingMoney);
        _bettedMoney = bettingMoney * 2;
    }

    void giveMoney(Player winner) {   // 이긴 사람에게 모아놓은 판돈을 지급하는 메소드
        winner.setMoney(winner.getMoney() + _bettedMoney);
        _bettedMoney = 0;
    }

}
