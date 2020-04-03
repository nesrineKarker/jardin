package auth.jardin.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Directeur extends User {
	 
	  @OneToOne
	  private Jardin jardin;
	  
	public Directeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Directeur(int id, String username, String password, int age, String email) {
		super(id, username, password, age, email);
		// TODO Auto-generated constructor stub
	}
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	

}
