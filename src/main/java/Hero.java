public class Hero {
    private String mName;
    public String mCause;
    private String mMax;


    public Hero(String name,String cause,String max) {
        mName = name;
        mCause=cause;
        mMax=max;
    }

    public String getName(){
        return mName;
    }
    public String getCause() {

        return mCause;
    }
    public String getMax() {

        return mMax;
    }
}
