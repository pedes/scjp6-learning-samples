package net.mgorski.scjp.tests.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MyNavigableSet  {

	
	 public static void main(String args[]){
	        List<Integer> list = new ArrayList<Integer>();
	        list.add(3);
	        list.add(4);
	        list.add(1);
	        list.add(8);
	        list.add(7);
	        list.add(10);
	        
	        NavigableSet navigableSet = new TreeSet(list);
	        System.out.println(navigableSet.lower(8));
	        System.out.println(navigableSet.higher(8));
	        
	        NavigableSet<Integer> hhhsss = navigableSet.headSet(8, true);
	        for (Integer in : hhhsss) {
				System.out.println("HS : " + in);
			}
	        
	        
	        
	        SortedSet<Integer> ss = navigableSet.subSet(3, 8); // subSet( .., TRUE,..,FALSE) !!!
	        for (Integer in : ss) {
				System.out.println("SS: " + in);
			}
	        
	        
	        // treeeset
	        TreeSet<Integer> s = new TreeSet<Integer>();
	        s.add(0);
	        s.add(2);
	        s.add(4);
	        s.add(6);
	        Set<Integer> sss = s.subSet(0, 4);
	        System.out.println(sss.size());
	        s.add(3);
	        System.out.println(sss.size());
	        
	    }



}
