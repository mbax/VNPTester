package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet28EntityVelocity;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer28EntityVelocity implements PacketListener {

    private final VanishTest vanish;

    public Sniffer28EntityVelocity(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,28,((Packet28EntityVelocity) ((MCCraftPacket) packet).getPacket()).a);
    }

}
