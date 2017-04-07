package third_homework;
import java.io.IOException;
import java.util.*;
public class classchange1 
{

	public static void main(String[] args) throws IOException
	{
		Scanner s=new Scanner(System.in);
		int a=s.nextInt(); //정수1입력
		int b=s.nextInt(); //정수2입력
		char d=(char)System.in.read(); //문자입력
		classchange2 c=new classchange2(a,b,d); //class에 값대입
		System.out.println("Enter the first number: "+a); //숫자입력
		System.out.println("Enter the second number: "+b); //숫자입력
		System.out.println("Enter operator: "+d); //연산기호를 문자로서 입력
		System.out.printf("The result: %d\n", c.cal(d)); //최종값 출력
    }

}
