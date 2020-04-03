package auth.jardin.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Admin extends User{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="admin", fetch = FetchType.EAGER)
    private List<Jardin> jardins;
    
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String username, String password, int age, String email) {
		super(id, username, password, age, email);
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	public List<Jardin> getJardins() {
		return jardins;
	}
	public void setJardins(ArrayList<Jardin> jardins) {
		this.jardins = jardins;
	}
	
	
	

}
