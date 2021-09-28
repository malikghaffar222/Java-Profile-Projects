/* To display the grid with the given 2D array */
public class Displayer 
{
   //======================= CONSTRUCTOR =======================//
   public Displayer() {
   }
   
   //====================== PRIVATE METHOD =======================//
   
   
   //====================== PUBLIC METHOD =======================//
   /* Displays the game title screen */
   public void GameHeader() 
   {
      displayChar(30,'=');
      System.out.println();
      System.out.print("|");
      displayChar(10,' ');
      System.out.print("CONNECT FOUR");
      displayChar(6,' ');
      System.out.print("|");
      System.out.println();
      displayChar(30,'=');
      System.out.println();

   }
   
   /* Display the player's score on the screen 
    * @param x - Object that represents player x  
    * @param o - Object that represents player o */
   public void DisplayScore(Player x, Player o) 
   {
    System.out.println();
      System.out.println("CURRENT SCORE------------------");
      System.out.println("PLAYER X: "+x.GetScore()+" points");
      System.out.println("PLAYER O: "+o.GetScore()+" points");
      displayChar(30,'-');
      System.out.println();
   }
   
   /* Display the current round number
    * @param roundNum - The current round's number */
   public void DisplayRound(int roundNum ) 
   {
      displayChar(10,'*');
      System.out.print(" Round "+roundNum+" ");
      displayChar(17,'*');
      System.out.println();
   }

   private void displayChar(int times,char letter)
   {
      for(int i=1; i<=times; i++)
      {
        System.out.print(letter);
      }
   }
   
   /* Takes in the 2D grid and displays the contains as a 
    * grid on the screen, for players to see the current state
    * @param grid - The 2D array that contains Disc objects */
   public void DisplayGrid(Disc[][] grid) 
   {
      for(int i=0; i<grid.length; i++)
      {

        displayChar(5,' '); displayChar(29,'-');
        System.out.println();
        displayChar(5,' ');
        for(int j=0; j<grid[i].length; j++)
        {
           if(grid[i][j]==null)
           System.out.print("|   ");
           else if(grid[i][j].GetDiscType()==Disc.X_DISC)
            System.out.print("| X ");
           else if(grid[i][j].GetDiscType()==Disc.O_DISC)
            System.out.print("| O ");
        }

        System.out.println("|");
      }

      displayChar(5,' '); displayChar(29,'-');

      System.out.println();
      System.out.print("COL    1   2   3   4   5   6   7");
   }
}