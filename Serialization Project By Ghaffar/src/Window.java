import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Window {

	JFrame frmWindow;
	JLabel lblNewLabel, lblNewLabel_1;
	JButton btnNewButton;
	boolean updated = false;

	/**
	 * Create the application.
	 */
	public Window(String title, String lbl) {
		initialize(title, lbl);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title, String lbl) {
		frmWindow = new JFrame();
		frmWindow.setTitle(title);
		frmWindow.setResizable(false);
		frmWindow.setVisible(true);
		frmWindow.setBounds(50, 110, 570, 400);
		frmWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWindow.getContentPane().setLayout(null);
		frmWindow.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				writeIntoFile();
				updated = false;
			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				String line = Application.data();
				if (!updated)
					if (!(lblNewLabel_1.getText().contains(line))) {
						JOptionPane.showConfirmDialog(frmWindow, "Update required!", title + " update",
								JOptionPane.OK_CANCEL_OPTION);
						lblNewLabel_1.setText(line);
						frmWindow.repaint();
						updated = true;
					}

			}
		});

		lblNewLabel = new JLabel(lbl);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 26, 304, 48);
		frmWindow.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("This label can be updated");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 103, 483, 82);
		frmWindow.getContentPane().add(lblNewLabel_1);

		btnNewButton = new JButton("Change Label");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Input new label", "User1's turn");
				if (input == null)
					return;
				else
					lblNewLabel_1.setText(input);
				writeIntoFile();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton.setBounds(140, 211, 243, 54);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 103, 483, 82);
		frmWindow.getContentPane().add(btnNewButton);
	}

	public String windowGetText() {
		return lblNewLabel_1.getText();
	}

	public void windowSetText(String s) {
		lblNewLabel_1.setText(s);
	}

	public void writeIntoFile() {
		try {
			File file = new File("Program Action.txt");
			if (!file.exists())
				file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(lblNewLabel_1.getText());
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(0);
		}
	}
}
