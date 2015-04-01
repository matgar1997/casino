import javax.swing.*;

public class money 
{
	public static int amount = 100;
	JButton exit = new JButton();
	static boolean madeIt = false;
	
	
	public static void moneyCheck()
	{
		
		if(amount <= 0)
		{
			JOptionPane.showMessageDialog(null, "I think its time for you to go you are out of money", "You lost to the house", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		if(amount <= 10 && madeIt == false)
		{
			JOptionPane.showMessageDialog(null, "I recommend you talk to the loan shark", "You are almost broke", JOptionPane.INFORMATION_MESSAGE);
			madeIt = true;
		}
		
		if(amount >= 1000)
		{
			JOptionPane.showMessageDialog(null, "WOW you won at least $1000 unfortunatly the casino is closed now", "AMAZING", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	
	
	
}
