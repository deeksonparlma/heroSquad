import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mSuperPower;
    private static List<Hero> instances = new ArrayList<Hero>();

    public Hero(String superPower){
        mSuperPower = superPower;
        instances.add(this);
    }

    public String getSuperPower() {
        return mSuperPower;
    }
}
