package test;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class FaceComponent extends JComponent 
{
	

	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
			
		Face face1=new Face(50,50);//얼굴의 위치1
		Face face2=new Face(100,100);//얼굴의 위치2
		Face face3=new Face(150,150);//얼굴의 위치3
		face1.draw(g2);
		face2.draw(g2);
		face3.draw(g2);
		//그리기
	}
	
	
}