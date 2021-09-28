import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JavaExam {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new JavaExam();
	}

	/**
	 * Create the application.
	 */
	public JavaExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("EXAM");
		frame.setVisible(true);
		frame.setBounds(100, 100, 1058, 678);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel javaExamLbl = new JLabel("JAVA EXAM");
		javaExamLbl.setFont(new Font("Times New Roman", Font.BOLD, 50));
		javaExamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		javaExamLbl.setBounds(331, 16, 335, 58);
		frame.getContentPane().add(javaExamLbl);

		JLabel q1Lbl = new JLabel(
				"1-What is the process of defining two or more methods within same class that have same name but different parameters declaration?");
		q1Lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		q1Lbl.setBounds(32, 70, 968, 40);
		frame.getContentPane().add(q1Lbl);

		JRadioButton q1aRButton = new JRadioButton("method overloading");
		q1aRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q1aRButton.setBounds(74, 99, 926, 30);
		frame.getContentPane().add(q1aRButton);

		JRadioButton q1bRButton = new JRadioButton("method overriding");
		q1bRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q1bRButton.setBounds(74, 128, 926, 30);
		frame.getContentPane().add(q1bRButton);

		JLabel q2Lbl = new JLabel("2-Which one is a valid declaration of a boolean?");
		q2Lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		q2Lbl.setBounds(32, 156, 968, 40);
		frame.getContentPane().add(q2Lbl);

		JRadioButton q2aRButton = new JRadioButton("boolean b1=false;");
		q2aRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q2aRButton.setBounds(74, 192, 926, 30);
		frame.getContentPane().add(q2aRButton);

		JRadioButton q2bRButton = new JRadioButton("boolean b2= 'false';");
		q2bRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q2bRButton.setBounds(74, 219, 926, 30);
		frame.getContentPane().add(q2bRButton);

		JLabel q3Lbl = new JLabel(
				"3-Which one of the following will declare an array and initialize it with five numbers?");
		q3Lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		q3Lbl.setBounds(32, 251, 968, 40);
		frame.getContentPane().add(q3Lbl);

		JRadioButton q3aRButton = new JRadioButton("int a []= new int[5];");
		q3aRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q3aRButton.setBounds(74, 285, 926, 30);
		frame.getContentPane().add(q3aRButton);

		JRadioButton q3bRButton = new JRadioButton("int [] a= {23,22,21,20,19};");
		q3bRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q3bRButton.setBounds(74, 313, 926, 30);
		frame.getContentPane().add(q3bRButton);

		JLabel q4Lbl = new JLabel("4-Which of the following are java reserved words?");
		q4Lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		q4Lbl.setBounds(32, 343, 968, 40);
		frame.getContentPane().add(q4Lbl);

		JRadioButton q4aRButton = new JRadioButton("run");
		q4aRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q4aRButton.setBounds(74, 381, 926, 30);
		frame.getContentPane().add(q4aRButton);

		JRadioButton q4bRButton = new JRadioButton("import");
		q4bRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q4bRButton.setBounds(74, 408, 926, 30);
		frame.getContentPane().add(q4bRButton);

		JLabel q5Lbl = new JLabel("5-Which of these keywords must be used to inherit a class?");
		q5Lbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		q5Lbl.setBounds(32, 436, 968, 40);
		frame.getContentPane().add(q5Lbl);

		JRadioButton q5aRButton = new JRadioButton("super");
		q5aRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q5aRButton.setBounds(74, 474, 926, 30);
		frame.getContentPane().add(q5aRButton);

		JRadioButton q5bRButton = new JRadioButton("extends");
		q5bRButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		q5bRButton.setBounds(74, 500, 926, 30);
		frame.getContentPane().add(q5bRButton);

		ButtonGroup q1Group = new ButtonGroup();
		q1Group.add(q1aRButton);
		q1Group.add(q1bRButton);

		ButtonGroup q2Group = new ButtonGroup();
		q2Group.add(q2aRButton);
		q2Group.add(q2bRButton);

		ButtonGroup q3Group = new ButtonGroup();
		q3Group.add(q3aRButton);
		q3Group.add(q3bRButton);

		ButtonGroup q4Group = new ButtonGroup();
		q4Group.add(q4aRButton);
		q4Group.add(q4bRButton);

		ButtonGroup q5Group = new ButtonGroup();
		q5Group.add(q5aRButton);
		q5Group.add(q5bRButton);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int grade = 0;
				if (q1aRButton.isSelected())
					grade++;
				if (q2aRButton.isSelected())
					grade++;
				if (q3bRButton.isSelected())
					grade++;
				if (q4bRButton.isSelected())
					grade++;
				if (q5bRButton.isSelected())
					grade++;

				if (grade >= 3)
					JOptionPane.showMessageDialog(frame,
							"Congratulations! You passed the exam, your grade is " + grade + "/5");
				else
					JOptionPane.showMessageDialog(frame,
							"Sorry! You failed the exam, your grade is " + grade + "/5");
			}
		});
		submitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		submitBtn.setBounds(436, 561, 115, 29);
		frame.getContentPane().add(submitBtn);
		frame.repaint();
	}
}
