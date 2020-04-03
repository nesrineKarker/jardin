package auth.jardin.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="classe")
    private List<Enfant> Enfants;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 private Jardin jardin;
  

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(int id, String nom, List<Enfant> enfants) {
		super();
		this.id = id;
		this.nom = nom;
		//Enfants = enfants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonIgnore
	public List<Enfant> getEnfants() {
		return Enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		Enfants = enfants;
	}
	

}
