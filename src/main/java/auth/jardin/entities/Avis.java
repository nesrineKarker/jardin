package auth.jardin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Avis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String message;
	private int note;
	
	@ManyToOne
	private Jardin jardin;
	@OneToOne
	private Parent parent;
	
	public Avis() {
		super();
	}

	public Avis(int id, String message, int note, Jardin jardin, Parent parent) {
		super();
		this.id = id;
		this.message = message;
		this.note = note;
		this.jardin = jardin;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	
	
	
}
