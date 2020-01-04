public class TestNumber {
	public static void main(String[] args){
		int a = 345678;
		long b=45678;
		long c=2488888888L;//大于21亿末尾加L
		long e = c+1;
		if( c == e){
			System.out.println("c == e");
		}else{
			System.out.println("c != e");//输出结果为c ！= e，整数
		}
		//int数据可以自动转换为byte、short，只要不超过表数范围，java中的整数默认是int，浮点数默认是double
		byte age=100;
		//byte age2 = 180;大于128 会报错
		
		//浮点数
		float f=3.14F;
		double f2=3.14;//浮点数默认是double
		
		float f3=0.1f;
		double d=1.0/10;
		System.out.println(f);//结果为flase
		
		float d1=43245324562F;
		float d2=d1+1;
		if(d1 == d2){
			System.out.println("d1=d2");//输出结果d1=d2，因为d1足够大
		}else{
			System.out.println("d1!=d2");
		}
	}
}