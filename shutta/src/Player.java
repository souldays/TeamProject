 class Player {
     private int _money;
     private Card _card1;
     private Card _card2;
     private Record _record;

     Player(){
         _money=1000;
         _record=new Record();
     }

     //region
     public Record getRecord(){
         return _record;
     }
     public void setRecord(Record record){
         if (_record != record)
             _record = record;
     }
     //endregion

    //region
    public int getMoney(){
        return _money;
    }
    public void setMoney(int money){
        if (_money != money)
            _money = money;
    }
    //endregion

     //region
     public Card getCard1(){
         return _card1;
     }
     public void setCard1(Card card1){
         if (_card1 != card1)
             _card1 = card1;
     }
     //endregion

     //region
     public Card getCard2(){
         return _card2;
     }
     public void setCard2(Card card2){
         if (_card2 != card2)
             _card2 = card2;
     }
     //endregion


}
