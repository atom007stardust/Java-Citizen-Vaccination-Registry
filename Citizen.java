/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * 
 */
import java.util.*;
public class Citizen extends Person implements Comparable<Citizen>{
    //Data fields
    private ArrayList<Dose> doseList; //TO Store the information about all the doses take by a citizen
    
    private int age;
    private char gender;
   
  //Constructors
    //zero or no arg constructor
   Citizen(){ 
       this(0,null,0,'\u0000');  //using this to invoke multi arg constructor wihtin the same class
       doseList = new ArrayList<Dose>();
   }
    
    Citizen(int ID , String name, int age, char gender){           //multi arg constructor
        super(ID,name);                                            //using super to call constructor from the super class CommonAttributes
        this.age=age;                                              //using this as a reference to the data field age of the object being constructed
        this.gender=gender ;                                       //using this as a reference to the data field gender of the object being constructed 
        doseList = new ArrayList<Dose>();
     }
  //public Getter(Accessor methods) for private fields - doesn't change their state
    public int getAge(){
        return this.age;
        
    }
    public char getGender(){
        return this.gender;
    }
     public ArrayList<Dose> getDoseList(){
        return this.doseList;
    }
     
  //public Setter(Mutator) methods for private fields - changes their state
    public void setAge(int age){
        this.age=age;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
   
     public void setDoseList(ArrayList<Dose> doseList ){
       this.doseList=doseList;
    }
     
    //Testing equality of two citizen objects based on ID as two citizens can have same name but ID must be unique!!!
     // A citizen :  Sarah , ID :2345   , Another citizen Sarah , ID:8907
    public boolean equals(Object o){
        if(o instanceof Citizen){    //if it's null ,it will return false
        Citizen oo= (Citizen)o;    //Explicit casting as ref type in argument is from Object class /Super type , to use method of subclass i.e. Citizen's getID() do casting
        return getID()==oo.getID();
        }
        return false;
     } //end equals method
  
  
    // checking doses were taken on the same date or not by using .compareTo() method
  //Checking Dose existence for a citizen to make sure that a dose is not taken again on the same date as there is gap/period between Covid-19 doses 
    //Not checking on basis of manufacturer or place as you can get the same dose like Pfizer as your 2nd dose at the same place after a few weeks
  public boolean doseExists(Dose d){
      boolean doseExist= false;
      if(!doseList.isEmpty()){
          for(Dose x: doseList){
              if(d.getDate()!=null){   //to make sure that the second argument is not null to avoid NullPointerException 
                  if(x.getDate().compareTo(d.getDate())==0){ // == 0 means that both of them have the same date
                      doseExist=true;
                      break;
                  }
              }
          } //end for each
      } //end if
      return doseExist;
  } //end doseExists method
  
  //This method will be called in the Class that implements the Frequent operations (FrequentOps) to add the dose to the doseList for a particular citizen
  //Private because we don't want user to access this directly
  private void addDose(Dose d){
         if(!(doseList.size()>=3)){    //For covid-19 there are 2 doses and 1 booster shot , total =3 doses can be added (not more than that)
                doseList.add(d);
                
         }
          
         else
             System.out.println("3 doses already exist");
  } //end addDose method 
  //to access the above method
  public void accessAddDose(Dose d){
      addDose(d);
  }
   // Creating isDefault method in order not to add the citizen constructed from 0 argument constructor  to the Citizens list directly as , its properties will be default values ,name=null ,ID=0 which doesn't make sense
  // hence first set those properties then add them  to the list in frequent operations class 
  public boolean isDefault(Citizen c){
      boolean isItDefault=false;
      if(c.getID()==0 || c.getName()==null || c.getAge()==0 ||c.getGender()=='\u0000')           
          isItDefault=true;
      return isItDefault;
  } //end isDefault method
  //using this to sort the data according to the citizens' ID number in conjunction with Collections.sort in FrequentOps Class 
  //Overriding the Comparable interface's compareTo method to compare on basis of citizen's ID
  @Override
  public int compareTo(Citizen o){
      if(getID()>o.getID())
          return 1;  
      else if(getID()<o.getID())
          return -1;                          
      return 0;   //this means the IDs are the same
              
  } //end compareTo method
  
 //a string to concatenate all the doses info from the list then return it , since only using return will return the control back to the calling point after getting info of first dose
  public String dosesInfo(){
      String info="";
      if(!doseList.isEmpty()){  
          for(Dose a:doseList){
               info+= a.toString() + "\n";   //concatenating all the info regarding dose to a variable
      }
     
      }
      else
          info= " No doses taken (Citizen is unvaccinated!!!)\n";
      return info;
    } //end doesInfo Method
  
//Overrriding the toString method from Object class with my own implementation (same header ,different implementation)
  @Override
  public String toString(){
      return super.toString() + ",\tage: "+ getAge() + ",\tgender : "+ getGender()+  "\n" +dosesInfo() ; 
      //the call to super means call super class' toString() method and then continue with current class' method calls.
     
  } //end toString method
}   //end class Citizen           
