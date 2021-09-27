import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MyCalculator {

	private JFrame frmMyCalculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MyCalculator window = new MyCalculator();

	}

	/**
	 * Create the application.
	 */
	public MyCalculator() {
		frmMyCalculator = new JFrame();
		frmMyCalculator.setVisible(true);
		frmMyCalculator.setTitle("MY CALCULATOR");
		frmMyCalculator.setBounds(100, 100, 513, 214);
		frmMyCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyCalculator.getContentPane().setLayout(null);

		JLabel val1Lbl = new JLabel("");
		val1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		val1Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		val1Lbl.setBounds(0, 0, 112, 25);
		frmMyCalculator.getContentPane().add(val1Lbl);

		JLabel val2Lbl = new JLabel("");
		val2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
		val2Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		val2Lbl.setBounds(167, 0, 112, 25);
		frmMyCalculator.getContentPane().add(val2Lbl);

		JLabel resultLbl = new JLabel("");
		resultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		resultLbl.setBounds(332, 0, 159, 25);
		frmMyCalculator.getContentPane().add(resultLbl);

		JButton generateBtn = new JButton("Generate");
		generateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n1, n2;
				Random random = new Random();
				n1 = random.nextInt(11); // as 10 is inclusive
				n2 = random.nextInt(11);
				val1Lbl.setText(n1 + "");
				val2Lbl.setText(n2 + "");
			}
		});
		generateBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		generateBtn.setBounds(0, 118, 168, 40);
		frmMyCalculator.getContentPane().add(generateBtn);

		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n1 = Integer.parseInt(val1Lbl.getText());
				int n2 = Integer.parseInt(val2Lbl.getText());
				resultLbl.setText(n1 + "+" + n2 + "=" + (n1 + n2));
			}
		});
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addBtn.setBounds(167, 118, 168, 40);
		frmMyCalculator.getContentPane().add(addBtn);

		JButton subtractBtn = new JButton("Subtract");
		subtractBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n1 = Integer.parseInt(val1Lbl.getText());
				int n2 = Integer.parseInt(val2Lbl.getText());
				resultLbl.setText(n1 + "-" + n2 + "=" + (n1 - n2));
			}
		});
		subtractBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		subtractBtn.setBounds(332, 118, 168, 40);
		frmMyCalculator.getContentPane().add(subtractBtn);

		JLabel lblval1 = new JLabel("VALUE 1");
		lblval1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblval1.setHorizontalAlignment(SwingConstants.CENTER);
		lblval1.setBounds(15, 82, 137, 33);
		frmMyCalculator.getContentPane().add(lblval1);

		JLabel lblValue2 = new JLabel("VALUE 2");
		lblValue2.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValue2.setBounds(180, 82, 137, 33);
		frmMyCalculator.getContentPane().add(lblValue2);

		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResult.setBounds(339, 82, 137, 33);
		frmMyCalculator.getContentPane().add(lblResult);
		frmMyCalculator.repaint();
	}

}
