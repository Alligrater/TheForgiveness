package io.github.Alligrater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.Alligrater.CommandForgive;

public class Forgiveness extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		this.getCommand("forgive").setExecutor(new CommandForgive());
		this.getCommand("forgiveall").setExecutor(new ForgiveAll());
		getServer().getPluginManager().registerEvents(new PickupForgive(), this);

	}
	
	@Override
	public void onDisable() {
		
	}
}
