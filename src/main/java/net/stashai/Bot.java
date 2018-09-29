package net.stashai;

import net.stashai.events.Events;
import net.stashai.utils.Utils;
import java.util.logging.Logger;
import sx.blah.discord.api.IDiscordClient;

//Bot used to aquire items from the database of RPG like games, Destiny 2 will be done first
public class Bot {

    static Logger logger = Logger.getLogger("Stash AI");

    public static void main(String[] args) {
        logger.info("Starting Stash AI " + Utils.VERSION);

        if (args.length != 1) {
            System.out.println("Please enter the bots token as the first argument e.g java -jar thisjar.jar tokenhere");
            return;
        }

        logger.info("Creating Discord Client Object");
        IDiscordClient cli = Utils.getBuiltDiscordClient(args[0]);

        logger.info("Registering Event Listeners");
        cli.getDispatcher().registerListener(new Events());

        logger.info("Accessing Guilds..");
        cli.login();
    }
}
