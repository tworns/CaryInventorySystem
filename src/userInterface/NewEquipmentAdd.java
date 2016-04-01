package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

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
		frmAddEquipment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddEquipment.getContentPane().setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(52, 244, 97, 25);
		frmAddEquipment.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Value", "0", "1", "2", "3", "4", "5"}));
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
		spinner.setBounds(179, 142, 116, 22);
		frmAddEquipment.getContentPane().add(spinner);
		
		JLabel lblBoxNumber = new JLabel("Box Number:");
		lblBoxNumber.setBounds(63, 145, 81, 16);
		frmAddEquipment.getContentPane().add(lblBoxNumber);
	}
}
