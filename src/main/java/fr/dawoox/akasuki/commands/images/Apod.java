package fr.dawoox.akasuki.commands.images;

import com.sun.tools.javac.util.List;
import discord4j.rest.util.Color;
import fr.dawoox.akasuki.core.command.CommandCategory;
import fr.dawoox.akasuki.core.command.CommandPermission;
import fr.dawoox.akasuki.core.command.Context;
import fr.dawoox.akasuki.core.command.BaseCmd;
import fr.dawoox.akasuki.utils.API.NasaAPI;
import fr.dawoox.akasuki.utils.json.ApodBody;

import java.time.Instant;
import java.util.Objects;

/**
 * Show the NASA Astronomy Picture of the Day.
 * @author Dawoox
 * @version 1.1.0
 */
public class Apod extends BaseCmd{

    public Apod() {
        super(CommandCategory.IMAGE, CommandPermission.USER, List.of("apod", "ap"));
    }

    @Override
    public void execute(Context context) {
        ApodBody apod = NasaAPI.requestAPOD();
        if (apod.mediaType.equalsIgnoreCase("image")) {
            context.getChannel().createEmbed( embedCreateSpec ->
                    embedCreateSpec.setColor(Color.DEEP_LILAC)
                    .setAuthor("NASA Astronomy Picture of the Day", null, null)
                    .setDescription(apod.title)
                    .setImage(apod.hdUrl)
                    .setFooter("Akasuki", null)
                    .setTimestamp(Instant.now())).block();
        }   else {
            context.getChannel().createEmbed( embedCreateSpec ->
                    embedCreateSpec.setColor(Color.DEEP_LILAC)
                    .setAuthor("NASA Astronomy Picture of the Day", null, null)
                    .setDescription(apod.title+":\n "+apod.url)
                    .setFooter("Akasuki", null)
                    .setTimestamp(Instant.now())).block();
        }
    }
}
