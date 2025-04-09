package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorSlowmo;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorNothing;
import labo6.database.*;

public class CasualProfile extends Profiler {

    public CasualProfile(User peer) {
        super(peer);
    }

    public PictureList getSuitablePictures () {
        Ressources.Country human = getHumanCountry();

        PictureList piclist = PictureDatabase.getAllPictures();
        piclist = piclist.keep(Picture.PictureKey.isSeductive, false);
        if (human == Ressources.Country.Japan)
        {
            piclist = piclist.keep(Picture.PictureKey.isComic, true);
        }
        return piclist;
    }

    public TextList getSuitableMessages(){
        Ressources.Country human = getHumanCountry();

        TextList textlist = TextDatabase.getAllMessages();
        textlist = textlist.keep(TextMessage.TextKey.isSeductive, false);

        if (human == Ressources.Country.France || human == Ressources.Country.Quebec)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.french);
        }
        if (human == Ressources.Country.Japan || human == Ressources.Country.Canada)
        {
            textlist = textlist.keep(TextMessage.TextKey.language, TextMessage.Language.english);
        }
        return textlist;
    }

    public WaitBehavior createWaitBehavior(){
        return new WaitBehaviorNothing();
    }
    public CheckBehavior createCheckBehavior(){
        return new CheckBehaviorSlowmo();
    }
}
