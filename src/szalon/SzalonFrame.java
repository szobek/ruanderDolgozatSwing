package szalon;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class SzalonFrame {

	private JFrame frame;
	
	private DefaultListModel model;
	private JList<Ora> orak = new JList();
private List<Ora> oraLista = new ArrayList<Ora>();	
	
	private JTextField textFieldNev;
	private JTextField textFieldAr;
	private JButton btnSave;
	private JComboBox comboBoxVizallo;
	private JComboBox comboBoxTipus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SzalonFrame window = new SzalonFrame();
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
	public SzalonFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] opciok = { "Igen", "Nem" };
				if (JOptionPane.showOptionDialog(frame, "Biztos kilép?", "Kilépés", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciok, opciok[1]) == JOptionPane.YES_OPTION) {

					System.exit(0);

				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Óraszalon");
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 40, 158, 187);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Lista");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(227, 15, 162, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNev = new JLabel("N\u00E9v");
		lblNev.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblNev);
		
		JLabel lblAr = new JLabel("\u00C1r");
		lblAr.setBounds(10, 58, 46, 14);
		frame.getContentPane().add(lblAr);
		
		JLabel lblVizallo = new JLabel("V\u00EDz\u00E1ll\u00F3");
		lblVizallo.setBounds(10, 98, 46, 14);
		frame.getContentPane().add(lblVizallo);
		
		JLabel lblTipus = new JLabel("T\u00EDpus");
		lblTipus.setBounds(10, 141, 46, 14);
		frame.getContentPane().add(lblTipus);
		
		textFieldNev = new JTextField();
		textFieldNev.setBounds(73, 12, 86, 20);
		frame.getContentPane().add(textFieldNev);
		textFieldNev.setColumns(10);
		
		textFieldAr = new JTextField();
		textFieldAr.setBounds(73, 55, 86, 20);
		frame.getContentPane().add(textFieldAr);
		textFieldAr.setColumns(10);
		
		comboBoxTipus = new JComboBox();
		comboBoxTipus.setModel(new DefaultComboBoxModel(OraTipusok.values()));
		comboBoxTipus.setBounds(73, 137, 86, 22);
		frame.getContentPane().add(comboBoxTipus);
		
		comboBoxVizallo = new JComboBox();
		comboBoxVizallo.setModel(new DefaultComboBoxModel(new String[] {"Igen", "Nem"}));
		comboBoxVizallo.setBounds(83, 94, 76, 22);
		frame.getContentPane().add(comboBoxVizallo);
		
		btnSave = new JButton("Ment\u00E9s");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setEnabled(false);
				String nev = textFieldNev.getText();
				int ar = Integer.parseInt(textFieldAr.getText());
				String tipus = comboBoxTipus.getSelectedItem().toString();
				Boolean vizallo=Boolean.parseBoolean( comboBoxVizallo.getSelectedItem().toString());
				OraTipusok.convertToEnum(tipus);
				oraLista.add(new Ora(nev,OraTipusok.convertToEnum(tipus),ar,vizallo)); 
				model = new DefaultListModel<Ora>();
				model.addAll(oraLista);
				orak.setModel(model);
				
				//DBHandling.insertData(nev,ar,vizallo,tipus);
				setDefaultValues();
			}
		});
		btnSave.setBounds(70, 180, 89, 23);
		frame.getContentPane().add(btnSave);
	}
	
	private void setDefaultValues() {
		
		textFieldNev.setText("");
		textFieldAr.setText("");
		comboBoxTipus.setSelectedIndex(0);
		comboBoxVizallo.setSelectedIndex(0);
		btnSave.setEnabled(true);
	}
}
