package be.achent.noallayreplication.chatcolorhandler.parsers.custom;

import org.bukkit.entity.Player;

public class LegacyCharParser implements Parser {

    @Override
    public String parseString(String string) {
        // Replace legacy character
        return string.replaceAll("§", "&");
    }

    @Override
    public String parseString(String string, Player player) {
        return parseString(string);
    }
}