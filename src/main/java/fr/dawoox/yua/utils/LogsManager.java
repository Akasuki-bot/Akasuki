package fr.dawoox.yua.utils;

import discord4j.core.object.entity.Member;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LogsManager {

    public static void logAction(String action, Member sender, Class actionClass){
        String reply = " " + sender.getUsername() + "." + Objects.requireNonNull(sender.getGuild().block()).getName() + " - " + action;
        LoggerFactory.getLogger(actionClass).debug(reply);
    }

}