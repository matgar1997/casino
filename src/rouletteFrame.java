import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class rouletteFrame extends JFrame implements ActionListener
{
	JPanel roulettePanel = new JPanel();
	
	private ImageIcon rouletteImage = new ImageIcon("rouletteImage.jpg");
	
	JButton even = new JButton("EVEN");
	JButton odd = new JButton("ODD");
	JButton red = new JButton("RED");
	JButton black = new JButton("BLACK");
	JButton submit = new JButton("SUBMIT");
	JButton reset = new JButton("RESET");	
	JButton first = new JButton("1-15");
	JButton second = new JButton("16-31");
	JButton third = new JButton("32-50");
	JButton back = new JButton("BACK");
	
	JTextField rouletteText = new JTextField(10);
	
	JLabel rouletteDisplay = new JLabel("either click a button or enter a number 1-50 and click submit");
	JLabel imageDisplay5;
	
	String userNumString;
	int answer, userNum;
	
	Random create = new Random();
	
	JFrame mainFrame;
	
	public rouletteFrame(JFrame mainFrame)
	{
		super("roulette");
		
		rouletteImage = new ImageIcon(getClass().getResource("rouletteImage.jpg"));
		imageDisplay5 = new JLabel(rouletteImage);
		
		this.mainFrame = mainFrame;
		
		even.addActionListener(this);
		odd.addActionListener(this);
		red.addActionListener(this);
		black.addActionListener(this);
		submit.addActionListener(this);	
		reset.addActionListener(this);
		first.addActionListener(this);
		second.addActionListener(this);
		third.addActionListener(this);
		back.addActionListener(this);		
		
		this.setResizable(false);
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		
		roulettePanel.add(even);
		roulettePanel.add(odd);
		roulettePanel.add(red);
		roulettePanel.add(black);
		roulettePanel.add(rouletteText);
		roulettePanel.add(submit);
		roulettePanel.add(rouletteDisplay);
		roulettePanel.add(first);
		roulettePanel.add(second);
		roulettePanel.add(third);
		roulettePanel.add(reset);
		roulettePanel.add(back);
		
		roulettePanel.add(imageDisplay5);
		this.add(roulettePanel);
		
		reset.doClick();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == reset)
		{
			answer = create.nextInt(50)+1;
			rouletteDisplay.setText("either click a button or enter a number 1-50 and click submit");
		}
		
		if(e.getSource() == even)
		{
			if(answer % 2 == 0)
			{
				rouletteDisplay.setText("You Win");
				money.amount += 2;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the answer was "+answer);
				money.amount -= 2;
				money.moneyCheck();
			}	
		}
		
		if(e.getSource() == odd)
		{
			if(answer % 2 == 0)
			{
				rouletteDisplay.setText("You Lose the answer was "+answer);
				money.amount -= 2;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Win the answer was "+answer);
				money.amount += 2;
				money.moneyCheck();
			}	
		}
		
		if(e.getSource() == red)
		{
			if(answer % 2 == 0)
			{
				rouletteDisplay.setText("You Win");
				money.amount += 2;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the color was black");
				money.amount -= 2;
				money.moneyCheck();
			}	
		}
		
		if(e.getSource() == black)
		{
			if(answer % 2 == 0)
			{
				rouletteDisplay.setText("You Lose the color was red");
				money.amount -= 2;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Win");
				money.amount += 2;
				money.moneyCheck();
			}	
		}
		
		if(e.getSource() == submit)
		{
			userNumString = rouletteText.getText();
			userNum = Integer.parseInt(userNumString);
			if(userNum == answer)
			{
				rouletteDisplay.setText("WOW that is a 1/50 chance and you win");
				money.amount += 20;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the answer was "+answer);
				money.amount -= 4;
				money.moneyCheck();
			}
			rouletteText.setText("");
		}
		
		if(e.getSource() == first)
		{
			if(answer <= 15 && answer >= 1)
			{
				rouletteDisplay.setText("You Win the answer was "+answer);
				money.amount += 7;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the answerwas "+answer);
				money.amount -= 5;
				money.moneyCheck();
			}
		}
		
		if(e.getSource() == second)
		{
			if(answer <= 31 && answer >= 16)
			{
				rouletteDisplay.setText("You Win the answer was "+answer);
				money.amount += 7;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the answer was "+answer);
				money.amount -= 5;
				money.moneyCheck();
			}
		}
		
		if(e.getSource() == third)
		{
			if(answer >= 32 && answer <= 50)
			{
				rouletteDisplay.setText("You Win the answer was "+answer);
				money.amount += 7;
				money.moneyCheck();
			}
			else
			{
				rouletteDisplay.setText("You Lose the answer was "+answer);
				money.amount -= 5;
				money.moneyCheck();
			}
		}
		
		if(e.getSource() == back)
		{
			this.setVisible(false);
			mainFrame.setVisible(true);
		}
	}

}
