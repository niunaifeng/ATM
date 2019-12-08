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
        setBackground(new Color(128,128,255));
        final Label title = new Label("Bank", Label.CENTER);
        add(title,BorderLayout.NORTH);
        Panel BankHandler = new Panel();
        Button confirm = new Button("Confirm");
        Button terminate = new Button("Terminate");
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
        BankHandler.add(confirm, BorderLayout.WEST);
        BankHandler.add(terminate, BorderLayout.EAST);
        add(BankHandler, BorderLayout.CENTER);
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
	
	private BankHandler bankHandler;
	
	
}
