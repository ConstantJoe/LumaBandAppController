package luma.band;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

public class ScrollAndVolumeControl {
	private String os;
	private String userDir;
	
	public ScrollAndVolumeControl(String operatingSystem, String userDirect)
	{
		this.os = operatingSystem;
		this.userDir = userDirect;
	}
	
	public void scrollUp() throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseWheel(-5); //negative is away from user
	}
	
	public void scrollDown() throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseWheel(5); //positive is towards from user
		
		/*int counter = 0; //this bit is just for demonstration purposes
		while(counter < 10)
		{
			robot.mouseWheel(5); //negative is away from user
			 robot.delay(500);
			counter++; 
			System.out.println("loop");
		}*/
	}
	
	public void volumeUp()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"" + userDir + "\\nircmd.exe\" changesysvolume 2000";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "amixer -D pulse sset Master 5%+";
		}
		
		try {
			//Process process = new ProcessBuilder("nircmd.exe","param1","param2").start();
			
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void volumeDown()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"" + userDir + "\\nircmd.exe\" changesysvolume -2000";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "amixer -D pulse sset Master 5%-";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
