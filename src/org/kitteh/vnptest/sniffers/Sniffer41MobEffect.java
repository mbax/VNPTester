package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet41MobEffect;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer41MobEffect implements PacketListener {

    private final VanishTest vanish;

    public Sniffer41MobEffect(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,41,((Packet41MobEffect) ((MCCraftPacket) packet).getPacket()).a);
    }

}
