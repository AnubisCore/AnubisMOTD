/*
 * Copyright 2016 FFY00
 * 
 * Simple Non Code License (SNCL) v1.10.0
 */

package cf.ffy00;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author FFY00 <FFY00 at ffy00.cf>
 */
public class M extends JavaPlugin implements Listener{
    
    // Vars Config
    PluginDescriptionFile pl;
    private static File pasta;
    private FileConfiguration configData = null;
    private File dataFile = new File (pasta, "data.yml");
    private HashMap nomes = new HashMap<String, String>();

    // Metodo De Iniciar Config
    public void setupConfig(){
        pasta = getDataFolder();
        // Config
        if(!new File (pasta, "config.yml").exists()){
            saveDefaultConfig();
        }
        if(!dataFile.exists()){
            escrever(getResource("data.yml"), dataFile);
        }
    }
    private void escrever(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Data Config
    public FileConfiguration getCustomConfig() {
        return configData;
    }

    // Liga o Plugin
    @Override
    public void onEnable() {
        pl = getDescription();
        Bukkit.getConsoleSender().sendMessage("§bAtivando " + this.pl.getName() + " v" + this.pl.getVersion() + " por FFY00!");
        setupConfig();
    }

    // Desliga o Plugin
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§bDesativando " + this.pl.getName() + " v" + this.pl.getVersion() + " por FFY00!");
    }
    
    // Plugin INCIO
    @EventHandler
    public void serverPing(ServerListPingEvent e){
        
    }
    
    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        InetSocketAddress ip = p.getAddress();
        
    }
    // Plugin FIM
}