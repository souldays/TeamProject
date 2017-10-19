import java.util.ArrayList;
import java.util.List;

class Dealer {
    private static Dealer dealer = new Dealer();
    private List<Card> cards = new ArrayList<>();
    private int _bettedMoney;

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
    private Dealer() {
        for (int i = 1; i <= 10; i++) {

            cards.add(new Card(i, false));
            cards.add(new Card(i, false));
        }
        cards.get(0).setGwang(true);
        cards.get(4).setGwang(true);
        cards.get(14).setGwang(true);

        //_bettedMoney=0;
    }

    static Dealer getDealer() {
        return dealer;
    }

    private void shuffleCards(int[] randomNum) {
        // randomNum[0] = (int) (Math.random() * 20 );
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int) (Math.random() * 20);
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    void giveCard(Player p1, Player p2) {
        int[] randomNum = new int[4];
        shuffleCards(randomNum);

        p1.setCard1(cards.get(randomNum[0]));
        p1.setCard2(cards.get(randomNum[1]));
        p2.setCard1(cards.get(randomNum[2]));
        p2.setCard2(cards.get(randomNum[3]));

    }

    void getMoney(Player p1, Player p2, int bettingMoney) {
        p1.setMoney(p1.getMoney() - bettingMoney);
        p2.setMoney(p2.getMoney() - bettingMoney);
        _bettedMoney = bettingMoney * 2;
    }

    void giveMoney(Player winner) {
        winner.setMoney(winner.getMoney() + _bettedMoney);
        _bettedMoney = 0;
    }

}
