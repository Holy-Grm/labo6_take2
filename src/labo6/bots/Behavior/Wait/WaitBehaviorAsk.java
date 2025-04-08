package labo6.bots.Behavior.Wait;

import labo6.bots.ChatBot;
import labo6.database.TextDatabase;
import labo6.database.TextList;
import labo6.database.TextMessage;

/*
public class WaitBehaviorAsk extends WaitBehavior {

    @Override
    public void waitForUser() {
        sleep(2000);
        TextList list = TextMessage.getMessages();
        list = list.keep(TextMessage.TextKey.isQuestion, true);
        ChatBot.appendMessage(list.random().getMessage());
    }
}*/