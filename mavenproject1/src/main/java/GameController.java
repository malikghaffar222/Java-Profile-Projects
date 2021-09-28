/*
 * Main template class with the menu with all the options
 * 
 */


 

import java.util.Scanner;

public class GameController {
  static  String ent="Entity",smbl="E";
 static void chooseEntity(){
      
     System.out.println("Choose Entity");
     System.out.println("Type: "+"Entity");
     System.out.println("symble: "+"E");
     System.out.print("Entity");
      Scanner entity = new Scanner(System.in);
//     
//       System.out.print("Symble");
//      Scanner sm = new Scanner(System.in);
//       if(entity==null){
//          System.out.print("Enter entity name");
//      }
//       else if(sm==null)
//       {
//       System.out.print("Enter symble");
//       }
//       else{
//   ent=entity.toString();
//   smbl=sm.toString();
//       } 
}
   
static void gameshow(){
 String paid[][]=new String[11][11];
 for(int i=0;i<=10;i++){
      System.out.print(i);
            System.out.print(" ");
 }
 System.out.println(" ");
    for(int i=0;i<10;i++){
        System.out.print(i);
        System.out.print(" ");
        for(int j=0;j<10;j++)
        {
        if((i==1 && j==9)||(i==2 && j==5)
                ||(i==3 && j==2)||(i==5 && j==3)
                ||(i==7 && j==3)||(i==7 && j==5)||(i==7 && j==7)
                ||(i==6 && j==8)||(i==8 && j==1)||(i==9 && j==9)
                )
        {
         
            paid[i][j]="E";
            System.out.print(smbl);
            System.out.print(" ");
        }
        else
        {
            paid[i][j]="-";
        System.out.print(".");
        System.out.print(" ");
        
        }
        }
        System.out.println();
    }
}
    static void menu(){
     
        System.out.println("Enter an option");
        System.out.println(" 1: Display Room");
        System.out.println ("2: Display Entity Information ");
        System.out.println ("3: Reset the room");
        System.out.println ("0: Exit");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
    Room world = new Room();  
    
    System.out.println(world.toString());
    gameshow();
    System.out.println("Initialise the room here");
     world.resetRoom();

    
    Scanner kb = new Scanner(System.in);
    int option;
  

    do  {
	menu();
    option = kb.nextInt();
    kb.nextLine();
    switch (option) {
       case 1: System.out.println("Option to display room");
                 System.out.println(world.toString());
                 gameshow();
               
                break;
    
      case 2: System.out.println(" ENter the position of the entity that you want to display ");
                    chooseEntity();
                     System.out.print("Entity");
      Scanner entity = new Scanner(System.in);
                break;
       case 3: System.out.println("Option to reset the room:");
                
                world.resetRoom();

                break;

                
       case 0: System.out.println(" Game Over");
                break;

       default: System.out.println("Sorry wrong option");
     }
    } while (option != 0); 
      
    }
 }
