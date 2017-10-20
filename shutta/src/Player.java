 class Player {
     private int _money;
     private Card _card1;
     private Card _card2;
     private Record _record;  //전적 정보를 담고있는데 레코드 객체
     private String _name;

     Player(String name){   //생성자    이름을 받아서 객체를 생성하면 돈 1000원 레코드, 받아온 이름으로 초기화됨
         _money=1000;
         _record = new Record();
         _name=name;
     }
    //region

    public String getName(){
        return _name;
    }
    public void setName(String name){
        if (_name != name)
            _name = name;
    }
    //endregion
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
