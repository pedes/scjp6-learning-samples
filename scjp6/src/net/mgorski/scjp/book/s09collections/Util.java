package net.mgorski.scjp.book.s09collections;

import java.util.Collection;

public class Util {
    
    public static <T> Collection<T> mergeCollections(Collection<T> col1, Collection<T> col2){
        if (col2 == null) {
            return col1;
        } else if (col1 == null) {
            return col2;
        } else {
            col1.addAll(col2);
            return col1; 
        }
    }

}
