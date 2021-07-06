package fr.noalegeek68.noaplugin;

import fr.noalegeek68.noaplugin.commands.*;
import fr.noalegeek68.noaplugin.listeners.GuiListener;
import fr.noalegeek68.noaplugin.listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class NoaPlugin extends JavaPlugin {

    public static final String pluginPrefix = String.format("%s[%sNoaPlugin%s] ", ChatColor.GRAY, ChatColor.DARK_GRAY, ChatColor.GRAY);
    public static final Map<UUID, Boolean> moderationMode = new HashMap<>();
    private static NoaPlugin plugin;

    @Override
    public void onEnable() {
        System.out.println("[NoaPlugin] Le plugin a été démarré.");
        registerListeners();
        registerCommands();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new GuiListener(), this);
        pluginManager.registerEvents(new Listeners(), this);
    }

    public void registerCommands(){
        registerCommand("test", new TestCommand(),"t");
        registerCommand("alert", new AlertCommand(),"a");
        registerCommand("broadcast", new BroadcastCommand(),"bc","broadc","bcast");
        registerCommand("spawn", new SpawnCommand(),"s");
        registerCommand("craft", new CraftCommand(), "c");
        registerCommand("enderchest", new EnderchestCommand(), "ec","enderc","echest");
        registerCommand("invsee", new InvseeCommand(), "inventorysee","inventorys","invs");
    }

    public void registerCommand(@NotNull String commandName, @NotNull CommandExecutor commandExecutor, @Nullable String... commandAliases){
        PluginCommand command = getCommand(commandName);
        if(commandAliases != null && commandAliases.length != 0) command.setAliases(Arrays.asList(commandAliases));
        command.setExecutor(commandExecutor);
    }

    @Override
    public void onDisable() {
        System.out.println("[NoaPlugin] Le plugin a été éteint.");
        /*for (UUID uuid : moderationMode.keySet()) {
            boolean b = moderationMode.get(uuid);
            // Unvanish the person
        }*/
    }

    public static NoaPlugin getPlugin(){ return plugin; }
    public static String getPermission(){ return "noaplugin."; }
}
