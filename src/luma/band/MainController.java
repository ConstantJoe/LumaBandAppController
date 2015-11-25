package luma.band;
import java.util.Scanner;
import java.awt.AWTException;

public class MainController {
	
	public static String os = "Windows";
	public static String userDir;
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println(System.getProperty("user.dir"));
		userDir = getUserDir();
		while(true)
		{
			System.out.println("Choose app:");
			System.out.println("1. Chrome");
			System.out.println("2. Firefox");
			System.out.println("3. VLC Player");
			System.out.println("4. Spotify");
			System.out.println("Type 'e' to quit");

			String input = keyboard.next();

			if(input.equals("1"))
			{
				try {
					controlChrome(keyboard);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(input.equals("2"))
			{
				try {
					controlFirefox(keyboard);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(input.equals("3"))
			{
				controlVLC(keyboard);
			}
			else if(input.equals("4"))
			{
				controlSpotify(keyboard);
			}
			else if(input.equals("e"))
			{
				break;
			}
			else
			{
				System.out.println("Wrong input, try again");
			}
		}
	}

	public static void controlChrome(Scanner keyboard) throws AWTException
	{
		System.out.println("Choose Function:");
		System.out.println("1. Launch Chrome");
		System.out.println("2. Launch favourited website");
		System.out.println("3. Close Chrome");
		System.out.println("4. Scroll up");
		System.out.println("5. Scroll down");
		System.out.println("6. Volume up");
		System.out.println("7. Volume down");
		System.out.println("Type 'e' to go back");

		Chrome chrome = new Chrome(os);
		ScrollAndVolumeControl cont = new ScrollAndVolumeControl(os, userDir);
		while(true)
		{
			
			String input = keyboard.next();
			boolean leaveLoop = false;
			
			switch(input){
			case "1": chrome.launch(); 							break;
			case "2": chrome.launchWebsite("www.boards.ie");    break;
			case "3": chrome.close();   						break;
			case "4": cont.scrollUp();   						break;
			case "5": cont.scrollDown(); 						break;
			case "6": cont.volumeUp();   						break;
			case "7": cont.volumeDown();						break;
			case "e": leaveLoop = true;							break;
			default:  System.out.println("Wrong input, try again");
			}
			
			if(leaveLoop) break;
		}
	}

	public static void controlFirefox(Scanner keyboard) throws AWTException
	{
		System.out.println("Choose Function:");
		System.out.println("1. Launch Firefox");
		System.out.println("2. Launch favourited website");
		System.out.println("3. Close Firefox");
		System.out.println("4. Scroll up");
		System.out.println("5. Scroll down");
		System.out.println("6. Volume up");
		System.out.println("7. Volume down");
		System.out.println("Type 'e' to go back");
		
		Firefox firefox = new Firefox(os);
		ScrollAndVolumeControl cont = new ScrollAndVolumeControl(os, userDir);
		while(true)
		{
			
			String input = keyboard.next();
			boolean leaveLoop = false;
			
			switch(input){
			case "1": firefox.launch(); 						break;
			case "2": firefox.launchWebsite("www.boards.ie");   break;
			case "3": firefox.close();   						break;
			case "4": cont.scrollUp();   						break;
			case "5": cont.scrollDown(); 						break;
			case "6": cont.volumeUp();   						break;
			case "7": cont.volumeDown();						break;
			case "e": leaveLoop = true;							break;
			default:  System.out.println("Wrong input, try again");
			}
			
			if(leaveLoop) break;
		}
	}

	//http://sourceforge.net/projects/windbus/?source=typ_redirect
	//http://stackoverflow.com/questions/16966357/windbus-sample-application-does-not-start-could-not-parse-server-address-error
	//THIS LOOKS GOOD: https://commandlinemedia.codeplex.com/documentation
	public static void controlVLC(Scanner keyboard)
	{
		System.out.println("Choose Function:");
		System.out.println("1. Launch VLC");
		System.out.println("2. Close VLC");
		System.out.println("3. Play/Pause");
		System.out.println("4. Rewind");
		System.out.println("5. Fast forward");
		System.out.println("6. Volume up");
		System.out.println("7. Volume down");
		System.out.println("Type 'e' to go back");
		
		VLC vlc = new VLC(os, userDir);
		ScrollAndVolumeControl cont = new ScrollAndVolumeControl(os, userDir);
		
		while(true)
		{
			String input = keyboard.next();
			boolean leaveLoop = false;
			
			switch(input){
			case "1": vlc.launch(); 							break;
			case "2": vlc.close();						 		break;
			case "3": vlc.playPause();   						break;
			case "4": vlc.rewind();   							break;
			case "5": vlc.fastForward(); 						break;
			case "6": cont.volumeUp();   						break;
			case "7": cont.volumeDown();						break;
			case "e": leaveLoop = true;							break;
			default:  System.out.println("Wrong input, try again");
			}
			
			if(leaveLoop) break;
		}
	}
	
	public static void controlSpotify(Scanner keyboard)
	{
		System.out.println("Choose Function:");
		System.out.println("1. Launch Spotify");
		System.out.println("2. Close Spotify");
		System.out.println("3. Play/Pause");
		System.out.println("4. Previous / back to start");
		System.out.println("5. Skip song");
		System.out.println("6. Volume up");
		System.out.println("7. Volume down");
		System.out.println("Type 'e' to go back");
		
		Spotify spotify = new Spotify(os, userDir);
		ScrollAndVolumeControl cont = new ScrollAndVolumeControl(os, userDir);
		
		while(true)
		{
			String input = keyboard.next();
			boolean leaveLoop = false;
			
			switch(input){
			case "1": spotify.launch(); 							break;
			case "2": spotify.close();						 		break;
			case "3": spotify.playPause();   						break;
			case "4": spotify.previous();   						break;
			case "5": spotify.skipSong(); 							break;
			case "6": cont.volumeUp();   							break;
			case "7": cont.volumeDown();							break;
			case "e": leaveLoop = true;								break;
			default:  System.out.println("Wrong input, try again");
			}
			
			if(leaveLoop) break;
		}
	}
	public static String getUserDir()
	{
		String userdir = System.getProperty("user.dir");
		String userdirMod = "";
		for(int i=0;i<userdir.length();i++)
		{
			if(userdir.charAt(i) == '\\')
			{
				userdirMod = userdirMod.concat("\\\\");
			}
			else
			{
				userdirMod = userdirMod.concat(userdir.charAt(i) + "");
			}
		}
		return userdirMod;
	}
}
