package org.kitteh.vnptest;


import java.util.HashMap;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.kitteh.vanish.VanishPerms;
import org.kitteh.vanish.staticaccess.VanishNoPacket;
import org.kitteh.vanish.staticaccess.VanishNotLoadedException;
import org.kitteh.vnptest.sniffers.Sniffer17;
import org.kitteh.vnptest.sniffers.Sniffer18ArmAnimation;
import org.kitteh.vnptest.sniffers.Sniffer19EntityAction;
import org.kitteh.vnptest.sniffers.Sniffer20NamedEntitySpawn;
import org.kitteh.vnptest.sniffers.Sniffer28EntityVelocity;
import org.kitteh.vnptest.sniffers.Sniffer29DestroyEntity;
import org.kitteh.vnptest.sniffers.Sniffer30Entity;
import org.kitteh.vnptest.sniffers.Sniffer31RelEntityMove;
import org.kitteh.vnptest.sniffers.Sniffer32EntityLook;
import org.kitteh.vnptest.sniffers.Sniffer33RelEntityMoveLook;
import org.kitteh.vnptest.sniffers.Sniffer34EntityTeleport;
import org.kitteh.vnptest.sniffers.Sniffer38EntityStatus;
import org.kitteh.vnptest.sniffers.Sniffer39AttachEntity;
import org.kitteh.vnptest.sniffers.Sniffer40EntityMetadata;
import org.kitteh.vnptest.sniffers.Sniffer41MobEffect;
import org.kitteh.vnptest.sniffers.Sniffer42RemoveMobEffect;
import org.kitteh.vnptest.sniffers.Sniffer5EntityEquipment;


/**
 * It's the vanishing manager!
 * 
 * @author mbaxter
 * 
 */
public class VanishTest extends JavaPlugin implements Listener{

	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){
				SpoutManager.getPacketManager().addListener(5, VanishTest.this.sniffer5);
		        SpoutManager.getPacketManager().addListener(17, VanishTest.this.sniffer17);
		        SpoutManager.getPacketManager().addListener(18, VanishTest.this.sniffer18);
		        SpoutManager.getPacketManager().addListener(19, VanishTest.this.sniffer19);
		        SpoutManager.getPacketManager().addListener(20, VanishTest.this.sniffer20);
		        SpoutManager.getPacketManager().addListener(28, VanishTest.this.sniffer28);
		        SpoutManager.getPacketManager().addListener(29, VanishTest.this.sniffer29);
		        SpoutManager.getPacketManager().addListener(30, VanishTest.this.sniffer30);
		        SpoutManager.getPacketManager().addListener(31, VanishTest.this.sniffer31);
		        SpoutManager.getPacketManager().addListener(32, VanishTest.this.sniffer32);
		        SpoutManager.getPacketManager().addListener(33, VanishTest.this.sniffer33);
		        SpoutManager.getPacketManager().addListener(34, VanishTest.this.sniffer34);
		        SpoutManager.getPacketManager().addListener(38, VanishTest.this.sniffer38);
		        SpoutManager.getPacketManager().addListener(39, VanishTest.this.sniffer39);
		        SpoutManager.getPacketManager().addListener(40, VanishTest.this.sniffer40);
		        SpoutManager.getPacketManager().addListener(41, VanishTest.this.sniffer41);
		        SpoutManager.getPacketManager().addListener(42, VanishTest.this.sniffer42);
			}
		});
	}
	private final Sniffer5EntityEquipment sniffer5 = new Sniffer5EntityEquipment(this);
    private final Sniffer17 sniffer17 = new Sniffer17(this);
    private final Sniffer18ArmAnimation sniffer18 = new Sniffer18ArmAnimation(this);
    private final Sniffer19EntityAction sniffer19 = new Sniffer19EntityAction(this);
    private final Sniffer20NamedEntitySpawn sniffer20 = new Sniffer20NamedEntitySpawn(this);
    private final Sniffer28EntityVelocity sniffer28 = new Sniffer28EntityVelocity(this);
    private final Sniffer29DestroyEntity sniffer29 = new Sniffer29DestroyEntity(this);
    private final Sniffer30Entity sniffer30 = new Sniffer30Entity(this);
    private final Sniffer31RelEntityMove sniffer31 = new Sniffer31RelEntityMove(this);
    private final Sniffer32EntityLook sniffer32 = new Sniffer32EntityLook(this);
    private final Sniffer33RelEntityMoveLook sniffer33 = new Sniffer33RelEntityMoveLook(this);
    private final Sniffer34EntityTeleport sniffer34 = new Sniffer34EntityTeleport(this);
    private final Sniffer38EntityStatus sniffer38 = new Sniffer38EntityStatus(this);
    private final Sniffer39AttachEntity sniffer39 = new Sniffer39AttachEntity(this);
    private final Sniffer40EntityMetadata sniffer40 = new Sniffer40EntityMetadata(this);
    private final Sniffer41MobEffect sniffer41 = new Sniffer41MobEffect(this);
    private final Sniffer42RemoveMobEffect sniffer42 = new Sniffer42RemoveMobEffect(this);
	private HashMap<Integer,String> map=new HashMap<Integer,String>();

	@EventHandler
	public void join(PlayerJoinEvent event){
		map.put(((CraftPlayer)event.getPlayer()).getEntityId(), event.getPlayer().getName());
	}

	@EventHandler
	public void quit(PlayerQuitEvent event){
		map.remove(((CraftPlayer)event.getPlayer()).getEntityId());
	}

	public boolean check(Player player,int a, int i) {
		String name=map.get(i);
		if(name!=null){
			if(name.equals(player.getName())){
				return true;
			}
			try {
				if(VanishNoPacket.isVanished(name) && !VanishPerms.canSeeAll(player)){
					System.out.println("Packet"+a+" for "+name+" to "+player.getName());
				}
			} catch (VanishNotLoadedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}