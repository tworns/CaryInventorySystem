package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import actualItems.DatabaseManager;
import actualItems.Equipment;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditEquipment {

	private JFrame frmEditEntry;
	private JTextField textField;
	private JTextField textField_1;
	public String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String k = "Dave";
					EditEquipment window = new EditEquipment(k);
					window.frmEditEntry.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditEquipment(String name) {
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditEntry = new JFrame();
		frmEditEntry.setTitle("Edit Entry");
		frmEditEntry.setBounds(100, 100, 380, 302);
		frmEditEntry.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditEntry.getContentPane().setLayout(null);
		DatabaseManager kevin = new DatabaseManager("equipment");
		Equipment matt = kevin.retrieveEquipment(name);
		JLabel lblEditEquipmentEntry = new JLabel("Edit Equipment Entry");
		lblEditEquipmentEntry.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEditEquipmentEntry.setBounds(96, 13, 186, 19);
		frmEditEntry.getContentPane().add(lblEditEquipmentEntry);
		
		JLabel label_1 = new JLabel("Equipment Name:");
		label_1.setBounds(53, 71, 104, 16);
		frmEditEntry.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Equipment Type:");
		label_2.setBounds(53, 103, 104, 16);
		frmEditEntry.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Box Number:");
		label_3.setBounds(76, 135, 81, 16);
		frmEditEntry.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Section:");
		label_4.setBounds(104, 164, 53, 16);
		frmEditEntry.getContentPane().add(label_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(186, 68, 116, 22);
		frmEditEntry.getContentPane().add(textField);

		textField.setText(matt.getName());
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 161, 116, 22);
		frmEditEntry.getContentPane().add(textField_1);
		textField_1.setText(matt.getSection());
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setValue(matt.getBox());
		spinner.setBounds(186, 132, 116, 22);
		frmEditEntry.getContentPane().add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Value", "Game", "Food", "Tools", "Other"}));
		comboBox.setBounds(186, 100, 116, 22);
		int type = matt.getType();
		if(type == 1){ 
			comboBox.setSelectedIndex(1);
		}
		if(type == 2) { 
			comboBox.setSelectedIndex(2);
		}
		if(type == 3) { 
			comboBox.setSelectedIndex(3);
		}
		if(type == 4){ 
			comboBox.setSelectedIndex(4);
		}
		else { 
			comboBox.setSelectedIndex(0);
		}
		frmEditEntry.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String section = textField_1.getText();
				int box = (int) spinner.getValue();
				int type = comboBox.getSelectedIndex();
				if(type == 0){ 
					JOptionPane.showMessageDialog(frmEditEntry, "One or more fields left empty. Please give each field a value.");
				}
				Equipment edit = new Equipment(matt.getID(), box, matt.getStatus() , matt.getRepair(), type, section, name);
				kevin.deleteEquipment(matt);
				kevin.addEquipment(edit); //TODO SHOULD NAME BE UP FOR EDIT??
			}
		});
		btnNewButton.setBounds(53, 217, 97, 25);
		frmEditEntry.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEditEntry.dispose();
			}
		});
		btnNewButton_1.setBounds(205, 217, 97, 25);
		frmEditEntry.getContentPane().add(btnNewButton_1);
	}
}
