package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaverLoader extends JFrame {

	private JPanel contentPane;
	private JTextField path;
	MyDrawingEngine my = MyDrawingEngine.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaverLoader frame = new SaverLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaverLoader() {
		setForeground(Color.PINK);
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterThePath = new JLabel("Enter The path Name:");
		lblEnterThePath.setFont(new Font("MV Boli", Font.PLAIN, 16));
		lblEnterThePath.setBounds(21, 11, 187, 14);
		contentPane.add(lblEnterThePath);
		
		JLabel lblxmljson = new JLabel(".XML / .JSON");
		lblxmljson.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblxmljson.setBounds(68, 36, 91, 14);
		contentPane.add(lblxmljson);
		
		path = new JTextField();
		path.setText("");
		path.setBounds(68, 75, 86, 20);
		contentPane.add(path);
		path.setColumns(10);
		
		JButton sav = new JButton("Save");
		sav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				my.save(path.getText());
			}
		});
		sav.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		sav.setBounds(10, 118, 89, 23);
		contentPane.add(sav);
		
		JButton lod = new JButton("LOad");
		lod.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		lod.setBounds(135, 119, 89, 23);
		contentPane.add(lod);
		
		JButton bak = new JButton("<- Back");
		bak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main_list m = new Main_list();
				m.setVisible(true);
			}
		});
		bak.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		bak.setBounds(70, 166, 89, 23);
		contentPane.add(bak);
		
		lod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				my.load(path.getText());
				Draw q = new Draw(my);
				q.setVisible(true);
			}
		});
	}
}
