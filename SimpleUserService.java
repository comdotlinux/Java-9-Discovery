/**
 * InterfacePrivateMethods
 */
interface UserService{

	default String getUser() {
		return getUserFromEnv();
	}
	
	default String getSystemUser(){
		return getUserFromEnv();
	}
	
	private String getUserFromEnv() {
		return System.getenv("USER");
	}

}
public class SimpleUserService implements UserService{


	@Override
	public String getUser() {
		return "john";
	}

	public static void main(String[] args) {
		UserService s = new SimpleUserService();
		System.out.println("Current User :: " + s.getUser());
		System.out.println("Current System User :: " + s.getSystemUser());
	}

	
}