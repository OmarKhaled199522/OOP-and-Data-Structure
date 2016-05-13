package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remover extends JFrame {

	private JPanel contentPane;
	private JTextField obName;
	MyDrawingEngine my = MyDrawingEngine.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remover frame = new Remover();
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
	public Remover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Ok!");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = obName.getText();
				int pos = my.getMapp().get(s);
				my.arr[pos] = null;
				Draw q = new Draw(my);
				q.setVisible(true);
			}
		});
		btnOk.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 14));
		btnOk.setBounds(135, 127, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblEnterTheShape = new JLabel("Enter The Shape Name:");
		lblEnterTheShape.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		lblEnterTheShape.setBounds(20, 11, 193, 14);
		contentPane.add(lblEnterTheShape);
		
		JButton button = new JButton("<- Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Main_list mm = new Main_list();
				mm.setVisible(true);
				
			}
		});
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		button.setBounds(10, 128, 89, 23);
		contentPane.add(button);
		
		obName = new JTextField();
		obName.setBounds(73, 50, 86, 20);
		contentPane.add(obName);
		obName.setColumns(10);
	}
}
