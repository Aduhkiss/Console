package me.atticuszambrana.console.module.testing;

import me.atticuszambrana.console.common.Module;
import me.atticuszambrana.console.common.Rank;

public class DevTest extends Module {
	
	public DevTest() {
		super("devtest", "Developer Test Command for Permissions", ModuleType.COMMAND, Rank.ADMIN);
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("It works!");
	}

}
