package labo6.bots.Behavior.Wait;

import labo6.bots.ChatBot;

public class WaitBehaviorNothing extends WaitBehavior{

    @Override
    public void waitForUser(ChatBot bot) {
        bot.sleep(2000);
    }
}
