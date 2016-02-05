package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainView {

	private JFrame frmCaryInventoryManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmCaryInventoryManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCaryInventoryManager = new JFrame();
		frmCaryInventoryManager.setResizable(false);
		frmCaryInventoryManager.setTitle("Cary Inventory Manager");
		frmCaryInventoryManager.setBounds(100, 100, 818, 440);
		frmCaryInventoryManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCaryInventoryManager.getContentPane().setLayout(null);
		DefaultListModel checkIn = new DefaultListModel();
		DefaultListModel checkOut = new DefaultListModel();
		JList checkOutList = new JList();
		JList checkInList = new JList();
		checkOut.addElement("Element");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thomas\\Downloads\\gT83EWF.gif"));
		lblNewLabel.setBounds(28, 25, 387, 321);
		frmCaryInventoryManager.getContentPane().add(lblNewLabel);
		//checkOut.s
		
		JLabel lblEquipmentCheckOut = new JLabel("Equipment Check Out");
		lblEquipmentCheckOut.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEquipmentCheckOut.setBounds(142, 24, 192, 16);
		frmCaryInventoryManager.getContentPane().add(lblEquipmentCheckOut);
		
		JLabel lblEquipmentCheckIn = new JLabel("Checked Out Equipment");
		lblEquipmentCheckIn.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEquipmentCheckIn.setBounds(464, 24, 216, 16);
		frmCaryInventoryManager.getContentPane().add(lblEquipmentCheckIn);
		
		JButton btnCheckOutItem = new JButton("Check Out Item");
		btnCheckOutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkInList.getSelectedIndex() > 0) {
					checkIn.addElement(checkOut.getElementAt(checkInList.getSelectedIndex()));
					checkOut.remove(checkInList.getSelectedIndex());
				}
				else { 
					JOptionPane.showMessageDialog(frmCaryInventoryManager, "Please select a valid list element");
				}
				
			}
		});
		btnCheckOutItem.setBounds(167, 270, 138, 25);
		frmCaryInventoryManager.getContentPane().add(btnCheckOutItem);
		
		JButton btnCheckInItem = new JButton("Check In Item");
		btnCheckInItem.setBounds(492, 270, 138, 25);
		frmCaryInventoryManager.getContentPane().add(btnCheckInItem);
		
		//CHECK OUT LIST CODE
		checkOutList.setModel(checkOut);
		checkOutList.setBounds(118, 53, 240, 181);
		frmCaryInventoryManager.getContentPane().add(checkOutList);
		
		
		//CHECK IN LIST CODE
		checkInList.setModel(checkIn);
		checkInList.setBounds(452, 53, 240, 181);
		frmCaryInventoryManager.getContentPane().add(checkInList);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(403, 37, 0, 198);
		frmCaryInventoryManager.getContentPane().add(separator);
		
		JButton btnAddNewEquipment = new JButton("Add New Equipment");
		btnAddNewEquipment.setBounds(167, 304, 160, 25);
		frmCaryInventoryManager.getContentPane().add(btnAddNewEquipment);
		
		JButton btnReportDamagedEquipment = new JButton("Report Damaged Equipment");
		btnReportDamagedEquipment.setBounds(464, 304, 203, 25);
		frmCaryInventoryManager.getContentPane().add(btnReportDamagedEquipment);
		
		JButton btnRemoveEquipment = new JButton("Remove Equipment ");
		btnRemoveEquipment.setBounds(320, 350, 160, 25);
		frmCaryInventoryManager.getContentPane().add(btnRemoveEquipment);
	}
}
