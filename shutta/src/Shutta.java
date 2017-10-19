public class Shutta {

    public static void run() {
        Player player1 = new Player();
        Player player2 = new Player();
        Dealer dealer = Dealer.getDealer();
        MatchManager matchManager = MatchManager.getInstance();
        System.out.println("Welcome!");
        while (player1.getMoney() > 0 && player2.getMoney() > 0) {

            System.out.println("-----------------------------------------");
            System.out.println(player1.getRecord().getTotalCount() + 1 + "번째 게임");
            System.out.println("돈 배팅");
            dealer.getMoney(player1, player2, 100);
            System.out.println("1p : " + player1.getMoney() + "  2p : " + player2.getMoney());
            System.out.println("판돈 : " + dealer.getBattedMoney());

            System.out.println("패를 나눠줌");
            dealer.giveCard(player1, player2);
            System.out.print("패1 : " + player1.getCard1().getNum() + "   " + player1.getCard1().getGwang());
            System.out.println("   패2 : " + player1.getCard2().getNum() + "   " + player1.getCard2().getGwang());
            System.out.print("패1 : " + player2.getCard1().getNum() + "   " + player2.getCard1().getGwang());
            System.out.println("   패2 : " + player2.getCard2().getNum() + "   " + player2.getCard2().getGwang());

            System.out.println("패확인 ");
            System.out.println(matchManager.getPlayerPae(player1));
            System.out.println(matchManager.getPlayerPae(player2));

            System.out.println("1p 승리"); //2
            player1.getRecord().addWinCount();
            player2.getRecord().addLoseCount();

            System.out.println("돈 지급");
            dealer.giveMoney(player1);
            System.out.println("1p : " + player1.getMoney() + "  2p : " + player2.getMoney());

            System.out.println("다음 게임 여부 확인"); //3
            System.out.println("-----------------------------------------\n\n");

        }
        Rank.decisionRank(player1, player2);
        System.out.println("bye");

    }
}
