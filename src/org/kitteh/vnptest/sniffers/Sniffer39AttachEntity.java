package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet39AttachEntity;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer39AttachEntity implements PacketListener {

    private final VanishTest vanish;

    public Sniffer39AttachEntity(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,39,((Packet39AttachEntity) ((MCCraftPacket) packet).getPacket()).a);
    }

}
