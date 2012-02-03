package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet20NamedEntitySpawn;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer20NamedEntitySpawn implements PacketListener {

    private final VanishTest plugin;

    public Sniffer20NamedEntitySpawn(VanishTest plugin) {
        this.plugin = plugin;
    }

	@Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return plugin.check(player,20,((Packet20NamedEntitySpawn)((MCCraftPacket) packet).getPacket()).a);
    }

}
