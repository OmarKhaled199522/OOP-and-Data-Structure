package eg.edu.alexu.csd.oop.draw.cs07;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel; // Exception if removed!
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main_list extends JFrame {

	private JPanel contentPane;
	private MyDrawingEngine my = MyDrawingEngine.getInstance();
	
	
	public Main_list() {
		setResizable(false);
		setForeground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseOption = new JLabel("Choose Option:");
		lblChooseOption.setForeground(Color.RED);
		lblChooseOption.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblChooseOption.setBounds(10, 10, 137, 50);
		contentPane.add(lblChooseOption);
		
		JButton add = new JButton("Add Shape");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Adding_List add = new Adding_List(true);
				add.setVisible(true);
			}
		});
		add.setBounds(125, 75, 105, 50);
		contentPane.add(add);
		
		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				my.undo();
				Draw q = new Draw(my);
				q.setVisible(true);
			}
		});
		undo.setBounds(23, 194, 89, 43);
		contentPane.add(undo);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SaverLoader sd = new SaverLoader();
				sd.setVisible(true);
			}
		});
		save.setBounds(76, 475, 89, 37);
		contentPane.add(save);
		
		JButton remove = new JButton("Remove Shape");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Remover remo = new Remover();
				remo.setVisible(true);
			}
		});
		remove.setBounds(343, 75, 134, 50);
		contentPane.add(remove);
		
		JButton redo = new JButton("Redo");
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				my.redo();
				Draw q = new Draw(my);
				q.setVisible(true);
			}
		});
		redo.setBounds(226, 307, 89, 43);
		contentPane.add(redo);
		
		JButton update = new JButton("Update Shape");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Adding_List up = new Adding_List(false);
				up.setVisible(true);
			}
		});
		update.setBounds(426, 194, 127, 43);
		contentPane.add(update);
		
		JButton load = new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				SaverLoader sd = new SaverLoader();
				sd.setVisible(true);
			}
		});
		load.setBounds(388, 475, 89, 37);
		contentPane.add(load);
		
		JButton plugins = new JButton("Add Plugin Shape");
		plugins.setFont(new Font("Traditional Arabic", Font.PLAIN, 11));
		plugins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*dispose();
				Shape circ = new Circle(); // it should be plugin
				Add_Plugins plug = new Add_Plugins(circ);
				plug.setVisible(true);*/
				
				my.getSupportedShapes();
				
				/*Iterator it = mapshape.entrySet().iterator();
				 
			    while (it.hasNext()) {
			    	
			        Map.Entry pair = (Map.Entry)it.next();
			        String proberties = (String) pair.getValue();
			        String input = JOptionPane.showInputDialog(proberties);
			        
			    }*/
			}
		});
		
		plugins.setBounds(220, 476, 115, 37);
		contentPane.add(plugins);
		
		
	}
}
