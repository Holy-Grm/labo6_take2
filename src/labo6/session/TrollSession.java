package labo6.session;

import labo6.Labo6Main;
import labo6.Profiler.CasualProfile;
import labo6.Profiler.NormalProfile;
import labo6.Profiler.Profiler;
import labo6.Profiler.TrollProfile;
import labo6.Ressources;
import labo6.User;


public class TrollSession extends Session {


    //Constructeur.
    public TrollSession(Labo6Main l, User u) {
        super(l, u);
    }


    @Override
    public Profiler createProfiler(User peer) {

        return new TrollProfile(human);}
    }