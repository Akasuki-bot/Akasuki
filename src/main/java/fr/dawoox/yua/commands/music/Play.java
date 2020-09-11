package fr.dawoox.yua.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.playback.NonAllocatingAudioFrameBuffer;
import discord4j.voice.AudioProvider;
import fr.dawoox.yua.utils.Command;
import fr.dawoox.yua.utils.music.LavaPlayerAudioProvider;
import fr.dawoox.yua.utils.music.TrackScheduler;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Play {

    private static AudioPlayer player;
    private static AudioProvider provider;

    public static void reg(Map<String, Command> commands){

        final AudioPlayerManager playerManager = new DefaultAudioPlayerManager();
        playerManager.getConfiguration().setFrameBufferFactory(NonAllocatingAudioFrameBuffer::new);
        AudioSourceManagers.registerRemoteSources(playerManager);
        final AudioPlayer player = playerManager.createPlayer();
        AudioProvider provider = new LavaPlayerAudioProvider(player);
        final TrackScheduler scheduler = new TrackScheduler(player);

        Play.player = player;
        Play.provider = provider;

        commands.put("play", event -> {
            final String content = event.getMessage().getContent();
            final List<String> command = Arrays.asList(content.split(" "));
            playerManager.loadItem(command.get(1), scheduler);
        });
    }

    public static AudioPlayer getPlayer() { return player; }
    public static AudioProvider getProvider() { return provider; }
}
