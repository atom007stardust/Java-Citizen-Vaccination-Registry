/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Sadia
 */
import java.util.Date; 
public class Dose implements Comparable<Dose>{
    //Data fields
    private String manufacturer;
    private String place;
    private Date date;
    private HealthProfessional hp;
    
  //constructors 
    //zero argument constructor
   Dose(){
       this(null,null,new Date());
   }
    Dose(String manufacturer,String place,Date date){         //multi argument constructor
        this.manufacturer=manufacturer;
        this.place=place;
        this.date=date;       
       }
    //note: not initializing hp inside constructor because there is a condition for it to be added to dose i.e. No two hps can have same ID. User can violate that using constructor so instead,I’ll be using addHp method in FrequentOps class
    //Getter(Accessor methods) for private fields - doesn't change their state
    public String getManufacturer(){ 
        return this.manufacturer;
    }
    public String getPlace(){
        return this.place;
    }
    public Date getDate(){
        return this.date;
    }
    public HealthProfessional getHealthProfessional(){
        return this.hp;
     }
    //Setter(Mutator) methods for private fields - changes their state
    public void setManufacturer(String manufacturer){
        this.manufacturer=manufacturer;
    }
    public void setPlace(String place){
        this.place=place;
    }
    public void setDate(Date date){
        this.date=date;
    }
 //making this private since I don't want user to directly access this ,infact the FrequentOps class will use this to set Health Professional after checking if his/her ID is unique
     private void setHealthProfessional(HealthProfessional hp){
        this.hp=hp;
    }
     //accessing above method using accessSetHp
     public void accessSetHp(HealthProfessional hp){
         setHealthProfessional(hp);
     }
     //isDefault method is used to check whether or not the dose's attributes have been set manually after constructing it from 0 arg constructor
     public boolean isDefault(Dose d){
         boolean isItDefault=false;
         if(d.getManufacturer() == null || d.getDate()==null ||d.getPlace()==null ){  
             isItDefault=true;
         }
         return isItDefault;
     } //end isDefault method
   
     //For dose comparison
     @Override
    public boolean equals(Object o){
       if( o instanceof Dose){                                   
        Dose oo= (Dose)o;
        return (place.equals(oo.getPlace()) && manufacturer.equals(oo.getManufacturer()));           
    }
       return false;
    } //end equals method
    //Overriding Comparable Interface’s compareTo method to compare the health professionals id in a dose list complementary method in FrequentOps class
    @Override
      public int compareTo(Dose d){
    if(getHealthProfessional().getID()>d.getHealthProfessional().getID())
        return 1;
    else if(getHealthProfessional().getID()<d.getHealthProfessional().getID())
        return -1;
    else
        return 0;
}
    //Overriding object class' toString() method & writing my own implementation in the body
    @Override
  public String toString(){
      String hpInfo ;
      if(hp!=null){           
          hpInfo= hp.toString();
      }
      else{
          hpInfo="Health Professional : Not initialized";
      }
      
      
     return "Doses information: "+"\tmanufacturer: " + manufacturer + " \tplace : "+ place + "\tDate: " +date+ "\n"+ hpInfo ;
     
  } //end toString method
} //end class Dose
