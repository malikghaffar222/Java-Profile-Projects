import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankTeller {

	private JFrame frmBanktellerjava;
	private BankAccount bankAccount;
	private JTextField nameTf;
	private JTextField aNumTf;
	private JTextField transTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		BankTeller window = new BankTeller();
	}

	/**
	 * Create the application.
	 */
	public BankTeller() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBanktellerjava = new JFrame();
		frmBanktellerjava.setTitle("BankTeller.java");
		frmBanktellerjava.setVisible(true);
		frmBanktellerjava.setResizable(false);
		frmBanktellerjava.setBounds(100, 100, 500, 500);
		frmBanktellerjava.setLocationRelativeTo(null);
		frmBanktellerjava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBanktellerjava.getContentPane().setLayout(null);

		bankAccount = new BankAccount();

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		nameLabel.setBounds(25, 58, 144, 35);
		frmBanktellerjava.getContentPane().add(nameLabel);

		JLabel accountNumLbl = new JLabel("Account Num");
		accountNumLbl.setHorizontalAlignment(SwingConstants.LEFT);
		accountNumLbl.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		accountNumLbl.setBounds(25, 128, 144, 35);
		frmBanktellerjava.getContentPane().add(accountNumLbl);

		JLabel transactionLbl = new JLabel("Transaction");
		transactionLbl.setHorizontalAlignment(SwingConstants.LEFT);
		transactionLbl.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		transactionLbl.setBounds(25, 202, 144, 35);
		frmBanktellerjava.getContentPane().add(transactionLbl);

		JButton submitBtn = new JButton("Submit");
		submitBtn.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = nameTf.getText();
					int accountNum = Integer.parseInt(aNumTf.getText());
					double transaction = Double.parseDouble(transTf.getText());

					bankAccount.setName(name);
					bankAccount.setAccountNumber(accountNum);
					bankAccount.setCurrentAmount(bankAccount.getCurrentAmount() + transaction);

					frmBanktellerjava.getContentPane().remove(nameTf);
					frmBanktellerjava.getContentPane().remove(aNumTf);
					frmBanktellerjava.getContentPane().remove(transTf);
					frmBanktellerjava.getContentPane().remove(submitBtn);

					nameLabel.setSize(nameLabel.getWidth() + 150, nameLabel.getHeight());
					accountNumLbl.setSize(accountNumLbl.getWidth() + 150, accountNumLbl.getHeight());
					transactionLbl.setSize(transactionLbl.getWidth() + 150, transactionLbl.getHeight());
					frmBanktellerjava.repaint();

					nameLabel.setText("Name: " + bankAccount.getName());
					accountNumLbl.setText("Account Num: " + bankAccount.getAccountNumber());
					transactionLbl.setText("Transaction: $" + bankAccount.getCurrentAmount());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frmBanktellerjava, e1);
				}
			}
		});
		submitBtn.setBounds(173, 267, 115, 29);
		frmBanktellerjava.getContentPane().add(submitBtn);

		nameTf = new JTextField();
		nameTf.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		nameTf.setBounds(186, 58, 258, 35);
		frmBanktellerjava.getContentPane().add(nameTf);
		nameTf.setColumns(10);

		aNumTf = new JTextField();
		aNumTf.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		aNumTf.setColumns(10);
		aNumTf.setBounds(186, 128, 258, 35);
		frmBanktellerjava.getContentPane().add(aNumTf);

		transTf = new JTextField();
		transTf.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		transTf.setColumns(10);
		transTf.setBounds(186, 202, 258, 35);
		frmBanktellerjava.getContentPane().add(transTf);
	}
}
