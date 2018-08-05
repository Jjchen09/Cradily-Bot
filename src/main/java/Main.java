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
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot() && message.equals("Mashing Potatoes"))
            mash(event);
        else if (message.equals("$ping"))
            event.getChannel().sendMessage("pong").queue();
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
        else if (message.substring(0, 6).equals("$8ball"))
            shake(event, message.substring(7));
    }

    private void help(MessageReceivedEvent event) {
        event.getChannel().sendMessage("```\n" +
                                            "Command List\n" +
                                            "$help - Display this list\n" +
                                            "$ping - Ping the bot\n" +
                                            "$echo - Echo the user's input\n" +
                                            "\t(Optional parameter -h deletes original command)\n" +
                                            "$shutdown - Shutdown this bot\n" +
                                            "$8ball - Magic 8Ball\n" +
                                            "```").queue();

    }

    private void echo(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.substring(6, 8).equals("-h")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(message.substring(9)).queue();
        } else
            event.getChannel().sendMessage(message.substring(6)).queue();
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
    private void shake(MessageReceivedEvent event, String question)
    {
        int ran = (int) (Math.random()*48);
        if(ran%8 == 0)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " + 
                                           "Yes, definitely.").queue();
        else if(ran%8 == 1)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "There is a slight possibility.").queue();
        else if(ran%8 == 2)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "Impossible!").queue();
        else if(ran%8 == 3)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "Reply hazy. Feed me and try again.").queue();
        else if(ran%8 == 4)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "There is a spectre haunting Europe, the spectre of communism...").queue();
        else if(ran%8 == 5)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "You're too dumb to understand my answers.").queue();
        else if(ran%8 == 6)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "Very likely.").queue();
        else if(ran%8 == 7)
            event.getChannel().sendMessage("To your question: " + question + "\n" +
                                           ":crystal_ball: The All-Seeing Hooski says: " +
                                           "Your answers are here: 1-800-273-8255.").queue();
    }

}
