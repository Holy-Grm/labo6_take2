package labo6.bots.Behavior.Check;

public class CheckBehaviorPatient extends CheckBehavior{

    @Override
    public boolean checkForWakeUp(String currentText) {
        return currentText.endsWith("?");
    }

}
