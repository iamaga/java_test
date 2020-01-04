//测试逻辑运算符
public class TestOperator3{
	public static void main(String[] args){
		boolean a = true;
		boolean b = false;
		boolean c = true;
		boolean d = false;
		
		System.out.println(a&c);//a与c true
		System.out.println(a|d);//a或d true
		System.out.println(!a);//非a false
		System.out.println(a^d);//a与d异或 相同返回false 不同返回true true
		
		//短路
	//int e=1/0;
		boolean f = 3>5&&2<(3/0);
		System.out.println(f);//false  执行完3>5返回false结束，不执行右边
	
		int k = 4;
		int h = 3;
		int m = k|h;
		System.out.println(m);//100 011 111 输出7
		
		//移位
		int n = 3*2*2;
		int s = 3<<2;//相当于3*2*2
		int p = 12/2/2;
		int q = 12>>2;//相当于12/2/2
		int x = 3^4;//011 100 异或 111 7
		
		//字符串连接
		String str1 = "abcd";
		String str2 = "efgh";
		String str3 = str1+str2;
		System.out.println(str3);
		System.out.println(1+2+"6");//36
		System.out.println("1"+2+3);//123 
		
		//条件运算符
		int score = 80 ;
		int y=-100;
		String  type = score<60?"不及格":"及格";
		int flag =  y>0?1:(y==0?0:-1);
		
		System.out.println("typ = "+type);
		System.out.println("flay = "+flag);
		
		
		
		}
}