import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, FileNotFoundException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(importToken());
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    public static String importToken() throws FileNotFoundException {
        Scanner inputToken = new Scanner(new File("TOKEN"));
        return inputToken.nextLine();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Disabled for entertainment purposes
        /*
        if (event.getAuthor().isBot())
            return;
        */

        String message = event.getMessage().getContentRaw();
        if (message.equals("$ping"))
            event.getChannel().sendMessage("I've got better things to do than answer your stupid pings").queue();
        else if (message.equals("$help"))
            help(event);
        else if (message.equals("$shutdown"))
            event.getChannel().sendMessage("no u").queue();
        else if (message.substring(0, 5).equals("$echo"))
            event.getChannel().sendMessage(message.substring(6)).queue();
        else if (message.equals("$cradily"))
            event.getChannel().sendMessage("fuck off").queue();
        else if (message.equals("$whiscash"))
            event.getChannel().sendMessage(":yum:").queue();
    }

    private void help(MessageReceivedEvent event) {
        event.getChannel().sendMessage("```\n" +
                                            "Command List\n" +
                                            "$help - Display this list\n" +
                                            "$shutdown - Shutdown this bot\n" +
                                            "```").queue();

    }

}
