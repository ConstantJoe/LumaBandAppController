package luma.band;

import java.io.IOException;

public class VLC {
	private String os; 
	private String userDir;
	
	public VLC(String operatingSystem, String userDirect)
	{
		this.os = operatingSystem;
		this.userDir = userDirect;
	}
	
	public void launch()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe\""; //need to test
		}
		else if(os.equals("Linux"))
		{
			myCommand = "vlc"; 
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
			myCommand = "cmd /c taskkill /F /IM vlc.exe";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "pkill vlc";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playPause()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"" + userDir + "\\CLMControl\" vlc -pp";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.vlc /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.PlayPause ";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rewind()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand =  "cmd /c \"" + userDir + "\\CLMControl\" vlc -pt";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.vlc /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.Seek -1000000";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fastForward()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand =  "cmd /c \"" + userDir + "\\CLMControl\" vlc -nt";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.vlc /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.Seek 1000000";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
