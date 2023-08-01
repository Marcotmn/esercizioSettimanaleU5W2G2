package entities;




import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	

	private int id;
	private String username;
	private String name;
	private String email;
	public User(String username, String name, String email) {
	
		
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
	
}
