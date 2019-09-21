package me.atticuszambrana.console.common;

public enum Rank {
	
	/*
	 * Yes, we will have a working permission system in here as well.
	 * 
	 * This will be based off of HWID's
	 * 
	 * Author: Atticus Zambrana
	 */
	
	DEFAULT("None", 0),
	ADMIN("Admin", 5),
	SYSTEM_ADMIN("System Administrator", 10),
	DEVELOPER("Developer", 20);
	
	String name;
	int level;
	
	Rank(String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}
}
