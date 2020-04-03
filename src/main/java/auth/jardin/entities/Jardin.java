package auth.jardin.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Jardin extends User{
	     
	    private String description;
	    private String logo;
	    private int nbEmploy;
	    private Date dateCreation;
	    private Long numTel;
	    private String adresse;
	    private boolean isEnabled;
	    private float note;
	   
	    @OneToMany(orphanRemoval=true, mappedBy="jardin", fetch = FetchType.EAGER,cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
		@Fetch(value = FetchMode.SUBSELECT)
	    private List<Parent> parents ; 
	    
	    @OneToMany(orphanRemoval=true, mappedBy="jardin", fetch = FetchType.EAGER,cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
		@Fetch(value = FetchMode.SUBSELECT)
	    private List<Avis> avis ;
	    
	   
	    @OneToMany(orphanRemoval=true, mappedBy="jardin",cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	    private List<Classe> classes; 
	    
	    @OneToOne(mappedBy="jardin")
	    private Demande demande;
	    
	    @ManyToOne()
	    private Admin admin;
	    
	    
	    @OneToMany(orphanRemoval=true, mappedBy="jardin",cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	    private List<ConfirmationToken> confirm;
	    
	    
	    public float moyenneNotes(int id) {
			float sum = 0;
			for (int i = 0; i < avis.size(); i++) {
				sum = sum + (avis.get(i).getNote());	
			}
			float moy = sum/(avis.size());
			return moy;
		}

	    
		public Jardin() {
			super();
			
		}

	
		public Jardin(String description, String logo, int nbEmploy, Date dateCreation, Long numTel, String adresse,
				boolean isEnabled,float note, List<Parent> parents, List<Classe> classes, Demande demande, Admin admin,
				List<ConfirmationToken> confirm) {
			super();
			this.description = description;
			this.logo = logo;
			this.nbEmploy = nbEmploy;
			this.dateCreation = dateCreation;
			this.numTel = numTel;
			this.adresse = adresse;
			this.isEnabled = isEnabled;
			this.note = this.moyenneNotes(id);
			this.parents = parents;
			this.classes = classes;
			this.demande = demande;
			this.admin = admin;
			this.confirm = confirm;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLogo() {
			return logo;
		}


		public void setLogo(String logo) {
			this.logo = logo;
		}


		public int getNbEmploy() {
			return nbEmploy;
		}


		public void setNbEmploy(int nbEmploy) {
			this.nbEmploy = nbEmploy;
		}


		public Date getDateCreation() {
			return dateCreation;
		}


		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}


		public Long getNumTel() {
			return numTel;
		}


		public void setNumTel(Long numTel) {
			this.numTel = numTel;
		}


		public String getAdresse() {
			return adresse;
		}


		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}


		public boolean isEnabled() {
			return isEnabled;
		}


		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
		
		public float getNote() {
			return note;
		}

		public void setNote(float note) {
			this.note = note;
		}


		public List<Parent> getParents() {
			return parents;
		}


		public void setParents(List<Parent> parents) {
			this.parents = parents;
		}


		public List<Avis> getAvis() {
			return avis;
		}


		public void setAvis(List<Avis> avis) {
			this.avis = avis;
		}


		public List<Classe> getClasses() {
			return classes;
		}


		public void setClasses(List<Classe> classes) {
			this.classes = classes;
		}


		public Demande getDemande() {
			return demande;
		}


		public void setDemande(Demande demande) {
			this.demande = demande;
		}


		public Admin getAdmin() {
			return admin;
		}


		public void setAdmin(Admin admin) {
			this.admin = admin;
		}


		public List<ConfirmationToken> getConfirm() {
			return confirm;
		}


		public void setConfirm(List<ConfirmationToken> confirm) {
			this.confirm = confirm;
		}


}
