 class Card {
     private int _num;
     private boolean _gwang;

    Card(int num,boolean gwang){
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
  