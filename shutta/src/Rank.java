public class Rank {
    static public void decisionRank(Player p1, Player p2){
        // 전체 게임 종료 후 플레이어의 전적을 출력하는 클래스
        System.out.println( p1.getName()+" : "+p1.getMoney());
        System.out.printf("%s 승률 : %.2f ",p1.getName(),p1.getRecord().getPoV());
        System.out.println("% \n");
        System.out.println(p1.getRecord().getWinCount()+"번 승리");
        System.out.println(p1.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p1.getRecord().getLoseCount()+"번 패배");
        System.out.println();

        System.out.println(p2.getName()+" : "+p2.getMoney());
        System.out.printf("%s 승률 : %.2f ",p2.getName(),p2.getRecord().getPoV());
        System.out.println("% \n");
        System.out.println(p2.getRecord().getWinCount()+"번 승리");
        System.out.println(p2.getRecord().getDrawCount()+"번 무승부");
        System.out.println(p2.getRecord().getLoseCount()+"번 패배");
    }
}
