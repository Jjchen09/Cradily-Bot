import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(System.getenv("HuskyDiscordToken"));
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    //Old Token System
    /*
    public static String importToken() throws FileNotFoundException {
        Scanner inputToken = new Scanner(new File("TOKEN"));
        return inputToken.nextLine();
    }
    */

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot() && message.equals("Mashing Potatoes"))
            mash(event);
        else if (message.equals("$ping"))
            event.getChannel().sendMessage("I've got better things to do than answer your stupid pings").queue();
        else if (message.equals("$help"))
            help(event);
        else if (message.equals("$shutdown"))
            event.getChannel().sendMessage("no u").queue();
        else if (message.substring(0, 5).equals("$echo"))
            echo(event);
        else if (message.equals("$cradily"))
            event.getChannel().sendMessage("fuck off").queue();
        else if (message.equals("$whiscash"))
            event.getChannel().sendMessage(":yum:").queue();
        else if (message.equals("$dogmeat"))
            event.getChannel().sendMessage("Nooo pls don't aboose me I'm coot doggo :frowning:").queue();
        else if (message.equals("$evilpenguin"))
            event.getChannel().sendMessage("Get your stinky feet off of me!").queue();
        else if (message.equals("$mashedpotatoes"))
            event.getChannel().sendMessage("Mashing Potatoes").queue();
        else if (message.equals("p!info cradily"))
            event.getChannel().sendMessage("gay").queue();
    }

    private void echo(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.substring(6, 8).equals("-h")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(message.substring(9)).queue();
        } else
            event.getChannel().sendMessage(message.substring(6)).queue();
    }

    private void help(MessageReceivedEvent event) {
        event.getChannel().sendMessage("```\n" +
                                            "Command List\n" +
                                            "$help - Display this list\n" +
                                            "$echo - Echo the user's input\n" +
                                            "\t(Optional parameter -h deletes original command)\n" +
                                            "$shutdown - Shutdown this bot\n" +
                                            "```").queue();

    }

    private void mash(MessageReceivedEvent event)
    {
        int i = 0;
        String temp = "";
        while(i < 40) //supposed to be i > 0
        {
            i++;
            if(i%6 == 1)
                temp = ".";
            else if(i%6 == 2)
                temp = "..";
            else if(i%6 == 3)
                temp = "...";
            else if(i%6 == 4)
                temp = "..";
            else if(i%6 == 5)
                temp = ".";
            else if(i%6 == 0)
                temp = "";
            event.getMessage().editMessage("Mashing Potatoes" + temp).queue();
        }
    }

}
