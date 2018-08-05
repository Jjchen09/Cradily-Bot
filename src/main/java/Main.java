import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import MethodsDL.ASCIIDL;

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
        else if (message.substring(0, 7).equals("$gaydar"))
            gaydar(event, message.substring(8));
        else if (message.substring(0, 7).equals("$expand"))
            expand(event, message.substring(8));
        else if (message.substring(0, 6).equals("$ascii"))
            event.getChannel().sendMessage(ASCIIDL.ASCII(message, false)).queue();
    }

    private void help(MessageReceivedEvent event) {
        event.getChannel().sendMessage("```\n" +
                                            "Command List\n" +
                                            "$help - Display this list\n" +
                                            "$ping - Ping the bot\n" +
                                            "$echo - Echo the user's input\n" +
                                            "\t(Optional parameter -h deletes original command)\n" +
                                            "$8ball - Magic 8Ball\n" +
                                            "$ascii - Display the message as ASCII art\n" +
                                            "$shutdown - Shutdown this bot\n" +
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
        String response = "";
        if(ran%8 == 0)
            response = "Yes, definitely.";
        else if(ran%8 == 1)
            response = "There is a slight possibility.";
        else if(ran%8 == 2)
            response = "Impossible!";
        else if(ran%8 == 3)
            response = "Reply hazy. Feed me and try again.";
        else if(ran%8 == 4)
            response = "I'd say true.";
        else if(ran%8 == 5)
            response = "Doubt it.";
        else if(ran%8 == 6)
            response = "Very likely.";
        else if(ran%8 == 7)
            response = "Your answers are here: 1-800-273-8255.";
        event.getChannel().sendMessage("To your question: " + question + "\n" +
                                       ":crystal_ball: The All-Seeing Hooski says: " + response).queue();
    }

    private int hasher(String str)
    {
        int temp = 0;
        for(char c: str.toCharArray())
        {
            if((int)c == 32)
                continue;
            temp += (int)c*31;
            temp = (temp*temp)%139;
        }
        //optionally implement randomness
        return temp;
    }

    private void gaydar(MessageReceivedEvent event, String question)
    {
        int ran = hasher(question);
        String response = "";
        if(ran > 119)
            response = "100% gay";
        else if(ran > 99)
            response = "No gay found";
        else if(ran > 79)
            response = "A slight whiff of rainbow dust";
        else if(ran > 59)
            response = "As straight as a rainbow";
        else if(ran > 39)
            response = "Error: Gayness overflow";
        else if(ran == 6)
            response = "PotatoCurry x Cradily";
        else if(ran > 19)
            response = "75% gay";
        else if(ran > 0)
            response = "Too lonely to be gay :sob:";
        event.getChannel().sendMessage("How gay is " + question + "?\n" +
                                       ":satellite: " + response + " :gay_pride_flag:").queue();
    }

    private void expand(MessageReceivedEvent event, String str)
    {
        String response = "";
        for(char c: str.toCharArray())
        {
            response = response + c + " ";
        }
        event.getChannel().sendMessage(response).queue();
    }

}
