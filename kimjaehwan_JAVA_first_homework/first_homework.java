package first_homework;

import java.io.IOException;//������ ���ڸ� �Է¹ޱ����� ����

import java.util.*;
public class first_homework 
{
	static int add(int n1, int n2)//�Լ��� ����ϱ����� static����
	{
		return n1+n2;
	}

	static int subtract(int n1, int n2)//�Լ��� ����ϱ����� static����
	{
		return n1-n2;
	}

	static int multiply(int n1, int n2)//�Լ��� ����ϱ����� static����
	{
		return n1*n2;
	}

	static int divide(int n1, int n2)//�Լ��� ����ϱ����� static����
	{
		return n1/n2;
	}


	public static void main(String[] args) throws IOException //������ ���ڸ� �Է¹ޱ����� ����
	{
		Scanner s=new Scanner(System.in);//newInt�� ����ϱ����� ����
		int n1=s.nextInt();
		System.out.println("Enter the first number: "+n1);
		int n2=s.nextInt();
		System.out.println("Enter the second number: "+n2);
		char op=(char)System.in.read();
		System.out.println("Enter operator: "+op);//�����ȣ�� ���ڷμ� �Է�
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
