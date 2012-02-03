package org.kitteh.vnptest.sniffers;

import net.minecraft.server.Packet5EntityEquipment;

import org.bukkit.entity.Player;
import org.getspout.spout.packet.standard.MCCraftPacket;
import org.getspout.spoutapi.packet.listener.PacketListener;
import org.getspout.spoutapi.packet.standard.MCPacket;
import org.kitteh.vnptest.VanishTest;

public class Sniffer5EntityEquipment implements PacketListener {

    private final VanishTest vanish;

    public Sniffer5EntityEquipment(VanishTest vanish) {
        this.vanish = vanish;
    }

    @Override
    public boolean checkPacket(Player player, MCPacket packet) {
    	return vanish.check(player,5,((Packet5EntityEquipment) ((MCCraftPacket) packet).getPacket()).a);
    }

}
