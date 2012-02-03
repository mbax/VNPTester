package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet33RelEntityMoveLook;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer33RelEntityMoveLook implements PacketListener {

    private final VanishTest vanish;

    public Sniffer33RelEntityMoveLook(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,33,((Packet33RelEntityMoveLook) ((MCCraftPacket) packet).getPacket()).a);
    }

}
