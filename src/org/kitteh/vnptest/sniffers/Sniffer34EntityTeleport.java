package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet34EntityTeleport;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer34EntityTeleport implements PacketListener {

    private final VanishTest vanish;

    public Sniffer34EntityTeleport(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,34,((Packet34EntityTeleport) ((MCCraftPacket) packet).getPacket()).a);
    }

}
