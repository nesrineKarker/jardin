package auth.jardin.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Enfant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	
	
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Parent parent;
	
	 @ManyToOne()
	 private Classe classe;
	 
	public Enfant() {}


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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	
	
}
