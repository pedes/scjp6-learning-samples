package net.mgorski.scjp.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Mian {
    
    
    private static final int ELEMENTS = 256;
    private static final int REPEAT_LOOKUP = 10000;
    private static final int MAX_SIZE = 100000;
    private static int[] lookupTable = new int[ELEMENTS];
    
    public static void main(String[] args) {
        
        Random r = new Random();
        for(int i=0; i<256; i++){
            lookupTable[i] = r.nextInt(MAX_SIZE);
        }
        
        
        DataLoad dataLoad = new DataLoad(MAX_SIZE,512,false);
        
        TimeTester tt = new TimeTester("conversion ",false);
        Profile[] arr = dataLoad.getArr();
        tt.time();
        
        lookup(rewriteHashMap(arr));
        
        lookup(rewriteHashMapAlloc(arr));
        
        lookup(rewriteLinkedList(arr));
        
        lookup(rewriteArrayListAlloc(arr));
        

        
    }
    
    
    private static Map<Integer,Profile> rewriteHashMap(Profile[] arr){
        TimeTester tForeach = new TimeTester("Rewrite to hash map [id]->Profile", false);
        Map<Integer, Profile> map = new HashMap<Integer, Profile>();
        for (Profile profile : arr) {
            map.put(profile.getId(), profile);
        }
        tForeach.time();
        return map;
    }
    
    private static Map<Integer,Profile>  rewriteHashMapAlloc(Profile[] arr){
        TimeTester tForeach = new TimeTester("Rewrite to hash map [id]->Profile (allocated)", false);
        Map<Integer, Profile> map = new HashMap<Integer, Profile>(arr.length);
        for (Profile profile : arr) {
            map.put(profile.getId(), profile);
        }
        tForeach.time();
        return map;
    }
    
    private static List<Profile>  rewriteLinkedList(Profile[] arr){
        TimeTester tForeach = new TimeTester("Rewrite to linkedList [id]->Profile", false);
        List<Profile> list = new LinkedList<Profile>();
        for (Profile profile : arr) {
            list.add(profile);
        }
        tForeach.time();
        return list;
    }
    
    private static List<Profile> rewriteArrayListAlloc(Profile[] arr){
        TimeTester tForeach = new TimeTester("Rewrite to linkedList [id]->Profile", false);
        List<Profile> list = new ArrayList<Profile>(arr.length);
        for (Profile profile : arr) {
            list.add(profile);
        }
        tForeach.time();
        return list;
    }
    
    private static Profile lookup(Map<Integer, Profile> map) {
        TimeTester timeTester = new TimeTester("Lookup...", false);
        Profile profile = null;
        for (int j=0; j<REPEAT_LOOKUP; j++)
            for(int i=0; i<lookupTable.length; i++){
                profile = map.get(lookupTable[i]);
            }
        timeTester.time();
        return profile;
    }
    
    private static Profile lookup(List<Profile> list ) {
        TimeTester timeTester = new TimeTester("Lookup...", false);
        Profile profile = null;
        for (int j=0; j<REPEAT_LOOKUP; j++)
            for(int i=0; i<lookupTable.length; i++){
                profile = list.get(lookupTable[i]);
            }
        timeTester.time();
        return profile;
    }
}
