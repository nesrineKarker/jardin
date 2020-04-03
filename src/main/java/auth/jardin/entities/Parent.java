package auth.jardin.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Parent extends User {

	@OneToMany(cascade = CascadeType.ALL,mappedBy="parent", fetch = FetchType.EAGER)
    private List<Enfant> Enfants;
	
	@OneToOne(mappedBy ="parent")
	private Avis avis;
	
	 @ManyToOne()
	 private Jardin jardin;
	
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(int id, String username, String password, int age, String email) {
		super(id, username, password, age, email);
		// TODO Auto-generated constructor stub
	}
	public List<Enfant> getEnfants() {
		return Enfants;
	}
	public void setEnfants(List<Enfant> enfants) {
		Enfants = enfants;
	}
	
	
	
	
	
}
