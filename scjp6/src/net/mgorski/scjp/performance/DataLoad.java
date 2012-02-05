package net.mgorski.scjp.performance;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataLoad {
    
    private boolean random = true;
    private int increment = 0;
    private int intLimit = 128;
    final Random r = new Random();
    final List<Profile> arr = new LinkedList<Profile>();
    
    /**
     * 
     * @param amount amount of elements to allocate
     * @param intLimit max size of the arrays
     * @param random use random amounts/ strings ( results will be different )
     */
    public DataLoad(int amount, int intLimit, boolean random) {
        this.intLimit = intLimit;
        this.random = random;
        createDataLoad(amount);
    }
    
    public Profile[] getArr() {
        return arr.toArray(new Profile[0]);
    }

    private void createDataLoad(int amount) {
        assert amount > 0;
        Log.log("Creating "+ amount +" objects.");
        TimeTester creationTime = new TimeTester("Creation of the objects",false);
        for (int i = 0; i<amount; i++){
            Profile p = new Profile();
            p.setFriendIds(randomIntArrat(nextPositiveInt()));
            p.setId(i);
            p.setName(randomString(nextPositiveInt()));
            p.setSurname(randomString(nextPositiveInt()));
            arr.add(p);
        }
        creationTime.time();
    }
    
    private synchronized int nextPositiveInt(){
        if(random){
            return Math.abs(r.nextInt(this.intLimit));
        }else{
            if( (increment<intLimit) ) { increment++; } else {increment = 0;};
            return increment;
        }
    }
    
    
    private String randomString(int lenght){
        assert lenght > 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<lenght; i++){
            sb.append( (char) nextPositiveInt());
        }
        return sb.toString();
    }
    
    private int[] randomIntArrat(int lenght){
        assert lenght > 0;
        int[] table = new int[lenght];
        for(int i=0; i<lenght; i++){
         table[i] = nextPositiveInt();   
        }
        return table;
    }
    
    
}
