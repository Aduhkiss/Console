package me.atticuszambrana.console.module.permission;

import me.atticuszambrana.console.center.PermissionCenter;
import me.atticuszambrana.console.common.Module;

public class PermissionManager extends Module {
	
	public PermissionManager() {
		super("perms", "Module to handle the management of permissions", ModuleType.COMMAND);
	}

	@Override
	public void enable() {
		PermissionCenter.updateRank();
	}

	@Override
	public void disable() {
	}

	@Override
	public void execute(String[] args) {
		System.out.println("This machine is currently assigned the permission rank: " + PermissionCenter.getRank().toString().toUpperCase());
	}

}
