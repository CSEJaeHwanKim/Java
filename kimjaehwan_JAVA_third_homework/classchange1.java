package third_homework;
import java.io.IOException;
import java.util.*;
public class classchange1 
{

	public static void main(String[] args) throws IOException
	{
		Scanner s=new Scanner(System.in);
		int a=s.nextInt(); //����1�Է�
		int b=s.nextInt(); //����2�Է�
		char d=(char)System.in.read(); //�����Է�
		classchange2 c=new classchange2(a,b,d); //class�� ������
		System.out.println("Enter the first number: "+a); //�����Է�
		System.out.println("Enter the second number: "+b); //�����Է�
		System.out.println("Enter operator: "+d); //�����ȣ�� ���ڷμ� �Է�
		System.out.printf("The result: %d\n", c.cal(d)); //������ ���
    }

}
