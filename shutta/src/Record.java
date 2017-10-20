public class Record {   // 사용자의 전적 내용을 담는 클래스
    private int _totalCount;
    private int _winCount;
    private int _drawCount;
    private int _loseCount;
    private double _PoV;  // 승률

    public Record(){  // 생성자    객체 생성시 모든 값이 0으로 초기화됨
        _winCount =0;
        _loseCount =0;
        _drawCount =0;
        _totalCount=0;
    }

    //region
    public double getPoV(   ){
        _PoV= (double) _winCount/_totalCount * 100;
        return _PoV;
    }
    public void setPoV(double PoV){
        if (_PoV != PoV)
            _PoV = PoV;
    }
    //endregion

    //region
    public int getTotalCount(){
        return _totalCount;
    }
    public void setTotalCount(int totalCount){
        if (_totalCount != totalCount)
            _totalCount = totalCount;
    }
    //endregion

    //region
    public int getWinCount(){
        return _winCount;
    }
    public void setWinCount(int win){
        if (_winCount != win)
            _winCount = win;
    }
    //endregion
    //region
    public int getLoseCount(){
        return _loseCount;
    }
    public void setLoseCount(int lose){
        if (_loseCount != lose)
            _loseCount = lose;
    }
    //endregion
    //region
    public int getDrawCount(){
        return _drawCount;
    }
    public void setDrawCount(int draw){
        if (_drawCount != draw)
            _drawCount = draw;
    }
    //endregion

    public void addWinCount(){    // 승무패가 갈리고 해당 결과의 카운트를 올려주는 메소드
        _winCount++;
        _totalCount++;
    }
    public void addLoseCount(){
        _loseCount++;
        _totalCount++;

    }
    public void addDrawCount(){
        _drawCount++;
        _totalCount++;
    }

}
