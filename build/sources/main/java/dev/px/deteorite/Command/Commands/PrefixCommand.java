package dev.px.deteorite.Command.Commands;

import dev.px.deteorite.Command.Command;

public class PrefixCommand extends Command {

    @Override
    public String[] getArgs() {
        return new String[]{"prefix", "setprefix"};
    }

    @Override
    public String getSyntax() {
        return "prefix <character>";
    }

    @Override
    public void exec(String command, String[] args) {
        setPrefix(args[0]);
        sendMessage("Set new prefix: " + getPrefix());
    }
}
