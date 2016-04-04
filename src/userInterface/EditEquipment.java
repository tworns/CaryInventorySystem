package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditEquipment {

	private JFrame frmEditEntry;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEquipment window = new EditEquipment();
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
	public EditEquipment() {
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
		textField.setBounds(186, 68, 116, 22);
		frmEditEntry.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 161, 116, 22);
		frmEditEntry.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(186, 132, 116, 22);
		frmEditEntry.getContentPane().add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Value", "Game", "Food", "Tools", "Other"}));
		comboBox.setBounds(186, 100, 116, 22);
		frmEditEntry.getContentPane().add(comboBox);
	}
}
