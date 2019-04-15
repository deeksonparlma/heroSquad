import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Herotest {
        @Test
        public void Hero_gets_name(){
            Hero hero = new Hero("Dickson", "Catch pick-pocketers");
            assertEquals("Dickson", hero.getName());
        }
    @Test
    public void Hero_gets_cause(){
        Hero hero = new Hero("Dickson", "Catch pick-pocketers");
        assertEquals("Catch pick-pocketers", hero.getCause());
    }
}
