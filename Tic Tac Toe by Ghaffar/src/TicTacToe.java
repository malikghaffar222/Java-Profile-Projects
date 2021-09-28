import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {

	private JFrame frame;
	private final GridLayout gridLayout = new GridLayout(3, 3);
	private int activePlayer = 0; // 0 for player-O and 1 for player-X
	private JButton[][] b = new JButton[3][3];
	private final int[][] winPositions = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 2, 4, 6 } };
	private int[] gridState = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };

	/**
	 * State position meaning 1 - 0 0 - x 2 - no player has clicked button at this
	 * position till now
	 */

	public TicTacToe() {

		frame = new JFrame("Tic-Tac-Toe");
		frame.setVisible(true);
		frame.setResizable(false); // make window not to be resizable
		frame.setBounds(100, 100, 300, 300);
		frame.setLocationRelativeTo(null); // show window on center Laptop's/Pc's screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = frame.getContentPane();
		c.setLayout(gridLayout); // set the grid layout

		int commandForGrid = 0; // for setting action command of each button to know its cell position in grid
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new JButton("");
				b[i][j].setActionCommand((commandForGrid++) + ""); // cell position will be 0,1,2,...8 for the
																	// coresponding buttons in array
				b[i][j].addActionListener(this); // add action listener
				b[i][j].setFont(new Font("Calibri", Font.PLAIN, 60));
				c.add(b[i][j]);
			}
		}

	}

	/**
	 * Method to handle when a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getText().equals("")) {
			// get the cell position of clicked button that we set before by setting
			// ActionCommand
			int commandForGrid = Integer.parseInt(btn.getActionCommand());
			gridState[commandForGrid] = activePlayer; // set the cell position

			if (activePlayer == 0) {
				btn.setText("O");
			} else if (activePlayer == 1) {
				btn.setText("X");
			}
			btn.setEnabled(false); // disabling the clicked button so that it can't be clicked again once it is
									// clicked
			if (!checkForWinner()) { // if there's no any winner then check if its a tie
				checkForTie();
			}
			activePlayer = (activePlayer == 0) ? 1 : 0; // make active player 1 if it was 0 when current button was
														// clicked
		}

	}

	/**
	 * method to find if its time to announce the winner
	 * 
	 * @return returns true if winner has been found or false if still there's no
	 *         any winner
	 */
	private boolean checkForWinner() {
		for (int[] winPos : winPositions) {
			/**
			 * check if 3 X's or O's in a diagonal, row, or column have been matched then
			 * announce winner w.r.t player
			 */
			if (gridState[winPos[0]] == gridState[winPos[1]] && gridState[winPos[1]] == gridState[winPos[2]]
					&& gridState[winPos[0]] != 2) {
				// somebody has one -- find out who?
				if (gridState[winPos[0]] == 0) {
					announceWinner(0);
				} else {
					announceWinner(1);
				}
				resetGame();
				return true; // if winner found then return true
			}
		}
		return false; // if no winner found return false
	}

	/**
	 * 
	 * @param A 2D button array
	 */
	private void checkForTie() {
		boolean tie = false;
		for (int i = 0; i < gridState.length; i++) {
			if (gridState[i] == 2) { // if there's at least one cell that is still not clicked that means its not
										// still tie
				tie = false;
				break;
			}
			tie = true;
		}
		// if its a tie then tell user that its a tie and ask to play again
		if (tie) {
			int response = JOptionPane.showConfirmDialog(frame, "Oops! It's a tie.", "Would you want to play it again?",
					JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.NO_OPTION) {
				System.exit(0); // if user says no then quit otherwise reset board and play again
			}
			resetGame();
		}
	}

	/**
	 * 
	 * @param player Method that announces the winner in a dialog box
	 */

	private void announceWinner(int player) {
		int response = 0;
		switch (player) {
		case 0:
			response = JOptionPane.showConfirmDialog(frame, "Hurrah! Player-O won the game.",
					"Do you want to play again?", JOptionPane.YES_NO_OPTION);
			break;
		case 1:
			response = JOptionPane.showConfirmDialog(frame, "Hurrah! Player-X won the game.",
					"Do you want to play again?", JOptionPane.YES_NO_OPTION);
			break;
		}
		if (response == JOptionPane.NO_OPTION) {
			System.exit(0); // if user says no then quit
		}
	}

	/**
	 * Method to reset the whole board
	 */
	private void resetGame() {
		// again enabling all buttons and removing the previous text
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j].setText("");
				b[i][j].setEnabled(true);
			}
		}

		// resetting grid state
		for (int i = 0; i < gridState.length; i++) {
			gridState[i] = 2;
		}
		// making active Player-O
		activePlayer = 0;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TicTacToe window = new TicTacToe();
	}

}
