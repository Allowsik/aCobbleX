package pl.allowsik;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class cxCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 0) sender.sendMessage("§cUżycie: /cx");
        // Check if player has 9*64 blocks of cobblestone
        Player player = (Player) sender;
        if (player.getInventory().contains(Material.COBBLESTONE, 9*64)) {
            player.getInventory().removeItem(new org.bukkit.inventory.ItemStack(Material.COBBLESTONE, 9*64));

            ItemStack item = new ItemStack(Material.COBBLESTONE);
            item.addUnsafeEnchantment(org.bukkit.enchantments.Enchantment.DURABILITY, 10);
            item.getItemMeta().setDisplayName("§c&LCOBBLEX");
            player.getInventory().addItem(item);

            sender.sendMessage("§aZdobyłeś §cCX§a!");
        } else sender.sendMessage("§cNie posiadasz wystarczającej ilości bloków cobblestone!");
        return true;
    }
}
