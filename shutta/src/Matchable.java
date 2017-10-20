import java.util.HashMap;

public interface Matchable {            //전략을 구성하는 인터페이스
    public HashMap createMatchInfo();    //전략에 따라 달리 구현되는 메서드
}
