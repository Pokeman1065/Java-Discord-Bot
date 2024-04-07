package LetJerryEat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TokenManager {
    private static final String CONFIG_FILE_PATH = "CONFIG_FILE_PATH_HERE";

    public static String getDiscordAPIToken() {
        Properties properties = loadProperties();
        return properties.getProperty("discord.token");
    }

    public static String getVoiceflowAPIToken() {
        Properties properties = loadProperties();
        return properties.getProperty("voiceflow.token");
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
