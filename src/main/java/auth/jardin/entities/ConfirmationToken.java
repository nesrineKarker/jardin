package auth.jardin.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConfirmationToken {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String confirmationToken;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	private String type;
	
	
	@ManyToOne(targetEntity = Jardin.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = true, name = "idJardin")
	private Jardin jardin;
	
	
	public ConfirmationToken() {}

	public ConfirmationToken(Jardin jardin, String type) {
		this.jardin = jardin;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
		this.type=type;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
