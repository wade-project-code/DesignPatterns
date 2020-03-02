
public class CBuilder {

	public abstract class Computer{
		protected String mBoard;
		protected String mDisplay;
		protected String mOS;
		
		protected Computer() {
			
		}
		
		public void setBoard(String mBoard) {
			this.mBoard = mBoard;
		}
		
		public void setDisplay(String mDisplay) {
			this.mDisplay = mDisplay;
		}
		
		public abstract void setOS();

		@Override
		public String toString() {
			return "Computer [mBoard=" + mBoard + ", mDisplay=" + mDisplay + ", mOS=" + mOS + "]";
		}
	}
	
	public class MacBook extends Computer{

		protected MacBook() {
			
		}
		
		@Override
		public void setOS() {
			mOS = "Mac OS";
		}
	}
	
	public abstract class Builder{
		public abstract void buildBoard(String mBoard);
		public abstract void buildDisplay(String mDisplay);
		public abstract void buildOS();
		public abstract Computer create();
	}
	
	public class MacBookBuilder extends Builder{
		private Computer mComputer = new MacBook();

		@Override
		public void buildBoard(String mBoard) {
			mComputer.setBoard(mBoard);
		}

		@Override
		public void buildDisplay(String mDisplay) {
			mComputer.setDisplay(mDisplay);
		}

		@Override
		public void buildOS() {
			mComputer.setOS();
		}

		@Override
		public Computer create() {
			return mComputer;
		}
	}
	
	public class Director{
		Builder mBuilder = null;
		
		public Director(Builder mBuilder) {
			this.mBuilder = mBuilder;
		}
		
		public void construct(String mBoard, String mDisplay) {
			mBuilder.buildBoard(mBoard);
			mBuilder.buildDisplay(mDisplay);
			mBuilder.buildOS();
		}
	}
	
	public static void main(String[] args) {
		CBuilder cBuilder = new CBuilder();
		//1
		Builder mBuilder = cBuilder.new MacBookBuilder();
		//2
		Director director = cBuilder.new Director(mBuilder);
		//3
		director.construct("Intel", "ASUS");
		
		System.out.println(mBuilder.create().toString());
	}
}
