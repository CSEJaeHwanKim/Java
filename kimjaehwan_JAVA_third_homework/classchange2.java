package third_homework;


import java.util.Scanner;

public class classchange2
{
	private int n1;  //멤버변수선언
	private int n2;
	private char op;
	
	private Scanner sc = new Scanner(System.in);
	
	public classchange2(int x, int y, char z) //생성자함수
	{
		n1=x;
		n2=y;
		op=z;
	}
	

	public int getN1() //get함수1
	{
		
		return n1;
	}

	public int getN2() //get함수2
	{
		
		return n2;
	}
    
	public char getOp() //get함수3
	{
		
		return op;
	}
	
	public void setN1(int n1) //set함수1
	{
		this.n1 = n1;
	}


	public void setN2(int n2) //set함수2
	{
		this.n2 = n2;
	}


	public void setOp(char op) //set함수3
	{
		this.op = op;
	}
  
	int add(int n1, int n2) //값의 합
	{
		return n1+n2;
	}

	int subtract(int n1, int n2) //값의 뺄셈
	{
		return n1-n2;
	}

	int multiply(int n1, int n2) //값의 곱
	{
		return n1*n2;
	}

	int divide(int n1, int n2) //갑의 나눗셈
	{
		return n1/n2;
	}
	
	int cal(char op) //값의 연산
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
