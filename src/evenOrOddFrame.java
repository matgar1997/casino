import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class evenOrOddFrame extends JFrame implements ActionListener
{	
	money money = new money();
	
	private ImageIcon evenOrOddImage = new ImageIcon("evenOrOddImage.jpg");
	
	int answer;
	
	JButton even = new JButton("EVEN");
	JButton odd = new JButton("ODD");
	JButton reset = new JButton("RESET");
	JButton back = new JButton("GO BACK");
	
	Random create = new Random();
	
	JLabel evenOrOddDisplay = new JLabel("Make your guess is the number odd or even");
	JLabel imageDisplay3;
	
	JFrame mainFrame;
	
	public evenOrOddFrame(JFrame mainFrame) 
	{
		super("Even or Odd");
		
		evenOrOddImage = new ImageIcon(getClass().getResource("evenOrOddImage.jpg"));
		imageDisplay3 = new JLabel(evenOrOddImage);
		
		this.mainFrame = mainFrame;
		
		
		answer = create.nextInt(10)+1;
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(false);
		
		
		JPanel evenOrOddPanel = new JPanel();	
		
		
		even.addActionListener(this);
		odd.addActionListener(this);
		reset.addActionListener(this);
		back.addActionListener(this);
		

		evenOrOddPanel.add(even);
		evenOrOddPanel.add(odd);
		evenOrOddPanel.add(evenOrOddDisplay);
		evenOrOddPanel.add(reset);
		evenOrOddPanel.add(back);
		evenOrOddPanel.add(imageDisplay3);
		
		this.add(evenOrOddPanel);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == even && answer % 2 == 0)
		{
			evenOrOddDisplay.setText("You Win");
			money.amount += 2;
			money.moneyCheck();
		}
		
		if(e.getSource() == even && answer % 2 != 0)
		{
			evenOrOddDisplay.setText("You Lose");
			money.amount -= 2; 
			money.moneyCheck();
		}
		
		if(e.getSource() == odd && answer % 2 != 0)
		{
			evenOrOddDisplay.setText("You Win");
			money.amount += 2;
			money.moneyCheck();
		}
		
		if(e.getSource() == odd && answer % 2 == 0)
		{
			evenOrOddDisplay.setText("You Lose");
			money.amount -= 2; 
			money.moneyCheck();
		}
		
		if(e.getSource() == reset)
		{
			evenOrOddDisplay.setText("Make your guess is the number odd or even");
			answer = create.nextInt(10)+1;
			money.moneyCheck();
		}
		
		if(e.getSource() == back)
		{
			mainFrame.setVisible(true);
			this.setVisible(false);
		}
		
	}

}
