package test;


import javax.swing.JFrame;


public class test 
{

	public static void main(String[] args) 
	{

		JFrame frame = new JFrame();
		frame.setSize(300,300);//얼굴이 나올 도화지 만들기
		frame.setTitle("얼굴");//도화지 제목
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//작업 종료시 나오기
		FaceComponent face = new FaceComponent();
		frame.add(face);//얼굴에 그려진건 불러오기
		frame.setVisible(true);
		
		
	}

}

