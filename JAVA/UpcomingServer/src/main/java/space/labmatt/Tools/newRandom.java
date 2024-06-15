package space.labmatt.Tools;

import java.util.concurrent.ThreadLocalRandom;


// creates a semirandom number to store data in.
public class newRandom {

    public int genrateRandom() {

        return Math.abs(ThreadLocalRandom.current().nextInt());
    }
}
