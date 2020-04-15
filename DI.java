
public class DI {
	
	public interface IUser{
		void setType();
	}
	
	public static class AUser implements IUser{

		@Override
		public void setType() {
			System.out.println("User id = 1 ");
		}
	}
	
	public static class BUser implements IUser {

		@Override
		public void setType() {
			System.out.println("User id = 2 ");
		}
	}
	
	public static class MainUser{
		private IUser iuser;
		
		public MainUser(IUser iuser) {
			this.iuser = iuser;
		}
		
		private void checkId() {
			iuser.setType();
		}
	}
	
	public static void main(String[] args) {
		AUser a = new AUser();
		MainUser user = new MainUser(a);
		user.checkId();
	}
}
