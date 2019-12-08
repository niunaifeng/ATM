package banking;

public class BankHandler {
	private boolean handleResult;
	
	public BankHandler()
	{
		handleResult = true;
	}
	
	
	public void setHandleResult(boolean result)
	{
		handleResult = result;
	}
	
	public boolean getHandleResult()
	{
		return handleResult;
	}
	
	
	
}