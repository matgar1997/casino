import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class casino implements ActionListener
{	
	static JFrame frame = new JFrame("Welcome to the casino");
	static evenOrOddFrame evenOrOddFrame = new evenOrOddFrame(frame);
	static rouletteFrame rouletteFrame = new rouletteFrame(frame);
	static blackJackFrame blackJackFrame = new blackJackFrame(frame);
	static guessNumberFrame guessNumberFrame = new guessNumberFrame(frame);
	static rockPaperScizorsFrame rockPaperScizorsFrame = new rockPaperScizorsFrame(frame);
	
	static money money = new money();
	
	static JPanel mainPanel = new JPanel();
	
	JPanel top = new JPanel();
	JPanel chooseGame = new JPanel();
	JPanel bottom = new JPanel();
	JPanel east = new JPanel();
	JPanel west = new JPanel();
	
	JButton evenOrOdd = new JButton("Even or Odd");
	JButton blackJack = new JButton("Black Jack");
	JButton roulette = new JButton("roulette");
	JButton guessNumber = new JButton("guess the number");
	JButton rockPaperScizors = new JButton("rock/paper/sizzors");
	JButton moneyButton = new JButton("Check Money");
	JButton loanShark = new JButton("LOAN SHARK");
	JButton leave = new JButton("Leave the casino");
	
	
	JLabel filler = new JLabel("                                   ");
	JLabel filler1 = new JLabel("                                   ");
	JLabel sign1 = new JLabel("PLAY WIN DRINK");
	JLabel sign2 = new JLabel("ALL NIGHT LONG");
	JLabel sign3 = new JLabel("$$$BIG MONEY$$$");
	JLabel sign4 = new JLabel("WINNERS EVERY NIGHT");
	JLabel moneyDisplay = new JLabel("");
	
	boolean in = false;
	
	public ImageIcon happyImage = new ImageIcon("happyImage(1).jpg");
	public ImageIcon sadImage = new ImageIcon("sadImage.jpg");
	public ImageIcon okImage = new ImageIcon("okImage.jpg");
	
	
	public static void main(String[] args) 
	{
		new casino();
	}
	
	public casino()
	{
		
		happyImage = new ImageIcon(getClass().getResource("happyImage (1).jpg"));
		sadImage = new ImageIcon(getClass().getResource("sadImage.jpg"));
		okImage = new ImageIcon(getClass().getResource("okImage.jpg"));
		
		evenOrOdd.addActionListener(this);
		blackJack.addActionListener(this);
		roulette.addActionListener(this);
		guessNumber.addActionListener(this);
		rockPaperScizors.addActionListener(this);
		moneyButton.addActionListener(this);
		loanShark.addActionListener(this);
		leave.addActionListener(this);
		
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		mainPanel.setLayout(new BorderLayout());
		
		west.add(filler);
		east.add(filler1);
		
		chooseGame.setLayout(new BoxLayout(chooseGame, BoxLayout.Y_AXIS));
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(evenOrOdd);
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(blackJack);
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(roulette);
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(guessNumber);
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(rockPaperScizors);
		chooseGame.add(Box.createVerticalStrut(35));
		chooseGame.add(moneyButton);
		chooseGame.add(Box.createVerticalStrut(25));
		chooseGame.add(moneyDisplay);
		chooseGame.add(Box.createVerticalStrut(15));
		chooseGame.add(loanShark);
		chooseGame.add(Box.createVerticalStrut(35));
		chooseGame.add(leave);
		
		west.add(sign1);
		west.add(Box.createVerticalStrut(30));
		west.add(sign2);
		west.add(Box.createVerticalStrut(30));
		east.add(sign3);
		east.add(Box.createVerticalStrut(30));
		east.add(sign4);
		east.add(Box.createVerticalStrut(30));
		
		mainPanel.add(east, BorderLayout.EAST);
		mainPanel.add(west, BorderLayout.WEST);
		mainPanel.add(chooseGame, BorderLayout.CENTER);
		mainPanel.add(top, BorderLayout.NORTH);
		mainPanel.add(bottom, BorderLayout.SOUTH);
		
		chooseGame.setLayout(new BoxLayout(chooseGame, BoxLayout.Y_AXIS));
		
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == evenOrOdd)
		{
			frame.setVisible(false);
			blackJackFrame.setVisible(false);
			rouletteFrame.setVisible(false);
			guessNumberFrame.setVisible(false);
			rockPaperScizorsFrame.setVisible(false);
			evenOrOddFrame.setVisible(true);
		}
		
		if(e.getSource() == blackJack)
		{
			frame.setVisible(false);
			rouletteFrame.setVisible(false);
			guessNumberFrame.setVisible(false);
			rockPaperScizorsFrame.setVisible(false);
			evenOrOddFrame.setVisible(false);
			blackJackFrame.setVisible(true);
		}
		
		if(e.getSource() == roulette)
		{
			frame.setVisible(false);
			blackJackFrame.setVisible(false);
			guessNumberFrame.setVisible(false);
			rockPaperScizorsFrame.setVisible(false);
			evenOrOddFrame.setVisible(false);
			rouletteFrame.setVisible(true);
		}
		
		if (e.getSource() == guessNumber)
		{
			frame.setVisible(false);
			blackJackFrame.setVisible(false);
			rouletteFrame.setVisible(false);
			rockPaperScizorsFrame.setVisible(false);
			evenOrOddFrame.setVisible(false);
			guessNumberFrame.setVisible(true);
		}
		
		if(e.getSource() == rockPaperScizors)
		{
			frame.setVisible(false);
			blackJackFrame.setVisible(false);
			rouletteFrame.setVisible(false);
			guessNumberFrame.setVisible(false);
			evenOrOddFrame.setVisible(false);
			rockPaperScizorsFrame.setVisible(true);
		}
		
		if(e.getSource() == moneyButton)
		{
			moneyDisplay.setText("you have $"+money.amount);
		}
		
		if(e.getSource() == loanShark && in == false)
		{
			money.amount +=20;
			loanShark.setText("PAY BACK $30");
			leave.setEnabled(false);
			in = true;
			return;
		}
		
		if(e.getSource() == loanShark && in == true)
		{
			if (money.amount >= 30)
			{
				money.amount -=30;
				leave.setEnabled(true);
				loanShark.setText("LOAN SHARK");
				loanShark.setEnabled(false);
			}
		}
		
		if(e.getSource() == leave)
		{
			if(100 < money.amount)
			{
				int mG;
				mG = 100 - money.amount;
				mG = mG * -1;
				JOptionPane.showMessageDialog(null, "you leave with a profit of $"+mG, "congradulations", JOptionPane.INFORMATION_MESSAGE, happyImage);
			}
			
			if(100 > money.amount)
			{
				int mL;
				mL = money.amount - 100;
				mL = mL * -1;
				JOptionPane.showMessageDialog(null, "you leave with a loss of $"+mL, "ouch", JOptionPane.INFORMATION_MESSAGE, sadImage);
			}
			
			if(100 == money.amount)
			{
				JOptionPane.showMessageDialog(null, "not bad you broke even, neither won nor lost money", "ok", JOptionPane.INFORMATION_MESSAGE, okImage);
			}
			System.exit(0);
		}
	}

}
