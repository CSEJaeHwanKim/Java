package third_homework;


import java.util.Scanner;

public class classchange2
{
	private int n1;  //�����������
	private int n2;
	private char op;
	
	private Scanner sc = new Scanner(System.in);
	
	public classchange2(int x, int y, char z) //�������Լ�
	{
		n1=x;
		n2=y;
		op=z;
	}
	

	public int getN1() //get�Լ�1
	{
		
		return n1;
	}

	public int getN2() //get�Լ�2
	{
		
		return n2;
	}
    
	public char getOp() //get�Լ�3
	{
		
		return op;
	}
	
	public void setN1(int n1) //set�Լ�1
	{
		this.n1 = n1;
	}


	public void setN2(int n2) //set�Լ�2
	{
		this.n2 = n2;
	}


	public void setOp(char op) //set�Լ�3
	{
		this.op = op;
	}
  
	int add(int n1, int n2) //���� ��
	{
		return n1+n2;
	}

	int subtract(int n1, int n2) //���� ����
	{
		return n1-n2;
	}

	int multiply(int n1, int n2) //���� ��
	{
		return n1*n2;
	}

	int divide(int n1, int n2) //���� ������
	{
		return n1/n2;
	}
	
	int cal(char op) //���� ����
	{
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
			return result;
	}

	
}
