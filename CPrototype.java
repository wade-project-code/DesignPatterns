
public class CPrototype {
	
	public class Data implements Cloneable{
		private int mId;
		private String mTag;
		
		public Data() {
			System.out.println("----------Data construct----------");
		}
		
		public int getmId() {
			return mId;
		}

		public void setmId(int mId) {
			this.mId = mId;
		}

		public String getmTag() {
			return mTag;
		}

		public void setmTag(String mTag) {
			this.mTag = mTag;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			try {
				Data data = (Data) super.clone();
				data.mId = this.mId;
				data.mTag = this.mTag;
				return data;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String toString() {
			return 	"----------Data start----------\n" +
					"Data [mId=" + mId + ", mTag=" + mTag + "]\n" +
					"----------Data end----------\n";
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CPrototype cPrototype = new CPrototype();
		Data d1 = cPrototype.new Data();
		d1.setmId(1);
		d1.setmTag("Test_1");
		System.out.println(d1.toString());
		
		Data d2 = (Data) d1.clone();
		System.out.println(d2.toString());
		//修改不會影響原型資料
		d2.setmId(2);
		d2.setmTag("alter Test_2");
		System.out.println(d2.toString());

		System.out.println(d1.toString());
	}
}
