/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Sadia
 */
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;        
public class FrequentOps {
    //Storing the whole data in one Collection i.e. citizensList
    private static ArrayList<Citizen> citizensList = new ArrayList<>(); //using a static data field as our common operations are static methods which can't invoke instance field
    
     FrequentOps(){            //0 arg constructor
        citizensList =new ArrayList<>();
    }
    
    FrequentOps(ArrayList<Citizen> l){            // 1 arg constructor
        this.citizensList = l ;
    }  
    public ArrayList<Citizen> getCitizensList(){
        return this.citizensList;
    }
    public void setCitizensList(ArrayList<Citizen> l){
        this.citizensList=l;
    }
    
  public static boolean existsCitizen(Citizen c){             //In order to add citizen first check whether he already exists or not as to not repeat the citizen
        boolean citizenExists =false;                  //by default , assuming that the citizen doesn't exist
        if(!citizensList.isEmpty()){                   //if the list is empty then avoid the redundant comparison
            for(Citizen x: citizensList){            //using for each loop to iterate over the Citizens list
                if(x.equals(c)){             
                    citizenExists=true;
                    break;                          //if a match is found , no need to continue iteration and just break out of the loop
                }
            }
        }
        
        return citizenExists;                       //returns the status of citizen's existence whether exists or not
    }//end existsCitizen method
    //Frequent Operation number 1
    public static void addNewCitizen(Citizen c1){
//isNull is a method from citizens class used to check if the attributes have not been initialized to null either by using 0 arg constructor and not setting the appropriate value before adding citizen to the list
     if(!existsCitizen(c1) && !c1.isDefault(c1)){   //calls existsCitizen(Citizen c) method
         citizensList.add(c1);
         System.out.println("The citizen "+ c1.getName()+ " \t ID number:  "+c1.getID() +" \tage: " +c1.getAge() + " has been successfully added to the list");
     }
     else if(existsCitizen(c1))          //print this message if the citizen is already present in the list
           System.out.println("The citizen ID number " +c1.getID() + " already exists for a citizen. So we can't add the citizen to the list");    
     else if(c1.isDefault(c1))
            System.out.println("The citizen can't be added as some properties have not been set yet !");
     
    }  //end addNewCitizen method
    //Frequent Operation number 2
   //Adding dose d to the corresponding citizen 
    public static void addDoseToCitizen(Dose d,Citizen c) {
        
        //make sure the citizen is not null to avoid Null pointer exception (Unchecked exception)
        //d.isNull is used to check if the dose's property have not been set properly after creating them using 0 arg constructor
        if(!c.isDefault(c) && !c.doseExists(d) && !(c.getDoseList().size()>=3) && !d.isDefault(d) ){       
            c.accessAddDose(d);
            System.out.println("The dose "+ d.getManufacturer() +" has been added to the list for citizen " + c.getName() + "  ID number " + c.getID() );
         
        }
        //Printing the appropriate message to the console to notify the user why the operation was not successful
        else if((c.getDoseList().size()>=3)) //maximum doses that can be taken are 3 in number
            System.out.println("3 doses have already been taken ! can't add " +d.getManufacturer() + " to citizen " + c.getName() + " ID: "+ c.getID());
        else if(c.doseExists(d)){
                
            System.out.println("The dose " + d.getManufacturer() + " couldn't be added since a dose was already taken on this date  ");
        }
        else if(c.isDefault(c)) //if citizen's attributes are set to default , set them to appropriate values first then add the dose to the citizen
            System.out.println("Change the default properties of citizen first , then add the dose to it");
        //if dose's attributes are set to default , set them to appropriate values first then add the dose to the citizen
        else if(d.isDefault(d))  //to print the appropriate message to the user 
            System.out.println("The dose couldn't be added as some properties of the dose have been set to default values! Set values first ! then add the dose");
               
    } //end addDoseToCitizen method
    //Checking if a health Professional's id already exists so that it cannot be used again for another name 
    public static boolean hpIDExistence(HealthProfessional h){
       boolean hpIDExists=false;
        for(Citizen c: citizensList){
            for(Dose d : c.getDoseList()){
                if(d.getHealthProfessional()!=null &&d.getHealthProfessional().getID()==h.getID())
                    if(!d.getHealthProfessional().getName().equals(h.getName())){
                        hpIDExists=true;
                        break;
                    }
            }
        }
        return hpIDExists;
        
    } //end hpIDExistence method
    //Adding health professional to the specified dose
    public static void addHp(HealthProfessional hp ,Dose d ){
        if(!hp.isDefault(hp) && !hpIDExistence(hp))
            d.accessSetHp(hp);
        else if(hpIDExistence(hp))
            System.out.println("A similar ID already exists for an hp so we couldn't add him/her to the dose");
        else
            System.out.println("The Health Professional's attributes are set to default , please use setter method to set their appropriate values THEN ADD IT TO THE DOSE");
      
    } //end addHp method
    //FrequentOperation number 2 , retrieving number of fully vaccinated persons , who took atleast two doses
    public static String NoOfFullyVaccinatedPersons(){
        int count=0;
        if(citizensList!=null){                                  
            for(Citizen x: citizensList){
                if(x.getDoseList().size()>=2)    //Fully vaccinated people = those who took atleast 2 doses
                    count++;
            }
        }
        return "No of fully vaccinated persons are: " + count;
        
        
    } //end NoOfFullyVaccinatedPersons method
    //Sorting the data 
     public static void sortData(){
         //sorts the citizens based on Civil ID number
         if(citizensList !=null && !citizensList.isEmpty()){  
             Collections.sort(citizensList);
         }
         ArrayList<Dose> list1 = new ArrayList<Dose>(); 
       for(Citizen c : citizensList){ //sorts the Health Professionals inside dose list of each citizen based on ID number
           if(c.getDoseList()!=null){
           list1 =c.getDoseList();
            Collections.sort(list1);
           }
       }
     }//end sortData method
     //Saving the data to a text file
    public static void saveData(){
         sortData();     //sorting the data according to the civil ID number of citizens and Health Professional ID dose list for each citizen
         //Checking for checked exceptions like FileNotFoundException
         try{
             File fw= new File("src/Citizens.txt"); //creating a File object file
             PrintWriter pr= new PrintWriter(fw);    //creating a print writer object pr      
             if(citizensList !=null && !citizensList.isEmpty()){
             for(Citizen p : citizensList){
                 pr.println(p.toString());
             }
             
             System.out.println("Data has been sorted and saved successfully");
             }
             else{
                 System.out.println("The list has not been initialized yet. Add citizens to the list first , then save the file");
             }
             pr.close();
         }
         
         catch(FileNotFoundException e){
             System.out.println(e+ "File could not be found ! Hence data couldn't be saved to the file.");
         }
         
     } //end save Data method

    
   
    //Using the to String method to print the status  / information 
    @Override
    public String toString(){
        String output ="";
        if(citizensList!=null){
        for(Citizen b:citizensList){
            output+= "Citizens info: " + b.toString() + "\n" ;
    }  }
        else
            System.out.println("The list has not been initialized yet!");
    return output;
    } //end toString method
} //end Class FrequentOps
