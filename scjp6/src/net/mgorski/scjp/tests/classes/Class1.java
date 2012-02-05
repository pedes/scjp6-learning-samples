package net.mgorski.scjp.tests.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JButton;

public class Class1 {

	/* default : public */String thisIsTheOutherClassMember;

	/* default: public */void method() {

		String msg2 = "aaa";
		final String msg3 = "bbb";

		class MyInnerClass extends Date implements Serializable {
			private static final long serialVersionUID = 1015588183407524463L;

			public MyInnerClass() {
				// msg2 = "aaa"; // CANNOT REFER TO A NON-FINAL VARIABLE !!!
				System.out.println(msg3);
			}

			private String sth;

			public void setSth(String sth) {
				this.sth = sth;
			}

			public String getSth() {
				return sth;
			}
		}

		MyInnerClass myc1 = new MyInnerClass();
		myc1.setSth(thisIsTheOutherClassMember);
		if (true) {
			// MyInnerClass myc1 = new MyInnerClass(); // DUPLICATE LOCAL VAR
			MyInnerClass myc2 = new MyInnerClass();
		}

		method2();
		method3();
	}



	/**
	 *
	 */
	public void method2() {

		// NOT VISIBLE !!
		// MyInnerClass myc1 = new MyInnerClass();
		// myc1.setSth(msg);
		
		
		final String localVariableInMethodButNotFinal = "dupszczal";

		/**
		 * ANONYMOUS CLASS
		 * - The definition, construction and first use of such class is at same place. 
		 * 
		 * - An anonymous class is never abstract
		 * - it is never static
		 * 
		 * - An anonymous class is always implicitly final.
		 * - An anonymous class is always an inner class 
		 */
		JButton jb = new JButton();
		jb.addActionListener(new ActionListener()  {
			
			private final int integer1 = 1;
			private int integer2 = 2;
			public int integer3 = 3;  // could not be read from outside - warning !
			
			public void actionPerformed(ActionEvent e) {

				
				Class1.this.thisIsTheOutherClassMember = "1111"; // OK 
				
				this.toString();
				
				this.integer3 = this.integer2;
				int iii = this.integer1;
				
				/**
				 * I can read it, but it's a snapshot ( it means, that may access this value even the outer class 
				 * stopped to exist.
				 */
				System.out.println(localVariableInMethodButNotFinal); 
				
				Class1.this.thisIsTheOutherClassMember = "assss";
				// do sth

			}
		} // end anonymous class
		); // end addActionListener lin

		new Thread() {
			public void run() {
				try {
					int i = 0;
					while (i++ < 10) {
						sleep(400);
						System.out.print(".");
					}
				} catch (InterruptedException ex) {
				}
			}
		}.start();

	}
	
	private void method3() {
		
		
		
		
	}
	
	public static class Class3 { 
		
		public static String aaa = "aaa"; // CAN BE STATIC IN A STATIC SUBCLASS
		public String bbb = "bbb";
		
	}
	
	public class Class4 { 
		
//		public static String aaa = "aaa"; // CANNOT BE STATIC !!!
		public String bbb = "bbb";
		
	}
	
	public abstract class Class5 { // OK 
		
	}
	
	public final class Class6 { // OK  
		
	}

}
