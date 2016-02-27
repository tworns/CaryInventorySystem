package actualItems;

public class Equipment {
	int id;
	int boxNum;
	int status; //0 = available
	int repairNeeded; // != 0 means needs repair
	int itemType; // 0 = equipment, 1= games, 2 = food, 3 = tools
	String section;
	String itemName;
	public Equipment(int id, int boxNum, int status, int repairNeeded, int itemType, String section, String itemName){
		this.id = id;
		this.status = status;
		this.repairNeeded = repairNeeded;
		this.itemType = itemType;
		this.section = section;
		this.itemName = itemName;
	}
	//getters
	public int getID() { 
		return this.id;
	}
	public int getBox() { 
		return this.boxNum;
	}
	public int getStatus() { 
		return this.status;
	}
	public int getRepair() { 
		return this.repairNeeded;
	}
	public String getSection() { 
		return this.section;
	}
	public String getName() { 
		return this.itemName;
	}
	
	
	//Setters
	public void setBox(int boxNum) { 
		this.boxNum = boxNum;
		
	}
	public void setStatus(int status) { 
		this.status = status;
		
	}
	public void setRepair( int repair) { 
		this.repairNeeded = repair;
	}
	public void setSection( String section) { 
		this.section = section;
	}
	public void setName(String name){ 
		this.itemName = name;
	}
	public String toString(Equipment e) { //may need this to change later, pending JList needs
		
		return e.itemName;
	}
	
}
