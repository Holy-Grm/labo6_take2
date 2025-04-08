package labo6.bots.Behavior.Check;

public class CheckBehaviorSlowmo extends CheckBehavior {


    @Override
    public boolean checkForWakeUp(String currentText) {
        boolean shouldRespond = currentText.equals(getLastText());
        setLastText(currentText);
        return shouldRespond;
    }
}
