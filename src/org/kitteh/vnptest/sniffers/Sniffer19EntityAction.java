package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet19EntityAction;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer19EntityAction implements PacketListener {

    private final VanishTest vanish;

    public Sniffer19EntityAction(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,19,(((Packet19EntityAction) ((MCCraftPacket) packet).getPacket()).a));
    }

}
