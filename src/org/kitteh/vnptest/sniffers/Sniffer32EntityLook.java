package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet32EntityLook;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer32EntityLook implements PacketListener {

    private final VanishTest vanish;

    public Sniffer32EntityLook(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,32,((Packet32EntityLook) ((MCCraftPacket) packet).getPacket()).a);
    }

}
