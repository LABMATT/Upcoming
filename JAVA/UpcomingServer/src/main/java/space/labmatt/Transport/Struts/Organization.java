package space.labmatt.Transport.Struts;

import java.util.List;

// This is now
public class Organization {

    public List<Account> accountList;
    public List<Autho> currentLogins;
    public List<Entry> entryList;

    public String orgID = null;
    public String orgNAME = null;
    public String dateCREATED = null;
    public String orgCONTACTS = null;
    public String rgLOG = null;
    public boolean enabled = true;
}
