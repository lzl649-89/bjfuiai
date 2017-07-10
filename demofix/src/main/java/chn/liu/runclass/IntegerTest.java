package chn.liu.runclass;

public class IntegerTest {
	public static void main(String[] args) {

		Integer i1 = 100;
		Integer i2 = 100;
		System.out.println(i1 == i2);  //true

		Integer i3 = 1000;
		Integer i4 = 1000;
		System.out.println(i3 == i4);  //false
		// iteger 缓存池中存有 -128 - 127在这个区间中的数字被直接创建，如果不存在则new创建。所以上面两个一个结果为true，一个为false

		int i5 = 100;
		int i6 = 100;
		System.out.println(i5 == i6);

		int i7 = 1000;
		int i8 = 1000;
		System.out.println(i7 == i8);
	}
}
