package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet40EntityMetadata;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer40EntityMetadata implements PacketListener {

    private final VanishTest vanish;

    public Sniffer40EntityMetadata(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,40,((Packet40EntityMetadata) ((MCCraftPacket) packet).getPacket()).a);
    }

}
