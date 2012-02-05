package net.mgorski.scjp.tests.classes;

import java.util.ArrayList;
import java.util.List;

/****
 * 
 * 
 *  ?
 * 
 * 
 * @author gorskim
 *
 */
public class Ques04 {
	public static void main(String[] args) {
		List<? extends Instrument> allInstruments = new ArrayList<Instrument>(); 
		// -->X
//		allInstruments.add(new Guitar());
//		allInstruments.add(new Violin());
	}
}
abstract class Instrument {
	public abstract void play();
}
class Guitar extends Instrument {
	public void play(){
		System.out.println("Playing Guitar.");
	}
}
class Violin extends Instrument {
	public void play(){
		System.out.println("Playing Violin.");
	}
}

