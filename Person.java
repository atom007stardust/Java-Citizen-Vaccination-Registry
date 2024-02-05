/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Sadia
 */
//class is abstract since I don't want to create its objects , just a base class for defining new classes that holds common properties and methods
public abstract class Person  {  
    private int ID;
    private String name;
   //zero argument constructor
    Person(){
        this(0,null);                //calling multi argument constructor
    }
    //multi argument constructor
    Person(int ID , String name){
        this.ID=ID;
        this.name=name;
    }
    //getters/accessors
      public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    //setters/mutators
        public void setID(int ID){
        this.ID=ID;
    }
    public void setName(String name){
        this.name=name;
    }
    //Overrriding the toString method from the Object class
    @Override
    public String toString(){
        return "Name: "+ name +",\t ID: "+ ID;
    }
    
}
