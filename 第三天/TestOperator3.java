//�����߼������
public class TestOperator3{
	public static void main(String[] args){
		boolean a = true;
		boolean b = false;
		boolean c = true;
		boolean d = false;
		
		System.out.println(a&c);//a��c true
		System.out.println(a|d);//a��d true
		System.out.println(!a);//��a false
		System.out.println(a^d);//a��d��� ��ͬ����false ��ͬ����true true
		
		//��·
	//int e=1/0;
		boolean f = 3>5&&2<(3/0);
		System.out.println(f);//false  ִ����3>5����false��������ִ���ұ�
	
		int k = 4;
		int h = 3;
		int m = k|h;
		System.out.println(m);//100 011 111 ���7
		
		//��λ
		int n = 3*2*2;
		int s = 3<<2;//�൱��3*2*2
		int p = 12/2/2;
		int q = 12>>2;//�൱��12/2/2
		int x = 3^4;//011 100 ��� 111 7
		
		//�ַ�������
		String str1 = "abcd";
		String str2 = "efgh";
		String str3 = str1+str2;
		System.out.println(str3);
		System.out.println(1+2+"6");//36
		System.out.println("1"+2+3);//123 
		
		//���������
		int score = 80 ;
		int y=-100;
		String  type = score<60?"������":"����";
		int flag =  y>0?1:(y==0?0:-1);
		
		System.out.println("typ = "+type);
		System.out.println("flay = "+flag);
		
		
		
		}
}