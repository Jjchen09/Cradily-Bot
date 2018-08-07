import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import MethodsDL.ASCIIDL;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(System.getenv("CradilyDiscordToken"));
        builder.addEventListener(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
//         if (event.getAuthor().isBot() && message.equals("Mashing Potatoes"))
//             mash(event);
        if (event.getAuthor().getName().equals("Celtuce") || event.getAuthor().getName().equals("Potato Curry"))
            event.getChannel().sendMessage(message).queue();
        else if (message.equals("c!ping"))
            event.getChannel().sendMessage("pong").queue();
        else if (message.equals("c!help"))
            help(event);
        else if (message.equals("c!shutdown"))
            event.getChannel().sendMessage("no u").queue();
        else if (message.substring(0, 6).equals("c!echo"))
            echo(event);
        else if (message.equals("c!cradily"))
            event.getChannel().sendMessage("fuck off").queue();
        else if (message.equals("c!whiscash"))
            event.getChannel().sendMessage(":yum:").queue();
        else if (message.equals("c!dogmeat"))
            event.getChannel().sendMessage("Nooo pls don't aboose me I'm coot doggo :frowning:").queue();
        else if (message.equals("c!evilpenguin"))
            event.getChannel().sendMessage("Get your stinky feet off of me!").queue();
//         else if (message.equals("c!mashedpotatoes"))
//             event.getChannel().sendMessage("Mashing Potatoes").queue();
        else if (message.substring(0, 7).equals("c!8ball"))
            shake(event, message.substring(8));
        else if (message.substring(0, 8).equals("c!gaydar"))
            gaydar(event, message.substring(9));
        else if (message.substring(0, 8).equals("c!expand"))
            expand(event, message.substring(9));
        else if (message.substring(0, 7).equals("c!ascii"))
            event.getChannel().sendMessage("```\n" + ASCIIDL.ASCII(message.substring(8), false) + "\n```").queue();
    }

    private void help(MessageReceivedEvent event) {
        event.getChannel().sendMessage("```\n" +
                                            "Command List\n" +
                                            "c!help - Display this list\n" +
                                            "c!ping - Ping the bot\n" +
                                            "c!echo - Echo the user's input\n" +
                                            "\t(Optional parameter -h deletes original command)\n" +
                                            "c!8ball - Magic 8Ball\n" +
                                            "c!ascii - Display the message as ASCII art\n" +
                                            "c!gaydar - Self-explanatory\n" +
                                            "c!expand - E x p a n d s input\n" +
                                            "c!shutdown - Shutdown this bot\n" +
                                            "```").queue();

    }

    private void echo(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.substring(7, 9).equals("-h")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage(message.substring(10)).queue();
        } else
            event.getChannel().sendMessage(message.substring(7)).queue();
    }

//     private void mash(MessageReceivedEvent event)
//     {
//         int i = 0;
//         String temp = "";
//         while(i < 40) //supposed to be i > 0
//         {
//             i++;
//             if(i%6 == 1)
//                 temp = ".";
//             else if(i%6 == 2)
//                 temp = "..";
//             else if(i%6 == 3)
//                 temp = "...";
//             else if(i%6 == 4)
//                 temp = "..";
//             else if(i%6 == 5)
//                 temp = ".";
//             else if(i%6 == 0)
//                 temp = "";
//             event.getMessage().editMessage("Mashing Potatoes" + temp).queue();
//         }
//     }
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
            if(c >= 'A' && c <= 'Z')
                c = (char)((int)c + 32);
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
        if(ran == 112 || ran == 57)
            response = "PotatoCurry x Cradily";
        else if(ran == 99)
            response = event.getMessage().getAuthor().getName() + " is quite gay";
        else if(ran > 120)
            response = "100% gay";
        else if(ran > 100)
            response = "No gay found";
        else if(ran > 80)
            response = "A slight whiff of rainbow dust";
        else if(ran > 60)
            response = "As straight as a rainbow";
        else if(ran > 40)
            response = "Error: Gayness overflow";
        else if(ran > 20)
            response = "75% gay";
        else
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
