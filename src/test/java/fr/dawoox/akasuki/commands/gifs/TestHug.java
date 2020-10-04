package fr.dawoox.akasuki.commands.gifs;

import fr.dawoox.akasuki.utils.UrlChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHug {

    @Test
    public void testGetRandomLink() {
        assertTrue(UrlChecker.isValid(Hug.getRandomLink()));
    }
}
