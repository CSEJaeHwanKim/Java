package test;


import javax.swing.JFrame;


public class test 
{

	public static void main(String[] args) 
	{

		JFrame frame = new JFrame();
		frame.setSize(300,300);//���� ���� ��ȭ�� �����
		frame.setTitle("��");//��ȭ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�۾� ����� ������
		FaceComponent face = new FaceComponent();
		frame.add(face);//�󱼿� �׷����� �ҷ�����
		frame.setVisible(true);
		
		
	}

}

