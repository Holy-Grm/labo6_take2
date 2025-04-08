package labo6.bots.Behavior.Wait;

import labo6.bots.ChatBot;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;


public class WaitBehaviorAsk extends WaitBehavior {

    @Override
    public void waitForUser(ChatBot bot) {
        bot.sleep(2000);
        TextList list = TextDatabase.getAllMessages();
        list = list.keep(TextMessage.TextKey.isQuestion, true);
        bot.appendMessage(list.random().getMessage());
    }
}