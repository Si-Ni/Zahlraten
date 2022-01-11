package jFarme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Code extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAusgabe;
	public static String code = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code frame = new Code();
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
	public Code() {
		setTitle("passcode");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(564, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnweisung = new JLabel("Geben Sie den richtigen Code ein, um das Programm zu starten !");
		lblAnweisung.setBounds(116, 23, 370, 14);
		contentPane.add(lblAnweisung);
		
		tfAusgabe = new JTextField();
		tfAusgabe.setEditable(false);
		tfAusgabe.setBounds(233, 58, 89, 20);
		contentPane.add(tfAusgabe);
		tfAusgabe.setColumns(10);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "1";
					tfAusgabe.setText(code);
				}
			}
		});
		btn1.setBounds(134, 105, 89, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "2";
					tfAusgabe.setText(code);
				}
			}
		});
		btn2.setBounds(233, 105, 89, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "3";
					tfAusgabe.setText(code);
				}
			}
		});
		btn3.setBounds(332, 105, 89, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "4";
					tfAusgabe.setText(code);
				}
			}
		});
		btn4.setBounds(134, 149, 89, 23);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "5";
					tfAusgabe.setText(code);
				}
			}
		});
		btn5.setBounds(233, 149, 89, 23);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "6";
					tfAusgabe.setText(code);
				}
			}
		});
		btn6.setBounds(332, 149, 89, 23);
		contentPane.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "7";
					tfAusgabe.setText(code);
				}
			}
		});
		btn7.setBounds(134, 191, 89, 23);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "8";
					tfAusgabe.setText(code);
				}
			}
		});
		btn8.setBounds(233, 191, 89, 23);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "9";
					tfAusgabe.setText(code);
				}
			}
		});
		btn9.setBounds(332, 191, 89, 23);
		contentPane.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.length() < 4) {
					code = code + "0";
					tfAusgabe.setText(code);
				}
			}
		});
		btn0.setBounds(233, 235, 89, 23);
		contentPane.add(btn0);
		
		JButton btnBestaetige = new JButton("Best\u00E4tige");
		btnBestaetige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(code.equals("1740")){
					new Main();
				}else {
					JOptionPane.showMessageDialog(null, "Der eingegebene Code ist falsch");
				}
			}
		});
		btnBestaetige.setBounds(449, 323, 89, 23);
		contentPane.add(btnBestaetige);
		
		JButton btnLoeschen = new JButton("l\u00F6schen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				code = "";
				tfAusgabe.setText(code);
			}
		});
		btnLoeschen.setBounds(332, 235, 89, 23);
		contentPane.add(btnLoeschen);
	}
}
