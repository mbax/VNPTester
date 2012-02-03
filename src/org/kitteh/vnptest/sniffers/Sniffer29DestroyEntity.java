package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet29DestroyEntity;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer29DestroyEntity implements PacketListener {

    private final VanishTest vanish;

    public Sniffer29DestroyEntity(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	vanish.check(player,29,((Packet29DestroyEntity) ((MCCraftPacket) packet).getPacket()).a);
    	return true;
    }

}
