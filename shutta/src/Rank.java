public class Rank {
    static public void decisionRank(Player p1, Player p2){

        System.out.println( p1.getName()+" : "+p1.getMoney());
        System.out.println(p1.getName()+" 승률 : "+(p1.getRecord().getPoV())+"%");
        System.out.println(p1.getRecord().getWinCount()+"번 승리");
        System.out.println(p1.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p1.getRecord().getLoseCount()+"번 패배");
        System.out.println();

        System.out.println(p2.getName()+" : "+p2.getMoney());
        System.out.println(p2.getName()+" 승률 : "+(p2.getRecord().getPoV())+"%");
        System.out.println(p2.getRecord().getWinCount()+"번 승리");
        System.out.println(p2.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p2.getRecord().getLoseCount()+"번 패배");
    }
}
