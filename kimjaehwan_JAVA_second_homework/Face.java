package test;


import java.awt.Graphics2D;
import java.awt.geom.*;


public class Face //���� ������ �׸���
{

	private int xLeft; //�����̹� ��ġ ��ǥ��
	private int yTop; //���� ��ǥ��
	
	public Face(int x,int y) //�ʱ�ȭ
	{
		xLeft=x;
		yTop=y;
	
	}//��
	
	public void draw(Graphics2D g2)
	{
		Graphics2D g3=(Graphics2D)g2;
		Ellipse2D.Double face = new Ellipse2D.Double(xLeft,yTop,50,50); //��
		Ellipse2D.Double eye_1=new Ellipse2D.Double(xLeft+10,yTop+10,10,10); //��1
		Ellipse2D.Double eye_2=new Ellipse2D.Double(xLeft+30,yTop+10,10,10); //��2
		Line2D.Double nose = new Line2D.Double(xLeft+25,yTop+25,xLeft+25,yTop+35); //��
		Line2D.Double mouse_1 = new Line2D.Double(xLeft+10,yTop+30,xLeft+20,yTop+40); //��1
		Line2D.Double mouse_2 = new Line2D.Double(xLeft+20,yTop+40,xLeft+30,yTop+40); //��2
		Line2D.Double mouse_3 = new Line2D.Double(xLeft+30,yTop+40,xLeft+40,yTop+30); //��3
		
		g3.draw(face);
		g3.draw(eye_1);
		g3.draw(eye_2);
		g3.draw(nose);
		g3.draw(mouse_1);
		g3.draw(mouse_2);
		g3.draw(mouse_3);
		//������ ����� �� �׸���
	}
	
	
}