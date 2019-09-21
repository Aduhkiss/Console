package me.atticuszambrana.console.center;

import java.util.ArrayList;
import java.util.List;

import me.atticuszambrana.console.common.Module;
import me.atticuszambrana.console.module.information.HelpCommand;
import me.atticuszambrana.console.module.information.StopCommand;
import me.atticuszambrana.console.module.permission.PermissionManager;
import me.atticuszambrana.console.module.testing.DevTest;

public class CommandCenter {
	private static List<Module> modules = new ArrayList<Module>();
	
	public static void register() {
		//// Commands
		
		// Information
		modules.add(new HelpCommand());
		modules.add(new StopCommand());
		
		// Developer Testing
		modules.add(new DevTest());
		
		
		//// Non-Command Modules
		modules.add(new PermissionManager());
		
		// Then we want to call the enable method, to load their enable code
		enableAll();
	}
	
	private static void enableAll() {
		for(Module m : modules) {
			m.enable();
		}
	}
	
	public static void disableAll() {
		for(Module m : modules) {
			m.disable();
		}
	}
	
	public static List<Module> getModules() {
		return modules;
	}
}
