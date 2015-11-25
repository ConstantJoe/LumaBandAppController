package luma.band;

import java.io.IOException;

public class Spotify {
	private String os;
	private String userDir;
	
	public Spotify(String operatingSystem, String userDirect)
	{
		this.os = operatingSystem;
		this.userDir = userDirect;
	}
	
	public void launch()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"C:\\Users\\Margarita\\AppData\\Roaming\\Spotify\\spotify.exe\"";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "spotify";
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
			myCommand = "cmd /c taskkill /F /IM spotify.exe";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "pkill spotify";
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
			
			myCommand = "cmd /c \"" + userDir + "\\CLMControl\" spotify -pp";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.spotify /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.PlayPause ";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void previous()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"" + userDir + "\\CLMControl\" spotify -pt";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.spotify /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.Previous";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void skipSong()
	{
		String myCommand = "";
		if(os.equals("Windows"))
		{
			myCommand = "cmd /c \"" + userDir + "\\CLMControl\" spotify -nt";
		}
		else if(os.equals("Linux"))
		{
			myCommand = "qdbus org.mpris.MediaPlayer2.spotify /org/mpris/MediaPlayer2 org.mpris.MediaPlayer2.Player.Next";
		}
		
		try {
			Runtime.getRuntime().exec(myCommand);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
