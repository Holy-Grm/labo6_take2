package labo6.bots.Behavior.Check;

public class CheckBehaviorImpatient extends CheckBehavior{

    @Override
    public boolean checkForWakeUp(String currentText) {
        return !currentText.trim().isEmpty();
    }
}
