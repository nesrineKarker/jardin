package auth.jardin.entities;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	
	@NotEmpty(message="userName is required")
	private String username;
	 
    @NotEmpty(message="Password is required")
	@Size(min=8, message="Password shoud not be less than  8 caracters")
	private String password;
    
	private int age;
	
	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	//@UniqueElements
	@Column(name="email")
	private String email;
	
	@ManyToOne
	private Role role;
	
	public User() {
		
	}
	public User(int id, String username, String password, int age, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}
	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
