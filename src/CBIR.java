import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
public class CBIR {

	private JFrame frame;
	private JTextField txtPasteYourBarcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CBIR window = new CBIR();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CBIR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cbirLbl = new JLabel("Content-Based Image Retrieval (CBIR) Using Barcode");
		cbirLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cbirLbl.setFont(new Font("Calibri", Font.BOLD, 25));
		cbirLbl.setBounds(15, 16, 588, 43);
		frame.getContentPane().add(cbirLbl);
		
		txtPasteYourBarcode = new JTextField();
		txtPasteYourBarcode.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPasteYourBarcode.setText("Paste your barcode path here.");
		txtPasteYourBarcode.setBounds(62, 70, 352, 33);
		frame.getContentPane().add(txtPasteYourBarcode);
		txtPasteYourBarcode.setColumns(10);
		
		JButton readBarcodeBtn = new JButton("Read Barcode");
		readBarcodeBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		readBarcodeBtn.setBounds(441, 70, 146, 33);
		frame.getContentPane().add(readBarcodeBtn);
		
		JLabel imgNameLbl = new JLabel("0");
		imgNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		imgNameLbl.setBounds(188, 119, 197, 25);
		frame.getContentPane().add(imgNameLbl);
		
		JLabel barcodeStatusLbl = new JLabel("");
		barcodeStatusLbl.setHorizontalAlignment(SwingConstants.LEFT);
		barcodeStatusLbl.setBounds(240, 206, 197, 33);
		frame.getContentPane().add(barcodeStatusLbl);
		
		JLabel imgLbl = new JLabel("jLabel1");
		imgLbl.setHorizontalAlignment(SwingConstants.CENTER);
		imgLbl.setBounds(30, 150, 200, 170);
		frame.getContentPane().add(imgLbl);
	}
}
