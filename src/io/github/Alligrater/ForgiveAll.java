package io.github.Alligrater;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ForgiveAll implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if(sender.hasPermission("Forgiveness.forgiveall")) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "原谅了所有人！");
				 Object[] aplayers = Bukkit.getOnlinePlayers().toArray();
				 for(Object onlineplayers : aplayers) {
					 ((Player)onlineplayers).sendTitle(ChatColor.GREEN + player.getName(), ChatColor.GREEN + "原谅了你！");
				 }
			}
			else {
				Bukkit.broadcastMessage(ChatColor.GREEN + "隔壁老王原谅了所有人!");
				 Object[] aplayers = Bukkit.getOnlinePlayers().toArray();
				 for(Object onlineplayers : aplayers) {
					 ((Player)onlineplayers).sendTitle(ChatColor.GREEN + "隔壁老王", ChatColor.GREEN + "原谅了你！");
				 }
			}
		}
		
		else {
			sender.sendMessage("§4你你你你想干嘛！");
			return false;
		}
		
		return true;
	}
	
}
