package Entity;

public abstract class Entity {

	private String ID;
	private String password;
	private String firstName;
	private String lastName;
	private String type;

	public Entity() {
		// TODO Auto-generated constructor stub
	}

	public Entity(String ID, String password, String firstName, String lastName, String type) {
		this.ID = ID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getType() {
		return type;
	}
	
}
