
public class CFactory {
	
	public static abstract class Car{
		public abstract void drive();
	}
	
	public static abstract class CarFactory{
		public abstract <T extends Car> T createCar(Class<T> clazz);
	}
	
	public static class ACarFactory extends CarFactory{

		@Override
		public <T extends Car> T createCar(Class<T> clazz) {
			Car car = null;
			try {
				car = (Car)Class.forName(clazz.getName()).newInstance();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return (T)car;
		}
	}
	
	public static class T01 extends Car{
		@Override
		public void drive() {
			System.out.println("T01 drive...");
		}
	}
	
	public static class T02 extends Car{
		@Override
		public void drive() {
			System.out.println("T02 drive...");
		}
	}
	
	public static class T03 extends Car{
		@Override
		public void drive() {
			System.out.println("T03 drive...");
		}
	}
	
	public static void main(String[] args) {
		CarFactory carFactory = new ACarFactory();
		
		T01 t01 = carFactory.createCar(T01.class);
		t01.drive();
		
		T02 t02 = carFactory.createCar(T02.class);
		t02.drive();
		
		T03 t03 = carFactory.createCar(T03.class);
		t03.drive();
	}
}
