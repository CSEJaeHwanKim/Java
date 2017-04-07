package first_homework;

import java.io.IOException;//정수및 문자를 입력받기위한 선언

import java.util.*;
public class first_homework 
{
	static int add(int n1, int n2)//함수를 사용하기위한 static선언
	{
		return n1+n2;
	}

	static int subtract(int n1, int n2)//함수를 사용하기위한 static선언
	{
		return n1-n2;
	}

	static int multiply(int n1, int n2)//함수를 사용하기위한 static선언
	{
		return n1*n2;
	}

	static int divide(int n1, int n2)//함수를 사용하기위한 static선언
	{
		return n1/n2;
	}


	public static void main(String[] args) throws IOException //정수및 문자를 입력받기위한 선언
	{
		Scanner s=new Scanner(System.in);//newInt를 사용하기위해 선언
		int n1=s.nextInt();
		System.out.println("Enter the first number: "+n1);
		int n2=s.nextInt();
		System.out.println("Enter the second number: "+n2);
		char op=(char)System.in.read();
		System.out.println("Enter operator: "+op);//연산기호를 문자로서 입력
		int result = 0;
		switch(op)
		{
		case '+': result = add(n1, n2); 
		break;
		case '-': result = subtract(n1, n2); 
		break;
		case '*': result = multiply(n1, n2); 
		break;
		case '/': result = divide(n1, n2);
		}
		System.out.printf("The result: %d\n", result);
		

	}
}
