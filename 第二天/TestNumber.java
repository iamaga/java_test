public class TestNumber {
	public static void main(String[] args){
		int a = 345678;
		long b=45678;
		long c=2488888888L;//����21��ĩβ��L
		long e = c+1;
		if( c == e){
			System.out.println("c == e");
		}else{
			System.out.println("c != e");//������Ϊc ��= e������
		}
		//int���ݿ����Զ�ת��Ϊbyte��short��ֻҪ������������Χ��java�е�����Ĭ����int��������Ĭ����double
		byte age=100;
		//byte age2 = 180;����128 �ᱨ��
		
		//������
		float f=3.14F;
		double f2=3.14;//������Ĭ����double
		
		float f3=0.1f;
		double d=1.0/10;
		System.out.println(f);//���Ϊflase
		
		float d1=43245324562F;
		float d2=d1+1;
		if(d1 == d2){
			System.out.println("d1=d2");//������d1=d2����Ϊd1�㹻��
		}else{
			System.out.println("d1!=d2");
		}
	}
}