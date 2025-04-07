package labo6.bots;

import labo6.Ressources;
import labo6.User;
import labo6.database.Picture;
//casual
public class SlowmoChatBot extends ChatBot {
    public SlowmoChatBot(User p, String n, Picture pic, Ressources.Gender g) {
        super(p, n, pic, g);
    }

    @Override
    public boolean checkForWakeUp(String currentText) {
        boolean shouldRespond = currentText.equals(getLastText());
        setLastText(currentText);
        return shouldRespond;
    }
}