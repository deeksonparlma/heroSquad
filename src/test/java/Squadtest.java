import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Squadtest {
    @Test
    public void squad_gets_cause(){
        Squad hero = new Squad( "Catch pick-pocketers");
        assertEquals("Catch pick-pocketers", hero.getCause());
    }
}
