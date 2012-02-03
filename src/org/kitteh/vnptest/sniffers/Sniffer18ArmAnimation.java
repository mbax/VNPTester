package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet18ArmAnimation;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer18ArmAnimation implements PacketListener {

    private final VanishTest vanish;

    public Sniffer18ArmAnimation(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,18,((Packet18ArmAnimation) ((MCCraftPacket) packet).getPacket()).a);
    }

}
