
public class Singleton {
	
	/*
	 *	懶散模式，instance若已經被初始化，每次呼叫getInstance方法都會進行同步
	 * 	消耗不必要資源，不建議使用此方式
	 */
	/*
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	*/
	
	/*
	 * 	使用靜態內部類別方法實作
	 */
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		return SingletonHolder.mInstance;
	}
	private static class SingletonHolder{
		private static final Singleton mInstance = new Singleton();
	}
}
