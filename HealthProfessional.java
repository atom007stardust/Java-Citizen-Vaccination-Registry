/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Sadia
 */
public class HealthProfessional extends Person{
    //Data fields
    private int experience;
    //Constructor
    //0 or no arg constructor
   HealthProfessional(){
       this(0,null,0);
   }
    HealthProfessional(int ID , String name,int experience){  // multi arg
             super(ID,name);
             this.experience=experience;
    }
    //getter
    public int getExperience(){
        return this.experience;
    }
    //setter
    public void setExperience(int experience){
        this.experience=experience;
    }
    
    @Override
    public boolean equals(Object h){
        if(h instanceof HealthProfessional){
        HealthProfessional hh= (HealthProfessional)h;
        return hh.getID()==hh.getID();
        }
        return false;
    } //end equals method
    public boolean isDefault(HealthProfessional hp){
        boolean isHpDefault= false;
        if(hp.getExperience()==0 || hp.getID()==0 || hp.getName()==null)
            isHpDefault=true;
        return isHpDefault;
    } //end isDefault method
  
    @Override
    public String toString(){
         return "\t    \tHealth Professional info: " + super.toString() + ",\t experience years: " + experience;        //using super.toString() to call super class's toString() method
       
        
    } //end toString method
    
    
} //end class HealthProfessional
