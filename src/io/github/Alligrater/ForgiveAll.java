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
				Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "ԭ���������ˣ�");
				 Object[] aplayers = Bukkit.getOnlinePlayers().toArray();
				 for(Object onlineplayers : aplayers) {
					 ((Player)onlineplayers).sendTitle(ChatColor.GREEN + player.getName(), ChatColor.GREEN + "ԭ�����㣡");
				 }
			}
			else {
				Bukkit.broadcastMessage(ChatColor.GREEN + "��������ԭ����������!");
				 Object[] aplayers = Bukkit.getOnlinePlayers().toArray();
				 for(Object onlineplayers : aplayers) {
					 ((Player)onlineplayers).sendTitle(ChatColor.GREEN + "��������", ChatColor.GREEN + "ԭ�����㣡");
				 }
			}
		}
		
		else {
			sender.sendMessage("��4������������");
			return false;
		}
		
		return true;
	}
	
}
