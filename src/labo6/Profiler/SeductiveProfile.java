package labo6.Profiler;

import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorImpatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorSaySomething;
import labo6.database.*;

public class SeductiveProfile extends Profiler {


    public SeductiveProfile() {
        super();
    }

    public PictureList getSuitablePictures () {
        PictureList piclist = PictureDatabase.getAllPictures();
        piclist = piclist.keep(Picture.PictureKey.isSeductive, true);
        return piclist;
    }

    public TextList getSuitableMessages(){
        TextList textlist = TextDatabase.getAllMessages();
        textlist = textlist.keep(TextMessage.TextKey.isSeductive, true);
        return textlist;
    }

    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorSaySomething();
    }
    public CheckBehavior createCheckBehavior(){
        return new CheckBehaviorImpatient();
    }
}
