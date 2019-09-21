package me.atticuszambrana.console.module.information;

import me.atticuszambrana.console.common.Module;

public class StopCommand extends Module {
	
	public StopCommand() {
		super("stop", "Shutdown the program", ModuleType.COMMAND);
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
		// Yeah what a suprise! it shuts down the program
		System.exit(0);
	}

}
