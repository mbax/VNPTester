package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet42RemoveMobEffect;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer42RemoveMobEffect implements PacketListener {

    private final VanishTest vanish;

    public Sniffer42RemoveMobEffect(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,42,((Packet42RemoveMobEffect) ((MCCraftPacket) packet).getPacket()).a);
    }

}
