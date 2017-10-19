public class Record {
    private int _totalCount;
    private int _winCount;
    private int _drawCount;
    private int _loseCount;
    private double _PoV;

    public Record(){
        _winCount =0;
        _loseCount =0;
        _drawCount =0;
        _totalCount=0;
    }

    //region
    public double getPoV(   ){
        _PoV=(_winCount/_totalCount)*100;
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

    public void addWinCount(){
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
