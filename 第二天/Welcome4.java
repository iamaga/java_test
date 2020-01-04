public class Welcome4{
	public static void main(String[] args){
		//局部变量：方法里面定义的变量
		//局部变量必须要被初始化
		int a=3;
		a=4;
		int b=5;
		a=b+1;
		System.out.println(a);
		
		int c=10;
		c=c+2;
		System.out.println(c);
		
		int age=18;
		
		System.out.println(age);
		double x=3,y=4;
		double z=x+10;
		System.out.println(z);
		//常量
		final int f = 4;
		//f=5; 错误: 无法为最终变量f分配值
		System.out.println(f);
		final int MAX_SPEED = 120;
		System.out.println(MAX_SPEED);
	}
}