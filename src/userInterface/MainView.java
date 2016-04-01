package userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import actualItems.DatabaseManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		checkOutList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JList checkInList = new JList();
		checkOut.addElement("Element");
		checkOut.addElement("Element2");
		
		//Labels
		JLabel lblEquipmentCheckOut = new JLabel("Equipment Check Out");
		lblEquipmentCheckOut.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEquipmentCheckOut.setBounds(142, 24, 192, 16);
		frmCaryInventoryManager.getContentPane().add(lblEquipmentCheckOut);
		
		JLabel lblEquipmentCheckIn = new JLabel("Checked Out Equipment");
		lblEquipmentCheckIn.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEquipmentCheckIn.setBounds(464, 24, 216, 16);
		frmCaryInventoryManager.getContentPane().add(lblEquipmentCheckIn);
		
		//Buttons
		JButton btnCheckOutItem = new JButton("Check Out Item");
		btnCheckOutItem.addActionListener(new ActionListener() { //Bug here and in check in, can only select top element
			public void actionPerformed(ActionEvent e) {
				boolean isAdjusting = checkOutList.getValueIsAdjusting();

				if(checkOutList.isSelectionEmpty()) { 
					JOptionPane.showMessageDialog(frmCaryInventoryManager, "Please select a valid list element");
				}
				if( !isAdjusting && !checkOutList.isSelectionEmpty() && (checkOutList.getMinSelectionIndex() < checkOutList.getMaxSelectionIndex())){ 
					checkIn.addElement(checkOutList.getSelectedValue());
					checkOut.remove(checkOutList.getSelectedIndex());
					System.out.println("single selection mode");
				}
				else { 
					int[] k = checkOutList.getSelectedIndices();
					checkOutList.setSelectedIndices(k);
					for(int i = 0; i < k.length; i++){
						if(checkOutList.isSelectedIndex(k[i])) { 
							checkIn.addElement(checkOut.get(k[i]));
							System.out.println("Multi selection mode");
							checkOut.remove(k[i]);
						}
					}
					
				}
				
			}				
		});
		btnCheckOutItem.setBounds(169, 270, 138, 25);
		frmCaryInventoryManager.getContentPane().add(btnCheckOutItem);
		
		JButton btnCheckInItem = new JButton("Check In Item");
		btnCheckInItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isAdjusting = checkInList.getValueIsAdjusting();

				if(checkInList.isSelectionEmpty()) { 
					JOptionPane.showMessageDialog(frmCaryInventoryManager, "Please select a valid list element");
				}
				/*if( !isAdjusting && !checkInList.isSelectionEmpty() && (checkInList.getMinSelectionIndex() < checkInList.getMaxSelectionIndex())){ 

					checkOut.addElement(checkInList.getSelectedValue());
					checkIn.remove(checkInList.getSelectedIndex());
					
				}*/
				else { 
					int[] k = checkInList.getSelectedIndices();
					for(int i = 0; i < k.length; i++){
						System.out.println(k[i]);
						if(checkInList.isSelectedIndex(k[i])) { 
							checkOut.addElement(checkIn.get(k[i]));
							checkIn.remove(k[i]);
							/*SELCECTION COLOR CODE
							Color c = new Color(255, 0,0, 85);
							checkInList.setSelectionBackground(c);*/
						}
					}
					
				}
				
			}				
		});
		btnCheckInItem.setBounds(503, 270, 138, 25);
		frmCaryInventoryManager.getContentPane().add(btnCheckInItem);
		
		//CHECK OUT LIST CODE
		checkOutList.setModel(checkOut);
		checkOutList.setBounds(117, 53, 240, 181);
		frmCaryInventoryManager.getContentPane().add(checkOutList);
		
		
		//CHECK IN LIST CODE
		checkInList.setModel(checkIn);
		checkInList.setBounds(453, 53, 240, 181);
		frmCaryInventoryManager.getContentPane().add(checkInList);
		
		
		JButton btnAddNewEquipment = new JButton("Add New Equipment");
		btnAddNewEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewEquipmentAdd a = new NewEquipmentAdd();
				a.frmAddEquipment.setVisible(true);
			}
		});
		btnAddNewEquipment.setBounds(158, 304, 160, 25);
		frmCaryInventoryManager.getContentPane().add(btnAddNewEquipment);
		
		JButton btnReportDamagedEquipment = new JButton("Report Damaged Equipment");
		btnReportDamagedEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DatabaseManager changer = new DatabaseManager("equipment");
				String modified;
				if(checkOutList.isSelectionEmpty() == false) { 
					modified = (String) checkOutList.getSelectedValue();
					changer.modifyIntEquipment(changer.retrieveEquipment(modified), "repair", 1); 
					
				}
				if(checkInList.isSelectionEmpty() == false){
					 modified = (String) checkInList.getSelectedValue();
					changer.modifyIntEquipment(changer.retrieveEquipment(modified), "repair", 1);
				}
				else { 
					JOptionPane.showMessageDialog(frmCaryInventoryManager, "Please select a valid list element");
				}
			}
		});
		btnReportDamagedEquipment.setBounds(471, 304, 203, 25);
		frmCaryInventoryManager.getContentPane().add(btnReportDamagedEquipment);
		
		JButton btnRemoveEquipment = new JButton("Remove Equipment ");
		btnRemoveEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dead;
				int listIndex;
				DatabaseManager m = new DatabaseManager("equipment");
				if(checkOutList.isSelectionEmpty() == false){
				dead= (String)checkOutList.getSelectedValue(); //Guarantee this will always be a string.
				listIndex = checkOutList.getSelectedIndex();
				m.deleteEquipment(m.retrieveEquipment(dead));
				checkOut.remove(listIndex);
				}
				if(checkInList.isSelectionEmpty() == false) { 
					dead = (String)checkInList.getSelectedValue(); //Guarantee this'll always be a string.
					listIndex = checkInList.getSelectedIndex();
					m.deleteEquipment(m.retrieveEquipment(dead));
					checkIn.remove(listIndex);
				}
				else { 
					JOptionPane.showMessageDialog(frmCaryInventoryManager, "Please select a valid list element");
				}
				
			}
		});
		btnRemoveEquipment.setBounds(320, 350, 160, 25);
		frmCaryInventoryManager.getContentPane().add(btnRemoveEquipment);
	}
}
