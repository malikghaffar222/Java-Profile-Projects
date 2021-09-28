import java.util.Scanner;

public class ConnectFourMain {
   /* The start of the game */
   public static void main(String[] args) {
      ConnectFour cf = new ConnectFour();      // Creates the ConnectFour object (DO NOT DELETE IT)
      Displayer displayer = new Displayer();   // Creates the Displayer object (DO NOT DELETE IT)
      

      /* Start of the game */
      Scanner input=new Scanner(System.in);
      int roundsToPlay;
      int currentRound=1;

      displayer.GameHeader();
      System.out.print("Round of games to play? ");
      roundsToPlay=input.nextInt();
      System.out.print("Who will start first(X or O)? ");
      boolean isValidPlayer=false;
      do
      {
         char firstPalyer=input.next().charAt(0);
         if(firstPalyer=='X')
         {
            cf.SetCurrPlayer(1);
            isValidPlayer=true;
         }
         else if(firstPalyer=='O')
         {
            cf.SetCurrPlayer(0);
            isValidPlayer=true;
         }
         else
         {
            isValidPlayer=false;
            System.out.print("Not Valid Player");
         }
      }while(!isValidPlayer);

      Player[] allPlayers=cf.GetAllPlayers();
      while(currentRound<=roundsToPlay)
      {
         displayer.DisplayScore(allPlayers[1],allPlayers[0]);
         displayer.DisplayRound(currentRound);
         displayer.DisplayGrid(cf.GetGrid());
         boolean isRoundTie=true;

         //System.out.println("agan");
         while(!cf.IsGridFull())
         {
            boolean isInserted=false;
            do
            {
               System.out.print ("\nPlayer "+cf.GetCurrPlayerStr()+", pick a column to insert your disc: ");
               int col=input.nextInt();
               isInserted=cf.InsertDisc(col);
               if(!isInserted)
                  System.out.println("WARNING: col "+col+" is not available");
            }while(!isInserted);
            displayer.DisplayGrid(cf.GetGrid());

            if(cf.IsGridFull())
            {
               System.out.println(currentRound+" is a tie. Grid is full");
               System.out.println("Click \'Enter\' to continue next round.");
            }
            if(cf.HasRoundWinner())
            {
               int points=cf.NumEmptyBlock();
               System.out.println("\n"+"Round "+currentRound+" winner is player "+cf.GetCurrPlayerStr());
               System.out.println(cf.GetCurrPlayerStr()+" will get "+points+" points");
               cf.GetCurrPlayer().AddScore(points);
               cf.SwitchPlayer();
               cf.ResetGrid();
               System.out.println("Click \'Enter\' to continue next round.");
               input.nextLine();
               input.nextLine();
               break;
            }
            cf.SwitchPlayer();
         }
         currentRound++;
      }


      displayer.DisplayScore(allPlayers[0],allPlayers[1]);
      int winner=cf.GameWinner();
      if(winner==0)
         System.out.println("The final winner is Player X");
      else if(winner==1)
         System.out.println("The final winner is Player O");
      else System.out.println("The Match is tie");

   }
}