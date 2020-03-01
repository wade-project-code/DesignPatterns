
public class Singleton {
	
	/*
	 *	�i���Ҧ��Ainstance�Y�w�g�Q��l�ơA�C���I�sgetInstance��k���|�i��P�B
	 * 	���Ӥ����n�귽�A����ĳ�ϥΦ��覡
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
	 * 	�ϥ��R�A�������O��k��@
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
