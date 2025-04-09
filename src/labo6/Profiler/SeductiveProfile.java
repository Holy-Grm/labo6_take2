package labo6.Profiler;

import labo6.Ressources;
import labo6.User;
import labo6.bots.Behavior.Check.CheckBehavior;
import labo6.bots.Behavior.Check.CheckBehaviorImpatient;
import labo6.bots.Behavior.Wait.WaitBehavior;
import labo6.bots.Behavior.Wait.WaitBehaviorSaySomething;
import labo6.database.*;

public class SeductiveProfile extends Profiler {


    public SeductiveProfile(User peer) {
        super(peer);
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

@Override
    public Ressources.Gender getSuitableGender(){
        Ressources.Gender gender;
        if(human.getGender() == Ressources.Gender.man)
        {
            if (Math.random() < 0.5) {
                gender = Ressources.Gender.woman;
            } else {
                gender = Ressources.Gender.nonbinary;
            }
        }

        else if (human.getGender() == Ressources.Gender.woman)
        {
            if (Math.random() < 0.5) {
                gender = Ressources.Gender.man;
            } else {
                gender = Ressources.Gender.nonbinary;
            }
        }

        else {
            if (Math.random() < 0.5) {
                gender = Ressources.Gender.man;
            } else {
                gender = Ressources.Gender.woman;
            }
        }
        return gender;
    }

    /* Version qui ne tien pas compte des non binary

    @Override
    public Ressources.Gender getSuitableGender(){
        Ressources.Gender gender;
        if(human.getGender() == Ressources.Gender.man)
        {
            gender = Ressources.Gender.woman;
        }

        else if (human.getGender() == Ressources.Gender.woman)
        {
            gender = Ressources.Gender.man;
        }
        else {
            gender = Ressources.Gender.nonbinary;

        }
        return gender;
    }*/
}
