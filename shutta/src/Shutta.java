import java.util.Scanner;

public class Shutta {

    public static void run() {
            Scanner s=new Scanner(System.in);
            System.out.println("Welcome!");
            System.out.print("플레이어1 이름 입력 : ");
            String name1=s.next();
            System.out.print("플레이어2 이름 입력 : ");
            String name2=s.next();

        Player player1 = new Player(name1);   // 플레이어 객체 생성
        Player player2 = new Player(name2);
        Dealer dealer = Dealer.getDealer();    // 딜러 객체 받아옴
        MatchManager matchManager = MatchManager.getInstance(); // 매치매니저 객체 받아옴
        int i = 0;
        while (!matchManager.isGameOver()) {


            System.out.println("-----------------------------------------");
            System.out.println(player1.getRecord().getTotalCount()  + 1 + "번째 게임");

            System.out.println("@돈 배팅");
            dealer.getMoney(player1, player2, 100); // 플레이어들로부터 판돈만큼 돈을 가져옴
            System.out.println(player1.getName()+" : " + player1.getMoney() +", "+ player2.getName()+" : " + player2.getMoney());
            System.out.println("*판돈* : " + matchManager.getCashPrize());
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

            matchManager.determineWinner(player1, player2);  // 승무패 결과를 계산하고 무승부일때 족보를 바꿔줌

            if(!matchManager.isTie()) {   // 무승부가 아니면
                System.out.println(matchManager.getWinner().getName()+" 승리");
                matchManager.getWinner().getRecord().addWinCount();
                matchManager.getLooser().getRecord().addLoseCount();
                System.out.println("\n@돈 지급");
                System.out.println(matchManager.getWinner().getName()+" + " + matchManager.getCashPrize());
                System.out.println(matchManager.getLooser().getName()+" - " + matchManager.getCashPrize());
                dealer.giveMoney(matchManager.getWinner());
                matchManager.resetCashPrize(100);

            }else {
                System.out.println("무승부");
                player1.getRecord().addDrawCount();
                player2.getRecord().addDrawCount();
                dealer.payBackMoney(player1,player2);   // 배팅했던 돈을 돌려주고
                matchManager.setDoubleCashPrize();     // 다음판 판돈을 두배로 올림
            }

            System.out.println("\n*잔액*");
            System.out.println(player1.getName()+" : " + player1.getMoney());
            System.out.println(player2.getName()+" : " + player2.getMoney());
            System.out.println("*판돈* : " + matchManager.getCashPrize());
            if(matchManager.isAffordable(player1,player2)) {    // 다음판 진행이 가능한지 여부를 확인 (가진돈이 0원이거나 판돈보다 적을때)
                matchManager.setGameOver(false);
            }
            else {
                matchManager.setGameOver(true);
            }
            System.out.println("-----------------------------------------\n\n");

        }
        Rank.decisionRank(player1, player2);   // 게임 종료후 플레이어들의 전적 정보 출력 후 종료
        System.out.println("\nbye");

    }
}
