import java.util.Scanner;

public class Shutta {

    public static void run() {
        Scanner s=new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("플레이어1 이름 입력 : ");
        String name1=s.next();
        System.out.print("플레이어2 이름 입력 : ");
        String name2=s.next();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        Dealer dealer = Dealer.getDealer();
        MatchManager matchManager = MatchManager.getInstance();

        while (!matchManager.isGameOver()) {

            System.out.println("-----------------------------------------");
            System.out.println(player1.getRecord().getTotalCount() + 1 + "번째 게임");

            System.out.println("@돈 배팅");
            dealer.getMoney(player1, player2, 100);
            System.out.println(player1.getName()+" : " + player1.getMoney() +" "+ player2.getName()+" : " + player2.getMoney());
            System.out.println("*판돈* : " + dealer.getBattedMoney());
            System.out.println();

            System.out.println("@패를 나눠줌");
            dealer.giveCard(player1, player2);
            System.out.print(player1.getName()+"의 " + "첫 번째 패 : " + player1.getCard1().getNum());
            if(player1.getCard1().getGwang())
                System.out.println("광");
            else
                System.out.println();
            System.out.print(player1.getName()+"의 " + "두 번째 패 : " + player1.getCard2().getNum());
            if(player1.getCard2().getGwang())
                System.out.println("광");
            else
                System.out.println();
            System.out.print(player2.getName()+"의 " + "첫 번째 패 : " + player2.getCard1().getNum());
            if(player2.getCard1().getGwang())
                System.out.println("광");
            else
                System.out.println();
            System.out.print(player2.getName()+"의 " + "두 번째 패 : " + player2.getCard2().getNum());
            if(player2.getCard2().getGwang())
                System.out.println("광");
            else
                System.out.println();

            System.out.println();

            System.out.println("@족보 확인 ");
            System.out.println( player1.getName()+"의 족보 : "+matchManager.getPlayerPae(player1));
            System.out.println(player2.getName()+"의 족보 : "+matchManager.getPlayerPae(player2));
            System.out.println();

            matchManager.determineWinner(player1, player2);
            if(!matchManager.isTie()) {
                System.out.println(matchManager.getWinner().getName()+" 승리"); //2
                matchManager.getWinner().getRecord().addWinCount();
                matchManager.getLooser().getRecord().addLoseCount();
                System.out.println("@돈 지급");
                System.out.println(matchManager.getWinner().getName()+" + " + matchManager.getCashPrize());
                System.out.println(matchManager.getLooser().getName()+" - " + matchManager.getCashPrize());
                dealer.giveMoney(matchManager.getWinner());
                matchManager.resetCashPrize(100);
            }else {
                System.out.println("무승부");
                player1.getRecord().addDrawCount();
                player2.getRecord().addDrawCount();
                matchManager.setDoubleCashPrize();
            }

            System.out.println("*잔액*");
            System.out.println(player1.getName()+" : " + player1.getMoney());
            System.out.println(player2.getName()+" : " + player2.getMoney());
            System.out.println("*판돈* : " + matchManager.getCashPrize());
            if(matchManager.isAffordable(player1,player2)) {
                matchManager.setGameOver(false);
            }
            else {
                matchManager.setGameOver(true);
            }
            System.out.println("-----------------------------------------\n\n");

        }
        Rank.decisionRank(player1, player2);
        System.out.println("bye");

    }
}
