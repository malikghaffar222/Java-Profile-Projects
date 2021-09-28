/* The game that keeps track of all the information, such as
 * the grid and which player's turn */
public class ConnectFour {
   public final static int GRID_HEIGHT = 6;     // The default height of the grid (DO NOT CHANGE)
   public final static int GRID_WIDTH  = 7;     // The default width of the grid (DO NOT CHANGE)
   
   private Disc[][] grid;                       // The grid of the game. A 2D array of Disc objects
   private Player[] allPlayers;                 // An array that stores all the player's object
   private Player currPlayer;                   // Keeps track of the currently playing player
   
   //======================= CONSTRUCTOR =======================//
   public ConnectFour() 
   {
      grid=new Disc[GRID_HEIGHT][GRID_WIDTH];
      allPlayers=new Player[2];
      allPlayers[0]=new Player(1);
      allPlayers[1]=new Player(0);
   }
   
   //====================== PRIVATE METHOD =======================//

   private boolean findDisc()
   {
    for(int i=0; i<grid.length; i++)
    {
      for(int j=0; j<grid[i].length; j++)
      {
        if(grid[i][j]==null) continue;

        if(grid[i][j].GetDiscType()==currPlayer.GetDiscType())
        {
          if(slashDiagonal(i,j)) return true;

          else if(backSlashDiagonal(i,j)) return true;

          else if(horizontal(i,j)) return true;

          else if(vertical(i,j)) return true;
        }
      }
    }
    return false;
   }
   private boolean slashDiagonal(int i,int j)  // '/' diagonal
   {
    //i=row j=col
     int counter=0;
     while(i<GRID_HEIGHT && j>=0)
     {
       if(grid[i][j]==null) 
        {
          break;
        }
       if(grid[i][j].GetDiscType()==currPlayer.GetDiscType())
       {
        counter++;
       }
       else
       {
        break;
       }

       i++; j--;
     }
     return (counter==4);
   }

   private boolean backSlashDiagonal(int i,int j)
   {
       int counter=0;
     while(i<GRID_HEIGHT && j<GRID_WIDTH)
     {
       if(grid[i][j]==null) 
        {
          break;
        }
       if(grid[i][j].GetDiscType()==currPlayer.GetDiscType())
       {
        counter++;
       }
       else
       {
        break;
       }

       i++; j++;
     }
     return (counter==4);
   }

   private boolean horizontal(int i,int j)
   {
      int counter=0;

      while(j<GRID_WIDTH)
      {
        if(grid[i][j]==null) break;
        if(grid[i][j].GetDiscType()==currPlayer.GetDiscType())
        {
          counter++;
        }
        else break;
        j++;
      }

      System.out.println("Counter="+counter);
      return (counter==4);
   }

   private boolean vertical(int i,int j)
   {
      int counter=0;

      while(i<GRID_HEIGHT)
      {
        if(grid[i][j]==null) break;
        if(grid[i][j].GetDiscType()==currPlayer.GetDiscType())
        {
          counter++;
        }

        else break;
        i++;
      }

      return (counter==4);
   }
   
   //====================== PUBLIC METHOD =======================//
   /* It returns the 2D grid to the caller
    * @return - The 2D grid containing Disc objects */
   public Disc[][] GetGrid() 
   {
      return grid;  // Dummy return value
   }
   
   /* Resets the grid so it contains nothing */
   public void ResetGrid() 
   {
      grid=new Disc[GRID_HEIGHT][GRID_WIDTH];  //it restores the moves
   }
   
   /* Check if the grid is full
    * @return - Returns true, if the grid is full.
    *           Returns false, if the grid is not full. */    
   public boolean IsGridFull() 
   {

      int counter=0;

      for(int i=0; i<grid.length; i++)
      {
        for(int j=0; j<grid[i].length; j++)
        {
          if(grid[i][j]==null) counter++;
        }
      }

      //System.out.println("agan");
      return (counter==0);  // Dummy return value
   }   
   
   /* Inserts a disc in the specified column and will determine
    * if it successfully inserted or not
    * @param col - The column that the player wants to insert the disc
    * @return    - Return true, if the disc is inserted successfully.
    *              Return false, if the column is full */    
    public boolean InsertDisc(int col) 
    {
     for(int j = grid[0].length-1 ; j >=0; j--)
     {
       for(int i = grid.length-1 ; i >=0; i--)
       {
         if(j == (col-1))
         {
           if(grid[i][j] == null)
           {
             
            grid[i][j] = new Disc(GetCurrPlayer().GetDiscType());
            return true;
           }
         }
       }
     }
      return false;  // return value
   }  
   
   /* Get the number of empty blocks in the grid
    * @return - The number of empty blocks */
   public int NumEmptyBlock() 
   {
      int counter=0;

      for(int i=0; i<grid.length; i++)
      {
        for(int j=0; j<grid[i].length; j++)
        {
          if(grid[i][j]==null) counter++;
        }
      }
      return counter;  // Dummy return value
   }   
   
   /* Gets all the players 
    * @return - The array that contains all the players' object */
   public Player[] GetAllPlayers() 
   {
      return allPlayers;  // Dummy return value
   }
   
   /* Returns the current player, represented by a number value
    * @return - The value that represents the player.
    *           Returns 0 if current player is X
    *           Returns 1 if current player is O */
   public Player GetCurrPlayer() {
      return currPlayer;  // Dummy return value
   }
   
   /* Set who will be the current playing 
    * @param playerVal - The value that represents the player */
   public void SetCurrPlayer(int playerVal) 
   {
    currPlayer=allPlayers[playerVal];
   }
 
   /* Get the current player's name (either X or O)
    * @return - The player's name, either "X" or "O" */   
   public String GetCurrPlayerStr() 
   {
      if(currPlayer.GetDiscType()==0)
      return "X";  // Dummy return value
      return "O";
   }
    
   /* Switch player turn to the next player (If current player is X, then it 
    * switches to O. If current player is O, then it switches to X) */   
   public void SwitchPlayer() 
   {
      if(currPlayer==allPlayers[0])
        currPlayer=allPlayers[1];
      else
        currPlayer=allPlayers[0];
   }
   
   /* Check is there is a winner 
    * @return - Returns true, if there is a winner.
    *           Returns false, if there is no winner */      
   public boolean HasRoundWinner() 
   {
      return findDisc();
      //return true;  // Dummy return value
   }
   
   /* Determine the winner by checking the player's score. 
    * @return - The value that represents the player who wins.
    *           If it's a tie, returns -1 */
   public int GameWinner() 
   {
      if(allPlayers[0].GetScore()>allPlayers[1].GetScore()) return allPlayers[0].GetDiscType();

      else if(allPlayers[0].GetScore()<allPlayers[1].GetScore()) return allPlayers[1].GetDiscType();
      
      return -1;
      // Dummy return value
   }
}