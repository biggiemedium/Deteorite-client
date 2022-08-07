package dev.px.deteorite.Command.Commands;

import dev.px.deteorite.Command.Command;
import dev.px.deteorite.Deteorite;

public class SavedCommand extends Command {

    public SavedCommand() {

    }

    @Override
    public String[] getArgs() {
        return new String[] {"save", "saveconfig", "config"};
    }

    @Override
    public String getSyntax() {
        return "prefix <save>";
    }

    @Override
    public void exec(String command, String[] args) {
        sendMessage("Saved config!");
        Deteorite.configManager.getConfigs().forEach(config -> {
            config.saves();
        });
    }
}
