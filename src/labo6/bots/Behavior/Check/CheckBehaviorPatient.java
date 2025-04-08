package labo6.bots.Behavior.Check;

import labo6.bots.ChatBot;

public class CheckBehaviorPatient extends CheckBehavior{

    @Override
    public boolean checkForWakeUp(String currentText, ChatBot bot) {
        return currentText.endsWith("?");
    }

}
