package Search_Pf;

import javafx.beans.property.SimpleStringProperty;

public class ContactsData {
	private SimpleStringProperty fname;
	private SimpleStringProperty lname;
	private SimpleStringProperty email;
	private SimpleStringProperty office;
	private SimpleStringProperty officehour;
	
	public ContactsData(String fname, String lname, String email,String office,String officehour) {
		this.fname = new SimpleStringProperty(fname);
		this.lname = new SimpleStringProperty(lname);
		this.email = new SimpleStringProperty(email);
		this.office = new SimpleStringProperty(office);
		this.officehour = new SimpleStringProperty(officehour);
		
	}
	
	public String getfname() {
		return fname.get();
	}
	
	public String getlname() {
		return lname.get();
	}
	
	public String getemail() {
		return email.get();
	}
	
	public String getoffice() {
		return office.get();
	}
	
	public String getofficehour() {
		return officehour.get();
	}
	
	public void setfname(String fname) {
		this.fname.set(fname);
	}
	
	public void setlname(String lname) {
		this.fname.set(lname);
	}
	
	public void setemail(String email) {
		this.email.set(email);
	}
	
	public void setoffice(String office){
		this.office.set(office);
	}
	
	public void setofficehour(String officehour) {
		this.officehour.set(officehour);
	}



}
