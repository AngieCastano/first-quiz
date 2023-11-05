package org.velezreyes.quiz.question6;

public class Drink {
  String name;
  boolean fizzy;
  public Drink(String name, boolean fizzy) {
        this.name = name;
        this.fizzy = fizzy;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setFizzy(boolean fizzy) {
        this.fizzy = fizzy;
    }

    public String getName() {
        return this.name;
    }

  public boolean isFizzy(){
      return this.fizzy;
  }
}