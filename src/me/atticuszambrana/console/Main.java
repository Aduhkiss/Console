package me.atticuszambrana.console;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import me.atticuszambrana.console.center.CommandCenter;
import me.atticuszambrana.console.center.PermissionCenter;
import me.atticuszambrana.console.common.Module;
import me.atticuszambrana.console.common.Module.ModuleType;
import me.atticuszambrana.console.common.Rank;
import me.atticuszambrana.console.util.HWID;
import me.atticuszambrana.console.util.StringUtil;

public class Main {
	public static void main(String[] args) {
		//TODO: Code an authentication system maybe?
		
		// Start the command center
		CommandCenter.register();
		
		//TODO: Make this a lot better at some point in time
		try {
			System.out.println("My HWID is: " + HWID.getHWID());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Welcome! Please enter a command, or type help to view all commands.");
		
		check();
	}
	
	private static void check() {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		boolean found = false;
		
		for(Module m : CommandCenter.getModules()) {
			if(m.getType() == ModuleType.COMMAND) {
				if(in.toLowerCase().indexOf(m.getName()) >= 0) {
					
					// Then tell the computer that we found the command that we want to run
					found = true;
					
					// Make a new String[] for the arguments here
					String[] arr = StringUtil.toArray(in);
					
					// Make sure that this machine is allowed to execute this command
					Rank myRank = PermissionCenter.getRank();
					Rank rankRequired = m.getRankRequired();
					
					if(myRank.getLevel() >= rankRequired.getLevel()) {
						m.execute(arr);
					} else {
						System.out.println("I'm sorry, but you do not have permission to perform this command.");
					}
				}
			}
		}
		
		// If we didn't catch any commands, then tell the user it was an unknown command
		if(!found) {
			System.out.println("Unknown Command. Type help for a list of all commands.");
		}
		
		check();
	}
}
