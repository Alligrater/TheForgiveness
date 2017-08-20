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
			sender.sendMessage(ChatColor.RED + "�������������!");
		}
		else {
			Player target = Bukkit.getServer().getPlayer(arg3[0]);
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if(target == null) {
					sender.sendMessage(ChatColor.RED + arg3[0] + "��ǰ�����ߣ�");
					return false;
				}
				else {
					if (player.getName() == target.getName()) {
						Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "ԭ�������Լ���");
						target.sendTitle(ChatColor.GREEN + "�㱾��", ChatColor.GREEN + "ԭ�����㣡");
					}
					else {
						Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.GREEN + "ԭ����" + ChatColor.GREEN + target.getName() + ChatColor.GREEN + "!");
						target.sendTitle(ChatColor.GREEN + player.getName(), ChatColor.GREEN + "ԭ�����㣡");
					}

				}
			}
			
			else {
				if(target == null) {
					sender.sendMessage(ChatColor.RED + arg3[0] + "��ǰ�����ߣ�");
					return false;
				}
				else {
					Bukkit.broadcastMessage(ChatColor.GREEN + "��������ԭ����" + target.getName() + "��");
					target.sendTitle(ChatColor.GREEN + "��������", ChatColor.GREEN + "ԭ�����㣡");
				}
			}
		}
		return true;
	}
	

}
