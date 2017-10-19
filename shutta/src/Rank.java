public class Rank {
    static public void decisionRank(Player p1, Player p2){

        System.out.println("player1 : "+p1.getMoney());
        System.out.println("player1 승률 : "+(p1.getRecord().getPoV())+"%");
        System.out.println(p1.getRecord().getWinCount()+"번 승리");
        System.out.println(p1.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p1.getRecord().getLoseCount()+"번 패배");

        System.out.println("player2 : "+p2.getMoney());
        System.out.println("player2 승률 : "+(p2.getRecord().getPoV())+"%");
        System.out.println(p2.getRecord().getWinCount()+"번 승리");
        System.out.println(p2.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p2.getRecord().getLoseCount()+"번 패배");
    }
}
