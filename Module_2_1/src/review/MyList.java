package review;

public abstract class MyList {
    abstract void add(int x);
    abstract void remove(int index);
    abstract int get(int index);
    abstract int size();
    abstract int numberOfElements();
    @Override
    public String toString() {
        String ret = getClass().getName() + ": ";
        for (int i=0; i<size(); i++) {
            if (i<numberOfElements())
                ret = ret.concat(get(i) + ", ");
            else
                ret = ret.concat("0, ");
        }
        return ret;
    }
}
