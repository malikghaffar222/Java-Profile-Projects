package ass2;

import java.util.Arrays;

public class Azul {
    /**
     * Given a shared state string, determine if it is well-formed.
     * Note: you don't need to consider validity for this task.
     * A sharedState is well-formed if it satisfies the following conditions.
     * <p>
     * [turn][factories][centre][bag][discard]
     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
     * corresponding small string as described below.
     * <p>
     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
     * player, which indicates that it is this player's turn to make the next
     * drafting move. (In a two-player game, the turn substring can only take
     * the values 'A' or 'B').
     * <p>
     * 1. [factories] The factories substring begins with an 'F'
     * and is followed by a collection of *up to* 5 5-character factory strings
     * representing each factory.
     * Each factory string is defined in the following way:
     * 1st character is a sequential digit '0' to '4' - representing the
     * factory number.
     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
     * the tiles.
     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
     * it does not appear in the factories string.
     * Factory strings are ordered by factory number.
     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
     * Factories 0 and 4 are empty.
     * <p>
     * 2. [centre] The centre substring starts with a 'C'
     * This is followed by *up to* 15 characters.
     * Each character is 'a' to 'e', alphabetically - representing a tile
     * in the centre.
     * The centre string is sorted alphabetically.
     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
     * <p>
     * 3. [bag] The bag substring starts with a 'B'
     * and is followed by 5 2-character substrings
     * 1st substring represents the number of 'a' tiles, from 0 - 20.
     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
     * 4th substring represents the number of 'd' tiles, from 0 - 20.
     * 5th substring represents the number of 'e' tiles, from 0 - 20.
     * <p>
     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
     * 4. [discard] The discard substring starts with a 'D'
     * and is followed by 5 2-character substrings defined the same as the
     * bag substring.
     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
     *
     * @param sharedState the shared state - factories, bag and discard.
     * @return true if sharedState is well-formed, otherwise return false
     * TASK 2
     */
    public static boolean isSharedStateWellFormed(String sharedState) {
        // Check the number of signal characters in the string
        if (sharedState.charAt(0) < 'A' && sharedState.charAt(0) > 'D'){
            return false;
        }
        String checkString = sharedState.substring(1);
        int numFactory = checkString.length() - checkString.replace("F","").length();
        int numCentre = checkString.length() - checkString.replace("C","").length();
        int numBag = checkString.length() - checkString.replace("B","").length();
        int numDiscard = checkString.length() - checkString.replace("D","").length();
        if (numFactory > 1 || numCentre > 1 || numBag > 1 || numDiscard > 1){
            return false;
        }
        if (numFactory == 0 || numCentre == 0 || numBag ==0 || numDiscard == 0){
            return false;
        }

        // Check the order of singal characters in the string
        int indexFactory = checkString.indexOf("F");
        int indexCentre = checkString.indexOf("C");
        int indexBag = checkString.indexOf("B");
        int indexDiscard = checkString.indexOf("D");
        int[] index = { indexFactory, indexCentre, indexBag, indexDiscard };
        Arrays.sort(index);
        if (indexFactory != 0 || indexFactory != index[0] || indexCentre != index[1] || indexBag != index[2] || indexDiscard != index[3]){
            return false;
        }

        // Divid the string into substrings
        String stringFactory = checkString.substring(index[0] + 1, index[1]);
        String stringCentre = checkString.substring(index[1] + 1, index[2]);
        String stringBag = checkString.substring(index[2] + 1, index[3]);
        String stringDiscard = checkString.substring(index[3] + 1);

        // Check the substring of Factory
        int lengthFactory = stringFactory.length();
        int count = 0;
        int previousNum = -1;
        boolean[] check = {false, false, false, false, false};
        for (;count < lengthFactory;count++){
            if (stringFactory.charAt(count) < '0' || stringFactory.charAt(count) > '4'){
                return false;
            }
            int num = stringFactory.charAt(count) - '0';
            if (count + 5 > lengthFactory || check[num] || previousNum >= num){
                return false;
            }
            check[num] = true;
            previousNum = num;
            char previousChar = 'a';
            for (int i = 0; i < 4; i++){
                count++;
                if (stringFactory.charAt(count) < 'a' || stringFactory.charAt(count) > 'e' || previousChar > stringFactory.charAt(count)){
                    return false;
                }
                previousChar = stringFactory.charAt(count);
            }
        }

        // Check the Centre
        int lengthCentre = stringCentre.length();
        if (lengthCentre > 15){
            return false;
        }
        char previousChar = 'a';
        for (int i = 0;i < lengthCentre; i++){
            if (stringCentre.charAt(i) < previousChar || stringCentre.charAt(i) > 'f'){
                return false;
            }
            previousChar = stringCentre.charAt(i);
        }

        // Check the Bag
        int lengthBag = stringBag.length();
        if (lengthBag != 10){
            return false;
        }
        for (int i = 0; i < 5; i++){
            if (stringBag.charAt(i * 2) < '0' || stringBag.charAt(i * 2) > '2' || stringBag.charAt(i * 2 + 1) < '0' || stringBag.charAt(i * 2 + 1) > '9'){
                return false;
            }
            if (stringBag.charAt(i * 2) == '2' && stringBag.charAt(i * 2 + 1) > '0' ){
                return false;
            }
        }

        // Discard
        int lengthDiscard = stringDiscard.length();
        if (lengthDiscard != 10){
            return false;
        }
        for (int i = 0; i < 5; i++){
            if (stringDiscard.charAt(i * 2) < '0' || stringDiscard.charAt(i * 2) > '2' || stringDiscard.charAt(i * 2 + 1) < '0' || stringDiscard.charAt(i * 2 + 1) > '9'){
                return false;
            }
            if (stringDiscard.charAt(i * 2) == '2' && stringDiscard.charAt(i * 2 + 1) > '0' ){
                return false;
            }
        }

        return true;
    }

    /**
     * Given a playerState, determine if it is well-formed.
     * Note: you don't have to consider validity for this task.
     * A playerState is composed of individual playerStrings.
     * A playerState is well-formed if it satisfies the following conditions.
     * <p>
     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
     * a corresponding substring as described below.
     * Each playerString is sorted by Player i.e. Player A appears before Player B.
     * <p>
     * 1. [player] The player substring is one character 'A' to 'D' -
     * representing the Player
     * <p>
     * 2. [score] The score substring is one or more digits between '0' and '9' -
     * representing the score
     * <p>
     * 3. [mosaic] The Mosaic substring begins with a 'M'
     * Which is followed by *up to* 25 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is 'a' to 'e' - representing the tile colour.
     * 2nd character is '0' to '4' - representing the row.
     * 3rd character is '0' to '4' - representing the column.
     * The Mosaic substring is ordered first by row, then by column.
     * That is, "a01" comes before "a10".
     * <p>
     * 4. [storage] The Storage substring begins with an 'S'
     * and is followed by *up to* 5 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
     * 2nd character is 'a' to 'e' - representing the tile colour.
     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
     * Each 3-character string is ordered by row number.
     * <p>
     * 5. [floor] The Floor substring begins with an 'F'
     * and is followed by *up to* 7 characters in alphabetical order.
     * Each character is 'a' to 'f' - where 'f' represents the first player token.
     * There is only one first player token.
     * <p>
     * An entire playerState for 2 players might look like this:
     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
     * If we split player A's string into its substrings, we get:
     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
     *
     * @param playerState the player state string
     * @return True if the playerState is well-formed,
     * false if the playerState is not well-formed
     * TASK 3
     */
    public static boolean isPlayerStateWellFormed(String playerState) {
        // FIXME Task 3
        return false;
    }

    /**
     * Given the gameState, draw a *random* tile from the bag.
     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
     * If the discard pile is also empty, return 'Z'.
     *
     * @param gameState the current game state
     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
     * TASK 5
     */
    public static char drawTileFromBag(String[] gameState) {
        // FIXME Task 5
        return '0';
    }

    /**
     * Given a state, refill the factories with tiles.
     * If the factories are not all empty, return the given state.
     *
     * @param gameState the state of the game.
     * @return the updated state after the factories have been filled or
     * the given state if not all factories are empty.
     * TASK 6
     */
    public static String[] refillFactories(String[] gameState) {
        // FIXME Task 6
        return null;
    }

    /**
     * Given a gameState for a completed game,
     * return bonus points for rows, columns, and sets.
     *
     * @param gameState a completed game state
     * @param player    the player for whom the score is to be returned
     * @return the number of bonus points awarded to this player for rows,
     * columns, and sets
     * TASK 7
     */
    public static int getBonusPoints(String[] gameState, char player) {
        // FIXME Task 7
        int result = 0;
        // Validation check
        if (!isStateValid(gameState)) {
            return -1;
        }
        int playerIndex = gameState[1].indexOf(player);
        if (playerIndex == -1){
            return -1;
        }
        int nextIndex = gameState[1].indexOf(player + 1);
        String subPlayerString;
        if (nextIndex == -1){
            subPlayerString = gameState[1].substring(playerIndex);
        }
        else{
            subPlayerString = gameState[1].substring(playerIndex, nextIndex);
        }

        // Get the substring of mosaic of exact player
        int mosaicIndex = subPlayerString.indexOf('M');
        int storageIndex = subPlayerString.indexOf('S');
        String mosaicString = subPlayerString.substring(mosaicIndex + 1, storageIndex);
        int num = mosaicString.length() / 3;

        // Initialization
        char[][] mosaicArray = new char[5][5];
        int[] countChar = new int[6];
        for (int i = 0; i < 5;i++){
            for (int j = 0; j < 5;j++){
                mosaicArray[i][j] = ' ';
            }
        }
        Arrays.fill(countChar, 0);

        // Bonus points calculation
        for (int i = 0;i < num;i++){
            char mosaic = mosaicString.charAt(i * 3);
            int row = mosaicString.charAt(i * 3 + 1) - '0';
            int column = mosaicString.charAt(i * 3 + 2) - '0';
            mosaicArray[row][column] = mosaic;
            countChar[mosaic - 'a'] ++;
        }
        for (int i = 0;i < 5 ;i++){
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < 5; j++){
                sumRow += (mosaicArray[i][j] != ' ') ? 1 : 0;
                sumColumn += (mosaicArray[j][i] != ' ') ? 1 : 0;
            }
            result += (sumRow == 5) ? 2 : 0;
            result += (sumColumn == 5) ? 7 : 0;
            result += (countChar[i] == 5)? 10 : 0;
        }
        return result;
    }

    /**
     * Given a valid gameState prepare for the next round.
     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
     * 2. Refill the factories from the bag.
     * * If the bag is empty, refill the bag from the discard pile and then
     * (continue to) refill the factories.
     * * If the bag and discard pile do not contain enough tiles to fill all
     * the factories, fill as many as possible.
     * * If the factories and centre contain tiles other than the first player
     * token, return the current state.
     *
     * @param gameState the game state
     * @return the state for the next round.
     * TASK 8
     */
    public static String[] nextRound(String[] gameState) {
        // FIXME TASK 8
        return null;
    }

    /**
     * Given an entire game State, determine whether the state is valid.
     * A game state is valid if it satisfies the following conditions.
     * <p>
     * [General]
     * 1. The game state is well-formed.
     * 2. There are no more than 20 of each colour of tile across all player
     * areas, factories, bag and discard
     * 3. Exactly one first player token 'f' must be present across all player
     * boards and the centre.
     * <p>
     * [Mosaic]
     * 1. No two tiles occupy the same location on a single player's mosaic.
     * 2. Each row contains only 1 of each colour of tile.
     * 3. Each column contains only 1 of each colour of tile.
     * [Storage]
     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
     * 2. The colour of tile stored in a row must not be the same as a colour
     * already found in the corresponding row of the mosaic.
     * <p>
     * [Floor]
     * 1. There are no more than 7 tiles on a single player's floor.
     * [Centre]
     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
     * [Factories]
     * 1. At most one factory has less than 4, but greater than 0 tiles.
     * Any factories with factory number greater than this factory must contain 0 tiles.
     *
     * @param gameState array of strings representing the game state.
     *                  state[0] = sharedState
     *                  state[1] = playerStates
     * @return true if the state is valid, false if it is invalid.
     * TASK 9
     */
    public static boolean isStateValid(String[] gameState) {
        // FIXME Task 9
        return true;
    }

    /**
     * Given a valid gameState and a move, determine whether the move is valid.
     * A Drafting move is a 4-character String.
     * A Drafting move is valid if it satisfies the following conditions:
     * <p>
     * 1. The specified factory/centre contains at least one tile of the specified colour.
     * 2. The storage row the tile is being placed in does not already contain a different colour.
     * 3. The corresponding mosaic row does not already contain a tile of that colour.
     * Note that the tile may be placed on the floor.
     * </p>
     * <p>
     * A Tiling move is a 3-character String.
     * A Tiling move is valid if it satisfies the following conditions:
     * 1. The specified row in the Storage area is full.
     * 2. The specified column does not already contain a tile of the same colour.
     * 3. The specified location in the mosaic is empty.
     * 4. If the specified column is 'F', no valid move exists from the
     * specified row into the mosaic.
     * </p>
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return true if the move is valid, false if it is invalid.
     * TASK 10
     */
    public static boolean isMoveValid(String[] gameState, String move) {
        // FIXME Task 10
        return false;
    }

    /**
     * Given a gameState and a move, apply the move to the gameState.
     * If the move is a Tiling move, you must also update the player's score.
     * If the move is a Tiling move, you must also empty the remaining tiles
     * into the discard.
     * If the move is a Drafting move, you must also move any remaining tiles
     * from the specified factory into the centre.
     * If the move is a Drafting move and you must put tiles onto the floor,
     * any tiles that cannot fit on the floor are placed in the discard with
     * the following exception:
     * If the first player tile would be placed into the discard, it is instead
     * swapped with the last tile in the floor, when the floor is sorted
     * alphabetically.
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return the updated gameState after the move has been applied.
     * TASK 11
     */
    public static String[] applyMove(String[] gameState, String move) {
        // FIXME Task 11
        return null;
    }

    /**
     * Given a valid game state, return a valid move.
     *
     * @param gameState the game state
     * @return a move for the current game state.
     * TASK 13
     */
    public static String generateAction(String[] gameState) {
        // FIXME Task 13
        return null;
        // FIXME Task 15 Implement a "smart" generateAction()
    }
}
