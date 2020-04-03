package auth.jardin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Demande {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int idDemande;
	    
	    
	    @OneToOne //(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	    private Jardin jardin;

	    
	    
		public Demande() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Demande( Jardin jardin) {
			super();
			this.jardin = jardin;
		}

		public int getIdDemande() {
			return idDemande;
		}

		public void setIdDemande(int idDemande) {
			this.idDemande = idDemande;
		}


		public Jardin getJardin() {
			return jardin;
		}

		public void setJardin(Jardin jardin) {
			this.jardin = jardin;
		}
	    
}
