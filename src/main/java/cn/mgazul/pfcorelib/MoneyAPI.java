package cn.mgazul.pfcorelib;

import cn.mgazul.pfcorelib.configuration.PlayerdataAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.UUID;

/*
 * 铜钱
 */
public class MoneyAPI {
  
  public static Double getMoneys(UUID uuid) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);   
	  double money = Config.getDouble("player.playerdata.Moneys");
	    if (Config.getString("player.playerdata.Moneys") == null) {
	        return 0.0D;
	      }   
	  return money;
  } 
  
  public static void addMoneys(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
	  double money = Config.getDouble("player.playerdata.Moneys");
    
	  money += amount;   
	  Config.set("player.playerdata.Moneys", money);
	  PlayerdataAPI.saveYaml(uuid, Config);
  } 
  
  public static void removeMoneys(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid);  
		double money = Config.getDouble("player.playerdata.Moneys");
  
		money -= amount; 
		if (getMoneys(uuid) - amount > 0) {
		Config.set("player.playerdata.Moneys", money);
		}else{	
			return;	
		}
		PlayerdataAPI.saveYaml(uuid, Config);
  }

  public  static void setMoneys(UUID uuid, double amount) {
	  YamlConfiguration Config = PlayerdataAPI.createYaml(uuid); 		
		Config.set("player.playerdata.Moneys", amount);
		PlayerdataAPI.saveYaml(uuid, Config);
  }
}
