package labo6.bots.Behavior.Check;
import labo6.bots.ChatBot;

public class CheckBehaviorSlowmo extends CheckBehavior {


    @Override
    public boolean checkForWakeUp(String currentText, ChatBot bot) {
        boolean shouldRespond = currentText.equals(bot.getLastText());
        bot.setLastText(currentText);
        return shouldRespond;
    }
}
