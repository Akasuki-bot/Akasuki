package fr.dawoox.akasuki.commands.misc;

import fr.dawoox.akasuki.core.command.BaseCmd;
import fr.dawoox.akasuki.utils.LogsWriter;
import fr.dawoox.akasuki.utils.TimeUtils;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

/**
 * Return the bot ping
 * @author Dawoox
 * @version 1.2.0
 */
public class Ping {

    /*
    public static void reg(Map<String, BaseCmd> commands){
        commands.put("ping", event -> {
            Instant messageInstant = event.getMessage().getTimestamp();
            Objects.requireNonNull(event.getMessage().getChannel().block()).createMessage("Pinging...");
            Instant botInstant = Instant.now();
            String reply = "La latence de Yua est de `" + TimeUtils.diffInMillis(messageInstant, botInstant) + "ms` actuellement" +
                    "\nUn problème de latence ? Venez nous l'indiquer sur notre Discord de support";
            Objects.requireNonNull(Objects.requireNonNull(event.getMessage().getChannel().block()).getLastMessage().block()).delete("Yua auto ping message deleted");
            Objects.requireNonNull(event.getMessage().getChannel().block()).createMessage(reply).block();
            LogsWriter.logAction("Ping : ", Objects.requireNonNull(event.getMessage().getAuthorAsMember().block()), Ping.class);
        });
    }*/

}
