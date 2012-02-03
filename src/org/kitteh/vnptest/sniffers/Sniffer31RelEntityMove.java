package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet31RelEntityMove;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer31RelEntityMove implements PacketListener {

    private final VanishTest vanish;

    public Sniffer31RelEntityMove(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,31,((Packet31RelEntityMove) ((MCCraftPacket) packet).getPacket()).a);
    }

}
