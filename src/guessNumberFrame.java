import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class guessNumberFrame extends JFrame implements ActionListener
{
	Random create = new Random();
	
	private ImageIcon guessNumberImage = new ImageIcon("numberGuessImage.jpg");
	
	int answer, userNum;
	String user;
	
	JButton submit = new JButton("SUBMIT");
	JButton reset = new JButton("RESET");
	JLabel guessNumberDisplay = new JLabel("try to guess the number is between 1-10");
	JLabel imageDisplay4;
	
	JButton back = new JButton("BACK");
	
	JTextField guessNumberText = new JTextField(10);
	
	JFrame mainFrame;
	
	public guessNumberFrame(JFrame mainFrame)
	{
		super("Guess the Number");
		
		guessNumberImage = new ImageIcon(getClass().getResource("numberGuessImage.jpg"));
		imageDisplay4 = new JLabel(guessNumberImage);
		
		this.mainFrame = mainFrame;
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		
		JPanel guessNumberPanel = new JPanel();
		
		guessNumberPanel.add(guessNumberText);
		guessNumberPanel.add(guessNumberDisplay);
		guessNumberPanel.add(submit);
		guessNumberPanel.add(reset);
		guessNumberPanel.add(back);
		
		submit.addActionListener(this);
		reset.addActionListener(this);
		back.addActionListener(this);
		guessNumberPanel.add(imageDisplay4);
		this.add(guessNumberPanel);
		
		this.setResizable(false);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == submit)
		{
			answer = create.nextInt(10)+1;
			user = guessNumberText.getText();
			userNum = Integer.parseInt(user);
			
			if(userNum == answer)
			{
				guessNumberDisplay.setText("You win you must be lucky");
				money.amount += 10;
				money.moneyCheck();
			}
			else
			{
				guessNumberDisplay.setText("you lose the answer is "+answer);
				money.amount -= 5;
				money.moneyCheck();
			}
		}
		if(e.getSource() == reset)
		{
			guessNumberDisplay.setText("try to guess the number is between 1-10");
			guessNumberText.setText("");
			guessNumberText.requestFocus();
		}
		
		if(e.getSource() == back)
		{
			this.setVisible(false);
			mainFrame.setVisible(true);
		}
	}
	

}
