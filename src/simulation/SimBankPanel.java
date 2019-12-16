package simulation;
import atm.ATM;

import java.awt.*;
import java.awt.event.*;
import banking.BankHandler;


public class SimBankPanel extends Panel{
	public SimBankPanel()
	{
		bankHandler = new BankHandler();
		setLayout(new BorderLayout(5, 5));
        setBackground(new Color(171,241,248));
        title = new Label("Bank", Label.CENTER);
        add(title,BorderLayout.WEST);
        buttonPanel = new Panel();
        confirm = new Button("Confirm");
        terminate = new Button("Terminate");
        confirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		confirm();
        	}
        });
        terminate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		
        		terminate();
        	}
        });
        buttonPanel.add(confirm, BorderLayout.WEST);
        buttonPanel.add(terminate, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.CENTER);
	}
	synchronized public boolean handle() 
	{
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{}
					
		return bankHandler.getHandleResult();
	}
	private synchronized void confirm()
	{
		bankHandler.setHandleResult(true);
		notify();
	}
	private synchronized void terminate()
	{
		bankHandler.setHandleResult(false);
		notify();
	}
	
	public void changeNightMode()
	{
		this.setBackground(Color.black);
		title.setBackground(Color.black);
		title.setForeground(Color.white);
		confirm.setBackground(Color.black);
		confirm.setForeground(Color.white);
		terminate.setBackground(Color.black);
		terminate.setForeground(Color.white);
		buttonPanel.setBackground(Color.black);
	}
	
	public void changeDayMode()
	{
		this.setBackground(new Color(171,241,248));
		title.setBackground(new Color(171,241,248));
		title.setForeground(Color.black);
		confirm.setBackground(Color.white);
		confirm.setForeground(Color.black);
		terminate.setBackground(Color.white);
		terminate.setForeground(Color.black);
		buttonPanel.setBackground(new Color(171,241,248));
	}
	
	private BankHandler bankHandler;
	private Label title;
	private Button confirm;
	private Button terminate;
	private Panel buttonPanel;
	
}
