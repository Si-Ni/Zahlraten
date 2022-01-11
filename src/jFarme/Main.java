package jFarme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bgStufe = new ButtonGroup();
	private ButtonGroup bgModus = new ButtonGroup();
	private JRadioButton rdbtnLeicht;
	private JRadioButton rdbtnMittel;
	private JRadioButton rdbtnSchwer;
	private JRadioButton rdbtnEinzelspieler;
	private JRadioButton rdbtnZweispieler;
	private JButton btnEnde;
	private JButton btnNeueZahl;
	private int eingabe, versuch, ganzzahl;
	private Random zufall = new Random();
	private JLabel lblVersuch;
	private JLabel lblAnweisung;
	private JSpinner spinnerEingabe;
	private JButton btnRaten;
	private JLabel lblErgebnis;
	private JButton btnAbbrechen;
	private JSpinner spinnerEingabe2;
	private JButton btnBestaetige;
	private JLabel lblStufeW‰hlen;
	private JButton btnWechseln;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZahlraten = new JLabel("Zahlraten");
		lblZahlraten.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblZahlraten.setBounds(219, 11, 114, 30);
		contentPane.add(lblZahlraten);
		
		lblAnweisung = new JLabel("Bitte w\u00E4hlen Sie eine Zahl von 1 bis 100:");
		lblAnweisung.setBounds(37, 55, 310, 14);
		contentPane.add(lblAnweisung);
		
		rdbtnLeicht = new JRadioButton("LEICHT");
		rdbtnLeicht.setBounds(409, 93, 109, 23);
		contentPane.add(rdbtnLeicht);
		
		lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(59, 119, 172, 14);
		contentPane.add(lblErgebnis);
		
		rdbtnMittel = new JRadioButton("MITTEL");
		rdbtnMittel.setSelected(true);
		rdbtnMittel.setBounds(409, 121, 109, 23);
		contentPane.add(rdbtnMittel);
		
		rdbtnSchwer = new JRadioButton("SCHWER");
		rdbtnSchwer.setBounds(409, 149, 109, 23);
		contentPane.add(rdbtnSchwer);
		
		rdbtnEinzelspieler = new JRadioButton("EINZELSPIELER");
		rdbtnEinzelspieler.setSelected(true);
		rdbtnEinzelspieler.setBounds(409, 227, 109, 23);
		contentPane.add(rdbtnEinzelspieler);
		
		rdbtnZweispieler = new JRadioButton("ZWEISPIELER");
		rdbtnZweispieler.setBounds(409, 253, 109, 23);
		contentPane.add(rdbtnZweispieler);
		
		lblStufeW‰hlen = new JLabel("W\u00E4hlen Sie eine Stufe und dr\u00FCcken Sie Neue Zahl");
		lblStufeW‰hlen.setBounds(37, 298, 296, 14);
		contentPane.add(lblStufeW‰hlen);
		
		JTextPane txtpnErgebnis = new JTextPane();
		txtpnErgebnis.setEditable(false);
		txtpnErgebnis.setText("ERGEBNIS");
		txtpnErgebnis.setBounds(37, 91, 194, 51);
		contentPane.add(txtpnErgebnis);
		
		spinnerEingabe = new JSpinner();
		spinnerEingabe.setBounds(37, 172, 89, 20);
		contentPane.add(spinnerEingabe);
		
		btnNeueZahl = new JButton("Neue Zahl");
		btnNeueZahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				versuch = 0;
				lblVersuch.setText("Das ist der " + versuch + ". Versuch");
				if (rdbtnLeicht.isSelected()) {
					lblAnweisung.setText("Bitte w‰hlen Sie eine Zahl von 1 bis 10");
					ganzzahl = 1 + zufall.nextInt(10);
					spinnerEingabe.setValue(5);
				}else if(rdbtnMittel.isSelected()) {
					lblAnweisung.setText("Bitte w‰hlen Sie eine Zahl von 1 bis 100");
					ganzzahl = 1 + zufall.nextInt(100);
					spinnerEingabe.setValue(50);
				}else if(rdbtnSchwer.isSelected()) {
					lblAnweisung.setText("Bitte w‰hlen Sie eine Zahl von 1 bis 1000");
					ganzzahl = 1 + zufall.nextInt(1000);
					spinnerEingabe.setValue(500);
				}
			btnRaten.setEnabled(true);
			btnNeueZahl.setEnabled(false);
			}
		});
		btnNeueZahl.setBounds(37, 209, 108, 23);
		contentPane.add(btnNeueZahl);
		
		btnRaten = new JButton("Raten");
		btnRaten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = spinnerEingabe.getValue().toString();
				eingabe = Integer.parseInt(value);
				versuch++;
				lblVersuch.setText("Das ist der " + versuch + ". Versuch");
					if(eingabe > ganzzahl) {
						lblErgebnis.setText("Zahl zu groﬂ");
					}else if (eingabe < ganzzahl) {
						lblErgebnis.setText("Zahl zu klein");
					}else if (rdbtnEinzelspieler.isSelected() && eingabe == ganzzahl){
						lblErgebnis.setText("RICHTIG! Du hast es erraten");
						btnRaten.setEnabled(false);
						btnNeueZahl.setEnabled(true);
					}else if (rdbtnZweispieler.isSelected() && eingabe == ganzzahl) {
						lblErgebnis.setText("RICHTIG! Du hast es erraten");
						btnRaten.setEnabled(false);
						spinnerEingabe2.setVisible(true);
						btnBestaetige.setEnabled(true);
					}
			}
		});
		btnRaten.setEnabled(false);
		btnRaten.setBounds(155, 209, 108, 23);
		contentPane.add(btnRaten);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEinzelspieler.isSelected())	{
					versuch = 0;
					lblVersuch.setText("Das ist der " + versuch + ". Versuch");
					btnNeueZahl.setEnabled(true);
					btnRaten.setEnabled(false);
				}else if (rdbtnZweispieler.isSelected()) {
					versuch = 0;
					lblVersuch.setText("Das ist der " + versuch + ". Versuch");
					btnRaten.setEnabled(false);
					btnBestaetige.setEnabled(true);
					spinnerEingabe2.setVisible(true);
				}
			}
		});
		btnAbbrechen.setBounds(270, 209, 108, 23);
		contentPane.add(btnAbbrechen);
		
		btnEnde = new JButton("Schlie\u00DFen");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(429, 323, 89, 23);
		contentPane.add(btnEnde);
		
		JEditorPane dtrpnSpe = new JEditorPane();
		dtrpnSpe.setEditable(false);
		dtrpnSpe.setText("Spielstufe");
		dtrpnSpe.setBounds(390, 70, 148, 124);
		contentPane.add(dtrpnSpe);
		
		bgStufe.add(rdbtnLeicht);
		bgStufe.add(rdbtnMittel);
		bgStufe.add(rdbtnSchwer);
		bgModus.add(rdbtnEinzelspieler);
		bgModus.add(rdbtnZweispieler);
		
		lblVersuch = new JLabel("");
		lblVersuch.setBounds(59, 262, 262, 14);
		contentPane.add(lblVersuch);
		
		spinnerEingabe2 = new JSpinner();
		spinnerEingabe2.setBounds(182, 172, 89, 20);
		spinnerEingabe2.setVisible(false);
		contentPane.add(spinnerEingabe2);
		
		btnBestaetige = new JButton("Best\u00E4tige");
		btnBestaetige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = spinnerEingabe2.getValue().toString();
				ganzzahl = Integer.parseInt(value);
				spinnerEingabe2.setVisible(false);
				btnBestaetige.setEnabled(false);
				btnRaten.setEnabled(true);
				versuch = 0;
				lblVersuch.setText("Das ist der " + versuch + ". Versuch");
				
			}
		});
		btnBestaetige.setBounds(281, 171, 89, 23);
		btnBestaetige.setVisible(false);
		contentPane.add(btnBestaetige);
		
		btnWechseln = new JButton("Wechseln");
		btnWechseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnEinzelspieler.isSelected()) {
					spinnerEingabe2.setVisible(false);
					btnBestaetige.setVisible(false);
					rdbtnLeicht.setVisible(true);
					rdbtnMittel.setVisible(true);
					rdbtnSchwer.setVisible(true);
					lblStufeW‰hlen.setVisible(true);
					btnNeueZahl.setVisible(true);
					rdbtnMittel.setSelected(true);
					spinnerEingabe.setValue(50);
					lblAnweisung.setText("Bitte w‰hlen Sie eine Zahl von 1 bis 100");
				}else if (rdbtnZweispieler.isSelected()) {
					spinnerEingabe2.setVisible(true);
					btnBestaetige.setVisible(true);
					rdbtnLeicht.setVisible(false);
					rdbtnMittel.setVisible(false);
					rdbtnSchwer.setVisible(false);
					lblStufeW‰hlen.setVisible(false);
					btnNeueZahl.setVisible(false);
					lblAnweisung.setText("Versuchen Sie die zahl ihres Mitspielers zu erraten");
				}
			}
		});
		btnWechseln.setBounds(419, 283, 89, 23);
		contentPane.add(btnWechseln);
		
		JEditorPane dtrpnModus = new JEditorPane();
		dtrpnModus.setEditable(false);
		dtrpnModus.setText("MODUS");
		dtrpnModus.setBounds(390, 205, 148, 107);
		contentPane.add(dtrpnModus);
		
	}
}
