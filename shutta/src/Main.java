//
public class Main {
    public static void main(String[] args) {
        Dealer d1 = Dealer.getDealer();


        for (int i = 0; i < 20; i++) {
            System.out.print(d1.getCards().get(i).getNum());
            System.out.println("    " + d1.getCards().get(i).getGwang());
        }

        Player p1 = new Player();
        Player p2 = new Player();
        d1.giveCard(p1,p2);

        System.out.println("\n"+p1.getCard1()+"  "+p1.getCard1().getNum()+"    "+p1.getCard1().getGwang());
        System.out.println(p1.getCard2()+"  "+p1.getCard2().getNum()+"    "+p1.getCard2().getGwang());
        System.out.println(p2.getCard1()+"  "+p2.getCard1().getNum()+"    "+p1.getCard1().getGwang());
        System.out.println(p2.getCard2()+"  "+p2.getCard2().getNum()+"    "+p1.getCard2().getGwang());

//        d1.getMoney(p1,p2,100);
//        System.out.println(p1.getMoney()+"   "+p2.getMoney());
//        d1.giveMoney(p1);
//        System.out.println(p1.getMoney());
//        p1.getRecord().addWinCount();
//        p2.getRecord().addLoseCount();
//        d1.getMoney(p1,p2,100);
//        System.out.println(p1.getMoney()+"   "+p2.getMoney());
//        d1.giveMoney(p1);
//        System.out.println(p1.getMoney());
//        p1.getRecord().addWinCount();
//        p2.getRecord().addLoseCount();
//        System.out.println(d1.getBattedMoney());
////        System.out.println(p1.getRecord().getDrawCount());
//
//        Rank rank=new Rank();
//        rank.decisionRank(p1,p2);
    }
}

