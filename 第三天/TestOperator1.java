//��������������������Լ����������չ�����
public class TestOperator1{
	public static void main(String[] args){
		//��ϵ���������
		int a=3;
		long b=4;
		double c=3.15;
		
		long d=a+b;
		double e=c+a;
		
		int f=a++;
		int g=++a;
		
		System.out.println("f="+f);//f=3 f=a a=a+1;
		System.out.println("g="+g);//g=5 a=a+1 g=a;
		
		
		//��ϰ����ֵ�����
		int h=3;
		int k=4;
		h+=k;//h=h+k;
		System.out.println("h="+h+"\nk="+k);//h=7;k=4;
		
		
	}
}