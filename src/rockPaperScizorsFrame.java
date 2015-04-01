import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class rockPaperScizorsFrame extends JFrame implements ActionListener
{
	private ImageIcon RPSImage = new ImageIcon("RPSImage.jpg");
	
	Random create = new Random();
	
	JButton rock = new JButton("Rock");
	JButton Paper = new JButton("Paper");
	JButton Scizors = new JButton("Sizzors");
	JButton reset = new JButton("RESET");
	JButton back = new JButton("BACK");
	
	JLabel rockPaperScizorsDisplay = new JLabel("make your move");
	JLabel imageDisplay;
	
	JPanel rockPaperScizorsPanel = new JPanel();
	
	int answer, user;
	
	JFrame mainFrame;
	
	
	public rockPaperScizorsFrame(JFrame mainFrame)
	{
		
		super("rock Paper Scizors");
		
		RPSImage = new ImageIcon(getClass().getResource("RPSImage.jpg"));
		
		imageDisplay = new JLabel(RPSImage);
		
		this.mainFrame = mainFrame;
		this.add(imageDisplay);
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		
		
		rockPaperScizorsPanel.add(rock);
		rockPaperScizorsPanel.add(Paper);
		rockPaperScizorsPanel.add(Scizors);
		rockPaperScizorsPanel.add(reset);
		rockPaperScizorsPanel.add(rockPaperScizorsDisplay);
		rockPaperScizorsPanel.add(back);
		rockPaperScizorsPanel.add(imageDisplay);
		
		this.add(rockPaperScizorsPanel);
		this.setResizable(false);
		
		rock.addActionListener(this);
		Paper.addActionListener(this);
		Scizors.addActionListener(this);
		reset.addActionListener(this);
		back.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		answer = create.nextInt(3);
		
		if(e.getSource() == rock) //rock = 0, paper = 1, sizzors = 2
		{
			if(answer == 0)
			{
				rockPaperScizorsDisplay.setText("its a tie");
				money.amount -=3;
				money.moneyCheck();
			}
			else if(answer == 1)
			{
				rockPaperScizorsDisplay.setText("You lose they did paper");
				money.amount -= 6;
				money.moneyCheck();
			}
			else if(answer == 2)
			{
				rockPaperScizorsDisplay.setText("You win they did sizzors");
				money.amount += 6;
				money.moneyCheck();
			}
				
		}
		
		if(e.getSource() == Paper) //rock = 0, paper = 1, sizzors = 2
		{
			if(answer == 0)
			{
				rockPaperScizorsDisplay.setText("You win they did rock");
				money.amount += 6;
				money.moneyCheck();
			}
			else if(answer == 1)
			{
				rockPaperScizorsDisplay.setText("Its a tie");
				money.amount -=3;
				money.moneyCheck();
			}
			else if(answer == 2)
			{
				rockPaperScizorsDisplay.setText("You lose they did sizzors");
				money.amount -= 6;
				money.moneyCheck();
			}
				
		}
		
		if(e.getSource() == Scizors) //rock = 0, paper = 1, sizzors = 2
		{
			if(answer == 0)
			{
				rockPaperScizorsDisplay.setText("You lose they did rock");
				money.amount -= 6;
				money.moneyCheck();
			}
			else if(answer == 1)
			{
				rockPaperScizorsDisplay.setText("You win they did paper");
				money.amount += 6;
				money.moneyCheck();
			}
			else if(answer == 2)
			{
				rockPaperScizorsDisplay.setText("its a tie");
				money.amount -=3;
				money.moneyCheck();
			}
				
		}
		
		if(e.getSource() == reset)
		{
			answer = 3;
			rockPaperScizorsDisplay.setText("make your move");
			
		}
		
		if(e.getSource() == back)
		{
			this.setVisible(false);
			mainFrame.setVisible(true);
		}
	}
}




