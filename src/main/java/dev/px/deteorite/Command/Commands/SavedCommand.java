package dev.px.deteorite.Command.Commands;

import dev.px.deteorite.Command.Command;
import dev.px.deteorite.Deteorite;

public class SavedCommand extends Command {

    public SavedCommand() {

    }

    @Override
    public String[] getArgs() {
        return new String[0];
    }

    @Override
    public String getSyntax() {
        return "prefix <save>";
    }

    @Override
    public void exec(String command, String[] args) {
        //Deteorite.configManager.saves();
    }
}
