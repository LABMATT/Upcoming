package space.labmatt.Transport;

import space.labmatt.Transport.Struts.Autho;

import java.util.List;

public class AuthoSessions {

    List<Autho> autoList;


    // If the session ID matches then return it.
    public synchronized Autho getAuto(String sessionID) {

        for (Autho autho : autoList) {

            if(autho.sessionID.equals(sessionID)) {

                return autho;
            }
        }

        return null;
    }
}
