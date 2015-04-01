import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
//import casino;


public class blackJackFrame extends JFrame implements ActionListener
{
	int userCards = 0, first, second, newCard;
	
	private ImageIcon blackJackImage = new ImageIcon("blackJackImage.jpg");
	
	JPanel blackJackPanel = new JPanel();
	
	JButton hitMe = new JButton("Hit Me");
	JButton stop = new JButton ("hold");
	JButton reset = new JButton("RESET");
	JButton back = new JButton("BACK");
	
	JLabel blackJackDisplay = new JLabel();
	JLabel imageDisplay2;
	
	Random create = new Random();
	
	JFrame mainFrame;
	
	public blackJackFrame(JFrame mainFrame)
	{
		super ("Black Jack");
		
		blackJackImage = new ImageIcon(getClass().getResource("blackJackImage.jpg"));
		imageDisplay2 = new JLabel(blackJackImage);
		
		this.mainFrame = mainFrame;
		
		
		hitMe.addActionListener(this);
		stop.addActionListener(this);
		reset.addActionListener(this);
		back.addActionListener(this);
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(false);
		
		blackJackPanel.add(blackJackDisplay);
		blackJackPanel.add(hitMe);
		blackJackPanel.add(stop);
		blackJackPanel.add(reset);
		blackJackPanel.add(back);
		blackJackPanel.add(imageDisplay2);
		this.add(blackJackPanel);
		
		reset.doClick();
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == hitMe)
		{
			newCard = create.nextInt(10)+1;
			userCards += newCard;
			
			if (userCards > 21)
			{
				blackJackDisplay.setText("You Lose");
				money.amount -= 3; 
				money.moneyCheck();
			}
			else
			{
				blackJackDisplay.setText("your cards add up to "+userCards);
			}
		}
		
		if(e.getSource() == stop)
		{
			if(userCards <= 21)
			{
				blackJackDisplay.setText("You Win");
				money.amount +=4;
				money.moneyCheck();
			}
		}
		
		if(e.getSource() == reset)
		{
			first = create.nextInt(10)+1;
			second = create.nextInt(10)+1;
			userCards = first + second;
			
			blackJackDisplay.setText("your cards add up to "+userCards);
		}
		
		if(e.getSource() == back)
		{
			this.setVisible(false);
			mainFrame.setVisible(true);
		}
	}
	

}
