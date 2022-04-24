package pl.allowsik;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class cxCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 0) sender.sendMessage("§cUżycie: /cx");
        // Check if player has 9*64 blocks of cobblestone
        Player player = (Player) sender;
        if (player.getInventory().contains(Material.COBBLESTONE, 9*64)) {
            player.getInventory().removeItem(new org.bukkit.inventory.ItemStack(Material.COBBLESTONE, 9*64));
            sender.sendMessage("§7(§6§lSkrzynki§7) §7Wymieniono §e9 §7staków cobblestone na skrzynie!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "crates give " + player.getName() + " cx");
        } else sender.sendMessage("§cNie posiadasz wystarczającej ilości bloków cobblestone!");
        return true;
    }
}
