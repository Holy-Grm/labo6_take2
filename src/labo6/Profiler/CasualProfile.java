package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorSlowmo;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorNothing;
import labo6.database.*;

public class CasualProfile extends Profiler {

    public CasualProfile() {
        super();
    }

    public PictureList getSuitablePictures () {
        PictureList piclist = PictureDatabase.getAllPictures();
        piclist = piclist.keep(Picture.PictureKey.isSeductive, false);
        return piclist;
    }

    public TextList getSuitableMessages(){
        TextList textlist = TextDatabase.getAllMessages();
        textlist = textlist.keep(TextMessage.TextKey.isSeductive, false);
        return textlist;
    }

    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorNothing();
    }
    public CheckBehavior createCheckBehavior(){
        return new CheckBehaviorSlowmo();
    }
}
