package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet17EntityLocationAction;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer17 implements PacketListener {

    private final VanishTest vanish;

    public Sniffer17(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,17,((Packet17EntityLocationAction) ((MCCraftPacket) packet).getPacket()).a);
    }

}
