package dev.px.deteorite.Manager;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.px.deteorite.Command.Command;
import dev.px.deteorite.Command.Commands.PrefixCommand;
import dev.px.deteorite.Command.Commands.SavedCommand;
import dev.px.deteorite.Util.Wrapper;

import java.util.ArrayList;

public class CommandManager {

    public ArrayList<Command> commands = new ArrayList<>();
    private boolean b;

    public CommandManager() {
        if(commands == null) {
            commands = new ArrayList<>();
        }

        Add(new PrefixCommand());
        Add(new SavedCommand());
    }

    private void Add(Command command) {
        this.commands.add(command);
    }

    public void callCommand(String input) {
        String[] split = input.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        String command = split[0];
        String args = input.substring(command.length()).trim();
        b = false;
        commands.forEach(c -> {
            for (String s : c.getArgs()) {
                if (s.equalsIgnoreCase(command)) {
                    b = true;
                    try {
                        c.exec(args, args.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
                    }
                    catch (Exception e) {
                        Wrapper.sendClientMessage(ChatFormatting.RED + c.getSyntax());
                    }
                }
            }
        });
        if (!b) {
            Wrapper.sendClientMessage(ChatFormatting.RED + "Unknown command!");
        }
    }
}
