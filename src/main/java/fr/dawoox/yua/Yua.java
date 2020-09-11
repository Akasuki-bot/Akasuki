package fr.dawoox.yua;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import fr.dawoox.yua.commands.misc.Ping;
import fr.dawoox.yua.commands.misc.UserInfo;
import fr.dawoox.yua.commands.music.Join;
import fr.dawoox.yua.commands.music.Play;
import fr.dawoox.yua.utils.Command;

import java.util.HashMap;
import java.util.Map;

public class Yua {

    private static final Map<String, Command> commands = new HashMap<>();
    private static final String prefix = "*";

    public static void main(String[] args) {

        final String token = args[0];
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient g = client.login().block();

        g.getEventDispatcher().on(MessageCreateEvent.class)
                .subscribe(event -> {
                    final String content = event.getMessage().getContent();
                    for (final Map.Entry<String, Command> entry : commands.entrySet()) {
                        if (content.startsWith(prefix + entry.getKey())) {
                            entry.getValue().execute(event);
                            break;
                        }
                    }
                });

        g.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(readyEvent -> {
                    System.out.println("Yua Shard Connected");

                    Ping.reg(commands);
                    Join.reg(commands);
                    Play.reg(commands);
                    UserInfo.reg(commands);
                });

        g.onDisconnect().block();
    }
}
