package luma.band;

import java.io.IOException;

public class Chrome {
	private String os; 
	
	public Chrome(String operatingSystem)
	{
		this.os = operatingSystem;
	}
	
	public void launch()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c start chrome";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "chromium-browser";
		}
		
		System.out.println("start chrome");
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
			myCommand = "cmd /c start chrome --newtab " + website;
		}
		else if(os.equals("Linux"))
		{
			myCommand = "chromium-browser " + website;
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
			myCommand = "cmd /c taskkill /F /IM chrome.exe";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "pkill chromium-browse";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
