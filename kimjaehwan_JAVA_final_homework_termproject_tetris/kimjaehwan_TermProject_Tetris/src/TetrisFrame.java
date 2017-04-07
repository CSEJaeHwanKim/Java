import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TetrisFrame extends JFrame {
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if(source==startButton){
				
				reset();
				pauseButton.setEnabled(true);
				mainGrid.setFocusable(true);
				startNewTetrimino();
				mainGrid.requestFocus();
				//배경음악 스레드 실행
				bgmThread.start();				
			}
			else if(source==pauseButton){
				if(!pauseFlag){
					startButton.setEnabled(false);
					speedTimer.cancel();
					pauseFlag = true;
				}
				else{
					startButton.setEnabled(true);
					pauseFlag = false;
					speedTimer = new Timer();
					speedTimer.schedule(new ShapeDownTask(),500,500);
					mainGrid.requestFocus();
				}
			}
		}
	}
	private class KeyboardListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
			repaint();
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				gameBoard.moveShapeLeft();
				mainGrid.setColors(gameBoard);
	            mainGrid.repaint();
	            player.play("Move.wav");
			}
	        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	        	gameBoard.moveShapeRight();
	        	mainGrid.setColors(gameBoard);
	        	mainGrid.repaint();
	        	player.play("Move.wav");
	        }
	        else if (e.getKeyCode() == KeyEvent.VK_UP){
	        	gameBoard.rotateShape();
	        	mainGrid.setColors(gameBoard);
	        	mainGrid.repaint();
	        	player.play("Rotate.wav");
	        }
	        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
	        	gameBoard.moveShapeDown();
	        	mainGrid.setColors(gameBoard);
	            mainGrid.repaint();
	            player.play("Move.wav");
	        }
	        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
	        	gameBoard.hardDropShape();
	            mainGrid.setColors(gameBoard);
	            mainGrid.repaint();
	            score += 4;
	            player.play("HardDrop.wav");
	        }
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
	
	private class ShapeDownTask extends TimerTask{
		public int computeScore(int numberOfRemovedRows){
			switch(numberOfRemovedRows){
			case 1: 
				player.play("SingleLineClear.wav");
				return 40*level+4;
			case 2:
				player.play("DoubleLineClear.wav");
				return 100*level+4;
			case 3: 
				player.play("TripleLineClear.wav");
				return 300*level+4;
			case 4: 
				return 1200*level+4;
			default: return 4;
			}
		}
		

		
		@Override
		public void run() {
			//repaint();
			
			
			
			//파일 종료를 검사한다.
			//파일 종료는 두번째 줄에서 테트로미노가 밑으로 내려갈 수가 없을 때 실행되도록 했다.
			if(gameBoard.lineChecker())
			{
				String Rank="";
				JOptionPane.showMessageDialog(null, "!!!!Game Over!!!!"); 
				try {
					//이름을 입력받고 명예의 전당에 기록한다.
					//기록하고 점수가 높을 수록 위로 가게 하였다(내림차순)
					//선저장 후불러오기로 모든 데이터가 일단 저장되도록 하였다.
					//불러온 값을 메시지 박스에 점수에 따른 내림차순으로 출력
					String input = JOptionPane.showInputDialog("이름을 입력해주세요.");
					String index=new String("점수  이름   레벨");
					String data=score+ "    " + input +"     " + level;
					saveData(data);
					
					Rank=loadData();
					JOptionPane.showMessageDialog(null, index + Rank);
					
					 
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.exit(0);
			}
			if(!gameBoard.moveShapeDown()){
				int removedLines = gameBoard.removeFullRow();
				numberOfLines += removedLines;
				score += computeScore(removedLines);

				//레벨 변화 if문
				//라인 10개당 1레벨
				if(numberOfLines>=10)
					level=2;
				if(numberOfLines>=20)
					level=3;
				if(numberOfLines>=30)
					level=4;
				if(numberOfLines>=40)
					level=5;
				if(numberOfLines>=50)
					level=6;
				if(numberOfLines>=60)
					level=7;
				if(numberOfLines>=70)
					level=8;
				if(numberOfLines>=80)
					level=9;
				if(numberOfLines>=100)
					level=10;
				setStateData();
				tetrominoFactory.changeBlock();
				startNewTetrimino();
			}
			else{
				mainGrid.setColors(gameBoard);
				mainGrid.repaint();
			}
			repaint();
		}
	}
	
	
	//bgm을 틀어주는 클래스
	//교수님께서 만드신 오디오 플레이 클래스와 
	//쓰레드 클래스를 사용하여 다른 쓰레드에서 독립적으로 돌게 하였음.
	private class BgmThread extends Thread
	{
		AudioPlayer bgm = new AudioPlayer("bgm.wav");
		boolean check=true;
		public void bgmStart()
		{
			bgm.play();
		}

		public void run()
		{
			
				bgmStart();
		}
	
		
	}
	
	
	private JPanel mainPanel = new JPanel();
	private JPanel homePanel = new JPanel();
	private JPanel statePanel = new JPanel();
	private JButton startButton = new JButton("start");
	private JButton pauseButton = new JButton("pause");
	private JTextField levelField = new JTextField(6);
	private JTextField scoreField = new JTextField(6);
	private JTextField lineField = new JTextField(6);
	private JLabel levelLabel = new JLabel("level");
	private JLabel scoreLabel = new JLabel("score");
	private JLabel lineLabel = new JLabel("line");
	
	private TetrisGrid mainGrid = new TetrisGrid(10,22);
	private TetrisGrid nextGrid = new TetrisGrid(6,6);
	
	private TetrisBoard gameBoard = new TetrisBoard(10,22);
	private TetrisBoard nextBoard = new TetrisBoard(6,6);
	
	private TetrominoFactory tetrominoFactory = new TetrominoFactory();
	private Timer speedTimer = new Timer();
	private AudioPlayer player = new AudioPlayer();
	private BgmThread bgmThread =new BgmThread();
	private int level = 1;
	private int score = 0;
	private int numberOfLines = 0;
	private boolean pauseFlag = false;
	
	public TetrisFrame(){
		setTitle("Java Tetris");
		setSize(400, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setView();
	}
	
	private void setHomePanel(){
		ActionListener listener = new ButtonListener();
		startButton.addActionListener(listener);
		pauseButton.addActionListener(listener);
		
		homePanel.setLayout(new FlowLayout());
		homePanel.add(startButton);
		homePanel.add(pauseButton);
		pauseButton.setEnabled(false);
		add(homePanel, BorderLayout.NORTH);
	}
	
	private void initTextFields(JTextField field){
		field.setMaximumSize(new Dimension(240, 60));
		field.setEditable(false);
		field.setHorizontalAlignment(JTextField.RIGHT);
	}
	
	private void setStatePanel(){
		statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.PAGE_AXIS));
		statePanel.add(Box.createVerticalStrut(20));
		statePanel.add(nextGrid);
		statePanel.add(Box.createVerticalStrut(20));
		statePanel.add(levelLabel);
		statePanel.add(levelField);
		statePanel.add(Box.createVerticalStrut(10));
		statePanel.add(scoreLabel);
		statePanel.add(scoreField);
		statePanel.add(Box.createVerticalStrut(10));
		statePanel.add(lineLabel);
		statePanel.add(lineField);
		statePanel.add(Box.createVerticalStrut(100));
		
		initTextFields(levelField);
		initTextFields(scoreField);
		initTextFields(lineField);
	}
	
	private void setMainPanel(){
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		mainPanel.add(Box.createHorizontalStrut(20));
		mainPanel.add(mainGrid);
		mainPanel.add(Box.createHorizontalStrut(20));
		mainPanel.add(statePanel);
		mainPanel.add(Box.createHorizontalStrut(20));
		mainGrid.addKeyListener(new KeyboardListener());
		add(mainPanel, BorderLayout.CENTER);
	}
	
	private void setStateData(){
		levelField.setText(level+"");
		scoreField.setText(score+"");
		lineField.setText(numberOfLines+"");
	}
	
	private void setView(){
		setHomePanel();
		setStatePanel();
		setMainPanel();
		setStateData();
	}

	private void reset(){
		numberOfLines = 0;
		score = 0;
		level = 1;
		setStateData();
		gameBoard.clear();
		nextBoard.clear();
		mainGrid.setColors(gameBoard);
		nextGrid.setColors(nextBoard);
		repaint();
	
		mainGrid.repaint();
		nextGrid.repaint();
		tetrominoFactory.start();
		speedTimer.cancel();
		speedTimer = new Timer();
		speedTimer.schedule(new ShapeDownTask(),500,500);
		
	}
	
	private void startNewTetrimino(){
		gameBoard.insertTetromino(tetrominoFactory.getCurrent());
		nextBoard.clear();
		nextBoard.insertTetromino(tetrominoFactory.getNext());
		nextBoard.moveShapeDown();
		mainGrid.setColors(gameBoard);
		nextGrid.setColors(nextBoard);
		repaint();
		mainGrid.repaint();
		nextGrid.repaint();
	}
	//파일을 불러오는 함수
	//파일을 불러오면서 정렬을 하고
	//정렬시에 10등 밖에 벗어나면 짜른다.
	//ArrayList 사용.
	private String loadData() throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		ArrayList<String> list = new ArrayList<String>();
		String inData="";
		String temp="";
		try
		{
			while((temp=br.readLine())!=null)
			{
				
				list.add(temp);
				
			}
			Collections.sort(list, Collections.reverseOrder());
			
			for(int i = 0; i < list.size(); i++) {
				inData=inData+"\n"+list.get(i);
				if(i>10)
					break;
	        }

			br.close();
		}
		catch(Exception e)
		{
			System.out.println("Error : " + e);
			e.printStackTrace();
		}
	return inData;
	}
	
	//파일을 저장하는 함수
	private void saveData(String file) throws IOException
	{
		FileWriter save = new FileWriter("data.txt",true);

		try 
		{
			save.write(file+"\n");
			save.close();
		}
		catch(Exception e)
		{
			System.out.println("OutError : " + e);
			e.printStackTrace();
		}
	}
	
}

