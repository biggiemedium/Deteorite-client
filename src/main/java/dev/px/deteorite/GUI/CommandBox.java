package dev.px.deteorite.GUI;

import dev.px.deteorite.Command.Command;
import dev.px.deteorite.Deteorite;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;

public class CommandBox extends GuiChat {

    private String command;

    private String start, history;
    private int curser;

    public CommandBox(String start, String history, int curser) {
        this.start = start;
        this.history = history;
        this.curser = curser;
        this.command = Command.getPrefix();
    }
}
