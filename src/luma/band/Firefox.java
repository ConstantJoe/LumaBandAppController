package luma.band;

import java.io.IOException;

public class Firefox {
	private String os; 
	
	public Firefox(String operatingSystem)
	{
		this.os = operatingSystem;
	}
	
	public void launch()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c start firefox";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "firefox";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchWebsite(String website)
	{	
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c start firefox -new-tab " + website; //need to test
		}
		else if(os.equals("Linux"))
		{
			myCommand = "firefox " + website;
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void close()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c taskkill /F /IM firefox.exe";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "pkill firefox";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
