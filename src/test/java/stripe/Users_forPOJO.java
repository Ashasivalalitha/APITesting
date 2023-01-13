package stripe;

import java.util.ArrayList;

public class Users_forPOJO {
	
	public String name;
	public String email;
	public ArrayList<Integer> phone;
	public Address_forPOJO address;
	
	public Users_forPOJO(String name, String email, String street, String country) {
	this.name = name;
	this.email = email;
	this.phone = new ArrayList<Integer>();
	this.address = new Address_forPOJO(street, country);
	}

	public ArrayList<Integer> getPhone() {
		return phone;
	}

	public void setPhone(int... phone) {
		for(int i=0; i<phone.length;i++) {
			this.phone.add(phone[i]);
		}
	}
	
	/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	*/
	

}
