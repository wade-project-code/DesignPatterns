
public class CStrategy {
	
	public interface IStrategy{
		int cal(int n);
	}
	
	public class AStrategy implements IStrategy{

		@Override
		public int cal(int n) {
			return n * 10;
		}
		
	}
	
	public class BStrategy implements IStrategy{

		@Override
		public int cal(int n) {
			return n * 100;
		}
		
	}
	
	public class MainStrategy{
		IStrategy mStrategy;
		
		public void setStrategy(IStrategy mStrategy) {
			this.mStrategy = mStrategy;
		}
		
		public int getCal(int n) {
			return mStrategy.cal(n);
		}
	}
	
	public static void main(String[] args) {
		CStrategy cStrategy = new CStrategy();
		
		MainStrategy mainStrategy = cStrategy.new MainStrategy();
		
		//A
		mainStrategy.setStrategy(cStrategy.new AStrategy());
		System.out.println(mainStrategy.getCal(10));
		
		//B
		mainStrategy.setStrategy(cStrategy.new BStrategy());
		System.out.println(mainStrategy.getCal(10));

	}
}
