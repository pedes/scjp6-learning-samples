package net.mgorski.scjp.tests.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/****
 * 
 * 
 * ?
 * 
 * 
 * @author gorskim
 * 
 */
public class Ques04 {
    public static void main(String[] args) {
        List<? extends Instrument> allInstruments = new ArrayList<Instrument>();
        // -->X
        // allInstruments.add(new Guitar());
        // allInstruments.add(new Violin());

        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("2");
        pq.add("4");

        System.out.print(pq.peek() + " ");
        pq.offer("1");
        pq.add("3");
        pq.remove("1");
        System.out.print(pq.poll() + " ");
        if (pq.remove("2"))
            System.out.print(pq.poll() + " ");
        System.out.println(pq.poll() + " " + pq.peek());

    }
}

abstract class Instrument {
    public abstract void play();
}

class Guitar extends Instrument {
    public void play() {
        System.out.println("Playing Guitar.");
    }
}

class Violin extends Instrument {
    public void play() {
        System.out.println("Playing Violin.");
    }
}
