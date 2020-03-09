
public class CState {

	public interface IPcState{
		public void login();
		public void logout();
	}
	
	public class PowerOffState implements IPcState{

		@Override
		public void login() {			
		}

		@Override
		public void logout() {			
		}
		
	}
	
	public class PowerOnState implements IPcState{

		@Override
		public void login() {
			System.out.println("login...");
		}

		@Override
		public void logout() {
			System.out.println("logout...");
		}
		
	}
	
	public interface IPower{
		public void powerOn();
		public void powerOff();
	}
	
	public class PcController implements IPower{
		private IPcState mIPcState;
		
		public void setPcState(IPcState mIPcState) {
			this.mIPcState = mIPcState;
		}
		
		@Override
		public void powerOn() {
			setPcState(new PowerOnState());
			System.out.println("PowerOn...");
		}

		@Override
		public void powerOff() {
			setPcState(new PowerOffState());
			System.out.println("PowerOff...");
		}
		
		public void login() {
			mIPcState.login();
		}

		public void logout() {
			mIPcState.logout();
		}
		
	}
	
	public static void main(String[] args) {
		CState cState = new CState();
		PcController controller = cState.new PcController();
		
		controller.powerOn();
		controller.login();
		controller.logout();
		
		controller.powerOff();
		//powerOff後下列動作不會有反應
		controller.login();
		controller.logout();
	}
}
