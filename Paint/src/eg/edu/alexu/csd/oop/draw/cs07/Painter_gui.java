package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

public class Painter_gui extends JFrame {

	private JPanel contentPane;
	
	public Painter_gui() {
		setForeground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Enter Now !!");
		btnNewButton.setFont(new Font("Viner Hand ITC", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.MAGENTA);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main_list m = new Main_list();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(139, 192, 135, 58);
		contentPane.add(btnNewButton);
		
		JLabel lblWelcomeToOur = new JLabel("Welcome to Paint Program");
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblWelcomeToOur.setForeground(Color.BLUE);
		lblWelcomeToOur.setBounds(72, 24, 268, 50);
		contentPane.add(lblWelcomeToOur);
	}
}
