package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

import actualItems.DatabaseManager;
import actualItems.Equipment;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewEquipmentAdd {

	public JFrame frmAddEquipment;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEquipmentAdd window = new NewEquipmentAdd();
					window.frmAddEquipment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewEquipmentAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddEquipment = new JFrame();
		frmAddEquipment.setTitle("Add Equipment");
		frmAddEquipment.setBounds(100, 100, 370, 338);
		frmAddEquipment.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddEquipment.getContentPane().setLayout(null);
		

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmAddEquipment.dispose();
				
			}
		});
		btnCancel.setBounds(201, 244, 97, 25);
		frmAddEquipment.getContentPane().add(btnCancel);
		
		JLabel lblAddNewEquipment = new JLabel("Add New Equipment");
		lblAddNewEquipment.setFont(new Font("Georgia", Font.BOLD, 16));
		lblAddNewEquipment.setBounds(83, 23, 186, 19);
		frmAddEquipment.getContentPane().add(lblAddNewEquipment);
		
		textField = new JTextField();
		textField.setBounds(179, 78, 116, 22);
		frmAddEquipment.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEquipmentName = new JLabel("Equipment Name:");
		lblEquipmentName.setBounds(40, 81, 104, 16);
		frmAddEquipment.getContentPane().add(lblEquipmentName);
		
		JLabel lblNewLabel = new JLabel("Equipment Type:");
		lblNewLabel.setBounds(40, 113, 104, 16);
		frmAddEquipment.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Value", "Game", "Food", "Tools", "Other"}));
		comboBox.setBorder(null);
		comboBox.setBounds(179, 110, 116, 22);
		frmAddEquipment.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 171, 116, 22);
		frmAddEquipment.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setBounds(91, 174, 53, 16);
		frmAddEquipment.getContentPane().add(lblSection);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(179, 142, 116, 22);
		frmAddEquipment.getContentPane().add(spinner);
		
		JLabel lblBoxNumber = new JLabel("Box Number:");
		lblBoxNumber.setBounds(63, 145, 81, 16);
		frmAddEquipment.getContentPane().add(lblBoxNumber);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String section = textField_1.getText();
				int available = 0; 
				int repair = 0;
				int box = (int) spinner.getValue();
				int type = comboBox.getSelectedIndex();
				if((name == null || name.equalsIgnoreCase("")) || (section == null || section.equalsIgnoreCase("") )
						|| comboBox.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(frmAddEquipment, "One or more fields left empty. Please give each field a value.");
				}
				else{ 
					
					System.out.println("box = "+box);
					System.out.println("type = "+type);
					switch (type) {
						case 1: type = 0;
						break;
						case 2: type = 1; 
							break;
						case 3: type = 2; 
						break;
						case 4: type = 3; //If more types needed, more cases needed.
						break;
					}
					System.out.println("Type actual = "+type);
					DatabaseManager pam = new DatabaseManager("equipment");
					Equipment e = new Equipment(0,box, available , repair, type, section, name);
					pam.addEquipment(e);
					frmAddEquipment.dispose();
				}
				
			}
		});
		btnSave.setBounds(52, 244, 97, 25);
		frmAddEquipment.getContentPane().add(btnSave);
	}
}
