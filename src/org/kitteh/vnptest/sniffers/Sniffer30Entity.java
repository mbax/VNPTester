package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet30Entity;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer30Entity implements PacketListener {

    private final VanishTest vanish;

    public Sniffer30Entity(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,30,((Packet30Entity) ((MCCraftPacket) packet).getPacket()).a);
    }

}
