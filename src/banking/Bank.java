package banking;

public class Bank {
	private int handleResult = 0;
	
	public void confirm()
	{
		handleResult = 1;
	}
	public void terminate()
	{
		handleResult = -1;
	}
	
	public void setHandleResult(int result)
	{
		handleResult = result;
	}
	
	public int getHandleResult()
	{
		return handleResult;
	}
}
