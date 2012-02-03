package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet38EntityStatus;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer38EntityStatus implements PacketListener {

    private final VanishTest vanish;

    public Sniffer38EntityStatus(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,38,((Packet38EntityStatus) ((MCCraftPacket) packet).getPacket()).a);
    }

}
