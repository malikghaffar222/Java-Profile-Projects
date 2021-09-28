import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.management.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ImageWindow {

	private JFrame frmImageWindow;
	private JLabel imgLbl;
	private JLabel imgName;
	private JButton prevBtn, nextBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageWindow window = new ImageWindow();
					window.frmImageWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ImageWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageWindow = new JFrame();
		frmImageWindow.setVisible(true);
		frmImageWindow.setTitle("Image Window");
		frmImageWindow.setResizable(false);
		frmImageWindow.setBounds(100, 100, 821, 590);
		frmImageWindow.setLocationRelativeTo(null);
		frmImageWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImageWindow.getContentPane().setLayout(null);
		MyImageQueue queueOfImages = new MyImageQueue();
		// adding images to queue
		for (int i = 1; i <= 10; i++) {
			queueOfImages.add(new ImageIcon(getClass().getResource(i + ".jpg")));
		}
		Node images = queueOfImages.getHead();

		imgLbl = new JLabel("");
		imgLbl.setBounds(55, 57, 705, 477);
		imgLbl.setIcon(resizeImg(images.next.img));
		frmImageWindow.getContentPane().add(imgLbl);

		imgName = new JLabel("1.jpg");
		imgName.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		imgName.setHorizontalAlignment(SwingConstants.CENTER);
		imgName.setBounds(351, 16, 69, 37);
		frmImageWindow.getContentPane().add(imgName);

		prevBtn = new JButton("");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				images.next = images.next.prev;
				if (images.next == queueOfImages.getHead())
					images.next = images.next.prev;
				imgLbl.setIcon(resizeImg(images.next.img));
				int counter = Integer.parseInt(imgName.getText().substring(0, imgName.getText().indexOf('.')));
				if (counter == 1)
					counter = 10;
				else
					counter--;
				imgName.setText(counter + ".jpg");
				frmImageWindow.repaint();
			}
		});

		prevBtn.setBounds(15, 242, 25, 29);
		prevBtn.setIcon(new ImageIcon(getClass().getResource("previous.png")));
		frmImageWindow.getContentPane().add(prevBtn);

		nextBtn = new JButton("");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				images.next = images.next.next;
				if (images.next == queueOfImages.getHead())
					images.next = images.next.next;
				imgLbl.setIcon(resizeImg(images.next.img));
				int counter = Integer.parseInt(imgName.getText().substring(0, imgName.getText().indexOf('.')));
				if (counter == 10)
					counter = 1;
				else
					counter++;

				imgName.setText(counter + ".jpg");
				frmImageWindow.repaint();
			}
		});
		nextBtn.setBounds(775, 242, 25, 29);
		nextBtn.setIcon(new ImageIcon(getClass().getResource("next.png")));
		frmImageWindow.getContentPane().add(nextBtn);

	}

	public ImageIcon resizeImg(ImageIcon img) {
		Image newImage = img.getImage().getScaledInstance(imgLbl.getWidth(), imgLbl.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}
}
