package auth.jardin.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="role", fetch = FetchType.EAGER)
    private List<User> users; 
	
	public Role () {
		
	}
	
	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Role(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
