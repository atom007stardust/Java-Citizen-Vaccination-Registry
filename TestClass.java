/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @Sadia
 */

/*
Documentation : I have added some constraints to reduce chances of errors 
1 ) You can't add citizen constructed from empty constructor to the list before setting the proper values, as name=null , id=0 etc won't make any sense , and so that you do not forget to do so after adding it to the list
2) Similarly, you can't add a dose constructed from 0 arg constructor to the citizen whose attributes have default values and have not been set yet using setter.

*/
import java.util.Date;
public class TestClass {

    public static void main(String[] args) {
        
       //Creating an object and ref from FrequentOps class . We can use either class reference or instance sq to access its static methods
       
       FrequentOps sq = new FrequentOps();
       //Creating 7 citizens
       Citizen c1 = new Citizen(95843,"Harry",45,'M');                
       Citizen c2 = new Citizen(885843,"Watson",34,'M');
       Citizen c3 = new Citizen(77843,"Agatha",47,'F');
       Citizen c4 = new Citizen(66843,"Barry",67,'M');
       Citizen c5 = new Citizen(55843,"Sarah",23,'F');
       Citizen c6 = new Citizen(44843,"Joel",18,'M');
       Citizen c7 = new Citizen(33843,"Lara",16,'F');
     
       //Adding 7 citizens to the Citizens List in FrequentOperations class
       FrequentOps.addNewCitizen(c1);  FrequentOps.addNewCitizen(c2);  FrequentOps.addNewCitizen(c3);  FrequentOps.addNewCitizen(c4); FrequentOps.addNewCitizen(c5); FrequentOps.addNewCitizen(c6);  FrequentOps.addNewCitizen(c7); 
        System.out.println("**********************************************************************************************");
       //-------------------------------------------------------------------------------------------------------------------------------------------------------------
       //Creating a dose 
       Dose d1i = new Dose("Pfizer","Sulaiman Habib Hospital",new Date(2021-1900,4-1,16));   
    
       //Creating the above dose's Health Professional
       HealthProfessional h1=new HealthProfessional(32342,"Job",9); 
       //Creating two more doses & their Health Professionals 
       Dose d1ii = new Dose("Pfizer","Khobar PHC ", new Date(2021-1900,7-1,16));    HealthProfessional h1ii=new HealthProfessional(87498,"Watson",6);  
       Dose d1iii = new Dose("Pfizer","Almana Hospital", new Date(2021-1900,11-1,16));   HealthProfessional h1iii=new HealthProfessional(67532,"Bruno",13);  
       
       // Adding Health Professionals to their respective doses
       //a better way since, it checks if an ID for a particular Health Professional name already exists or not
         FrequentOps.addHp(h1,d1i); FrequentOps.addHp(h1ii, d1ii);   FrequentOps.addHp(h1iii, d1iii);
       
       //Adding the created doses no 1 , 2 and 3 to the citizen no 1 i.e. c1
       FrequentOps.addDoseToCitizen(d1i,c1); FrequentOps.addDoseToCitizen(d1ii,c1) ; FrequentOps.addDoseToCitizen(d1iii,c1);  //3 DOSES TAKEN
       
       //Keeping citizen no 2 i.e. c2 unvaccinated
       //---------------------------------------------------------------------------------------------------
       //Creating 2 doses & their health professional for citizen no 3 i.e. c3   
       Dose d3i = new Dose("Astra Zeneca","Saudi German Hospital", new Date(2021-1900,5-1,14));    HealthProfessional h3i=new HealthProfessional(4454,"Jason",2); 
        FrequentOps.addHp(h3i, d3i); 
        FrequentOps.addDoseToCitizen(d3i,c3)   ;//adding dose to the citizen no 3    //1 DOSE TAKEN
       //---------------------------------------------------------------------------------------------------
       //Creating a new dose d5i for citizen no 5 i.e. c5
       Dose d5i= new Dose("Sinopharm","Dar-As-Salama Hospital", new Date(2021-1900,8-1,9));     
      //adding the dose to the citizen no 5
       FrequentOps.addDoseToCitizen(d5i,c5); HealthProfessional h5i= new HealthProfessional(3294,"Toby",4);  FrequentOps.addHp(h5i, d5i);   //1 DOSE TAKEN ,Another will be added below
       
       //-----------------------------------------------------------------------------------------------------
      //Creating a dose for citizen no 7   i.e. c7
       Dose d7i= new Dose("Moderna","Khobar cooperative clinic", new Date(2021-1900,5-1,8));                    
        HealthProfessional h7i = new HealthProfessional(87643,"Tom",7);    FrequentOps.addHp(h7i, d7i);
        FrequentOps.addDoseToCitizen(d7i,c7);
        Dose d7ii= new Dose("Sinopharm "," Almana Hospital ", new Date(2022-1900,3-1,4));
        HealthProfessional h7ii = new HealthProfessional(47643,"Mahmoud",3); FrequentOps.addHp(h7ii, d7ii);
        FrequentOps.addDoseToCitizen(d7ii,c7);      //2 Doses Taken!
        System.out.println("******************************************************************************************");
        
        System.out.println("Testing / VIOLATING THE STATE OF THE OBJECTS");
       //*****************************************************************************************************
       //Violating the state of the objects by: 
       //1)TestNo.1 adding the same citizen twice
       FrequentOps.addNewCitizen(c1);  //c1 won't be added again
       Citizen c8 = new Citizen(95843,"Harry",45,'M');  //exactly similar to citizen c1 just a different instance c8
       FrequentOps.addNewCitizen(c8); //Won't add this citizen to the list as already one exists with the same name,ID ,age and gender
       
       //TestNO 2    adding more than 3 doses to a citizen
       Dose testDose1 = new Dose("Sinopharm","Dhahran vaccine centre", new Date(2021-1900,11,16));  //can't be added to citizen c1 as the max doses limit is 3 
       Dose testDose1I = new Dose("Moderna","SHH", new Date(2021-1900,11-1,16)); //Can't be added as max dose limit is 3
       FrequentOps.addDoseToCitizen(testDose1,c1);   
       FrequentOps.addDoseToCitizen(testDose1I, c1);
       //TestNO 3 Adding a dose taken on the same day again
       Dose testDose2=new Dose("Pfizer","Saudi German Hospital", new Date(2021-1900,5-1,14));  // AS THE DATE IS SIMILAR TO d3i , it won't be added to the dose List for same citizen c3
       FrequentOps.addDoseToCitizen(testDose2, c3); //won't be added as it already exists taken on the same day 
       
       Dose dd = new Dose("Moderna","JKL", new Date(2021-1900,5-1,8));
       FrequentOps.addDoseToCitizen(dd,c7);     
      
        //TestNO 4 Adding a new citizen with different name but same ID as citizen c6
       Citizen c10 = new Citizen(44843,"Johnny",18,'M');     //ADDING CITIZEN WITH DIFFERENT NAME BUT SAME ID
       FrequentOps.addNewCitizen(c10);
       //Won't be added as two citizens can't have same ID
        System.out.println("");
        
       //Other Violation operations
       //TestNO 5 : Adding a citizen constructed from empty constructor , without setting the values
       Citizen c=new Citizen();                      
       FrequentOps.addNewCitizen(c);             //won't be added ,you need to change the default values first. Utility condition
    
       //TestNO 6 : Adding a dose constructed from empty constructor , without setting the values 
       c.setAge(16); c.setGender('F'); c.setID(5465); c.setName("Noura");
       Dose d= new Dose();
       FrequentOps.addDoseToCitizen(d,c);                   
        
       //Test NO. 7 : adding hp initialized to default values to a dose
        HealthProfessional hpp= new HealthProfessional();
        Dose d12= new Dose("Sinopharm","Sulaiman Habib Hospital", new Date(2021-1900,9-1,9));
        FrequentOps.addHp(hpp,d12);    //Adding hpp created from zero arg constructor equal to dose's Health Professional
        FrequentOps.addDoseToCitizen(d12,c5);  //will be added 
        hpp.setExperience(4); hpp.setID(109090); hpp.setName("Ali"); //now it will be added as dose d12 's health Professional for citizen c5 :Sarah
        FrequentOps.addHp(hpp,d12); System.out.println(d12.getHealthProfessional());
        
        //TestNO . 8 Adding a health professional with a different name but similar ID like Health Professional Tom , ID: 87643 for citizen Lara 
       
        Citizen c13= new Citizen(234,"Larry",29,'M');
        HealthProfessional hTest = new HealthProfessional(87643,"Thomas",6);   
        Dose d13= new Dose("Moderna","Almana Hospital",new Date(2022-1900,4-1,12));
        FrequentOps.addHp(hTest, d13);//Won't be added
        
        System.out.println("*******************************************************************************************");
       
        //SHOWING THAT OTHER FREQUENT OPERATIONS ARE WORKING FINE 
       //1)Printing the number of fully vaccinated persons  in my case there are three i.e. citizen c1,c5,c7
        System.out.println(FrequentOps.NoOfFullyVaccinatedPersons());  
        //**************************************************************
        //2) Saving data after sorting them according to ID of Citizen
        FrequentOps.saveData();   //frequent operations
        //**************************************************************
        System.out.println("****************************************************************************************************");
        System.out.println("Printing the data stored in the Citizens List ");
          System.out.println(sq.toString());
          
        
          
    }
}

/*
In Date constructor:
WHY I SUBTRACTED 1900 FROM YEAR AND 1 FROM MONTH REASON IS GIVEN BELOW: 
TO GET the CORRECT YEAR , MINUS 1900 FROM IT e.g 2022-1900 will give 2022 OR 2021-1900 WILL GIVE 2021 otherwise it gives year 3922 or 3921 respectively
AND AS MONTHS ARE INDEXED FROM 0, TO GET the CORRECT MONTH , SUBTRACT 1 FROM IT !    e.g 5-1 to get May otherwise it gives June

*/