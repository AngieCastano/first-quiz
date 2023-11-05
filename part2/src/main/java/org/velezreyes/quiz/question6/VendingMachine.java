package org.velezreyes.quiz.question6;

public class VendingMachine{
  
    public int Quarter = 0;
  
 

  public void insertQuarter(){
      Quarter++;
  }

  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException{
      Drink drink = null;
      if ("ScottCola".equals(name) ){
          if(Quarter >= 3){
              drink = new Drink(name, true);
             Quarter = 0; 
          }
          else{
              throw new NotEnoughMoneyException();
          }
      }
      else if ("KarenTea".equals(name)){
          if(Quarter >= 4){
              drink = new Drink(name, false);
              Quarter = 0;
          }
          else{
              throw new NotEnoughMoneyException();
          }
      }
      else{
          throw new UnknownDrinkException();
      }
      return drink;
      
      
  }
}
