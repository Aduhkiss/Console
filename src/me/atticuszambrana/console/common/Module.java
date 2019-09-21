package me.atticuszambrana.console.common;

public abstract class Module {
	
	String command;
	String description;
	ModuleType type;
	Rank rankRequired;
	
	public Module(String command, String description, ModuleType type) {
		this.command = command;
		this.description = description;
		this.type = type;
		this.rankRequired = Rank.DEFAULT;
	}
	
	public Module(String command, String description, ModuleType type, Rank rankRequired) {
		this.command = command;
		this.description = description;
		this.type = type;
		this.rankRequired = rankRequired;
	}
	
	public String getName() {
		return command;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ModuleType getType() {
		return type;
	}
	
	public Rank getRankRequired() {
		return rankRequired;
	}
	
	public abstract void enable();
	
	public abstract void disable();
	
	public abstract void execute(String[] args);
	
	public enum ModuleType {
		BASIC,
		COMMAND,
	}
}
