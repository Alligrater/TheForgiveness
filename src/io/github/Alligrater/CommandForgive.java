package io.github.Alligrater;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import net.md_5.bungee.api.ChatColor;

public class CommandForgive implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		
		if(arg3.length != 1) {
			sender.sendMessage(ChatColor.RED + "你你你你想干嘛!");
		}
		else {
			Player target = Bukkit.getServer().getPlayer(arg3[0]);
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if(target == null) {
					sender.sendMessage(ChatColor.RED + arg3[0] + "当前不在线！");
					return false;
				}
				else {
					if (player.getName() == target.getName()) {
						Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "原谅了他自己！");
						target.sendTitle(ChatColor.GREEN + "你本尊", ChatColor.GREEN + "原谅了你！");
					}
					else {
						Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "原谅了" + ChatColor.GREEN + target.getName() + ChatColor.GREEN + "!");
						target.sendTitle(ChatColor.GREEN + player.getName(), ChatColor.GREEN + "原谅了你！");
					}

				}
			}
			
			else {
				if(target == null) {
					sender.sendMessage(ChatColor.RED + arg3[0] + "当前不在线！");
					return false;
				}
				else {
					Bukkit.broadcastMessage(ChatColor.GREEN + "隔壁老王原谅了" + target.getName() + "！");
					target.sendTitle(ChatColor.GREEN + "隔壁老王", ChatColor.GREEN + "原谅了你！");
				}
			}
		}
		return true;
	}
	

}
