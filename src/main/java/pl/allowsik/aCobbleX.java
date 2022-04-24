package pl.allowsik;

import org.bukkit.plugin.java.JavaPlugin;

public final class aCobbleX extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register command
        this.getCommand("cx").setExecutor(new cxCommand());
    }
}
