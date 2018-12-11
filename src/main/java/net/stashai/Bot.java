package net.stashai;

import net.stashai.events.AnnotationListener;
import net.stashai.events.NewUserHandler;
import net.stashai.events.ReadyHandler;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

import java.util.logging.Logger;

//TODO add explanations for each command?, use reactions to see if a source was helpful?, Hearthstone?
public class Bot {

    public static Logger logger = Logger.getLogger("Stash AI");
    public static final String BOT_PREFIX = "?";

    public static void main(String[] args) {
        logger.info("LOGGING IN");
        IDiscordClient client = Bot.createClient(args[0], true);
        logger.info("REGISTERING CLIENT DISPATCHER");
        EventDispatcher dispatcher = client.getDispatcher();
        logger.info("REGISTERING LISTENERS");
        dispatcher.registerListener(new AnnotationListener());
        dispatcher.registerListener(new ReadyHandler());
        dispatcher.registerListener(new NewUserHandler());
        logger.info("READY TO START");
    }

    private static IDiscordClient createClient(String token, boolean login) {
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        try {
            if (login) {
                return clientBuilder.login();
            } else {
                return clientBuilder.build();
            }
        } catch (DiscordException e) {
            e.printStackTrace();
            return null;
        }
    }
}
