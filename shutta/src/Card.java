 class Card {   // 카드 한장의 정보를 담은 클래스
     private int _num;   // 카드의 월
     private boolean _gwang; // 광 여부

    Card(int num,boolean gwang){  //생성자
        _num=num;
        _gwang=gwang;
    }

    //region

    public int getNum(){
        return _num;
    }
    public void setNum(int num){
        if (_num != num)
            _num = num;
    }
    //endregion

     //region
     public boolean getGwang(){
         return _gwang;
     }
     public void setGwang(boolean gwang){
         if (_gwang != gwang)
             _gwang = gwang;
     }
     //endregion

}
