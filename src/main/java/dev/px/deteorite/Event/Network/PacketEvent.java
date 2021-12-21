package dev.px.deteorite.Event.Network;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

public class PacketEvent extends Event {
    private Packet packet;

    public PacketEvent(Packet packet) {
        super();

        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }

    public static class SendPacket extends PacketEvent {

        public SendPacket(Packet packet) {
            super(packet);
        }

    }

    public static class ReceivePacket extends PacketEvent {
        public ReceivePacket(Packet packet) {
            super(packet);
        }
    }
}
