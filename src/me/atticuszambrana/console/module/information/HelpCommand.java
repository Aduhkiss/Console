package me.atticuszambrana.console.module.information;

import me.atticuszambrana.console.center.CommandCenter;
import me.atticuszambrana.console.common.Module;

public class HelpCommand extends Module {
	public HelpCommand() {
		super("help", "Show commands to run", ModuleType.COMMAND);
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated 1method stub
		
	}

	@Override
	public void execute(String[] args) {
		
		/*
		 * The arguments for running the command are stored in the args String array
		 * 
		 * args[0] will always be the command ran, for an example, help
		 * then the next ones will be any arguments that were ran as well
		 */
		
		System.out.println("Displaying all commands");
		
		for(Module m : CommandCenter.getModules()) {
			
			if(m.getType() == ModuleType.COMMAND) {
				System.out.println("=====================");
				System.out.println(m.getName());
				System.out.println(m.getDescription());
				System.out.println("=====================");
			}
			
		}
		
	}
}
