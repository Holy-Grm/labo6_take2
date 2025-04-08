package labo6.bots.Behavior.Wait;

import labo6.bots.ChatBot;
import labo6.database.TextDatabase;
import labo6.database.TextList;

public class WaitBehaviorSaySomething extends WaitBehavior{

    @Override
    public void waitForUser(ChatBot bot) {
        bot.sleep(2000);
        TextList list = TextDatabase.getAllMessages();
        bot.appendMessage(list.random().getMessage());
    }
}
