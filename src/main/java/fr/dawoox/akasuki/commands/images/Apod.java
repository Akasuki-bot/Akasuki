package fr.dawoox.akasuki.commands.images;

import discord4j.rest.util.Color;
import fr.dawoox.akasuki.utils.EmbedTemplate;
import fr.dawoox.akasuki.utils.Command;
import fr.dawoox.akasuki.utils.NasaAPIUtils;
import fr.dawoox.akasuki.utils.json.APOD;

import java.util.Map;
import java.util.Objects;

/**
 * Show the NASA Astronomy Picture of the Day.
 * @author Dawoox
 * @version 1.1.0
 */
public class Apod {

    public static void reg(Map<String, Command> commands) {
        commands.put("apod", event -> {
            APOD apod = NasaAPIUtils.requestAPOD();
            EmbedTemplate.sendEmbed(Objects.requireNonNull(event.getMessage().getChannel().block()),
                    "NASA Astronomy Picture of the Day", apod.title, Color.DEEP_LILAC, apod.url);
        });
    }
}