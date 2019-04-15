public class Hero {
    private String mName;
    public String mCause;

    public Hero(String name,String cause) {
        mName = name;
        mCause=cause;
    }

    public String getName(){
        return mName;
    }
    public String getCause() {

        return mCause;
    }
}
