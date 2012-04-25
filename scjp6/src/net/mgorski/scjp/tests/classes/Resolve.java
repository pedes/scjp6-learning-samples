package net.mgorski.scjp.tests.classes;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class Resolve {
	   public static void main(String argv[]) {
	      // The user should provide a file to lookup
	      if (argv.length != 1) {
	         System.err.println("Usage: java Resolve ");
	         System.exit(-1);
	      }

	      String name = argv[0];

	      // Here we use the file system service provider
	      Hashtable env = new Hashtable();
	      env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");

	      try {
	         // Create the initial context
	         Context ctx = new InitialContext(env);

	         // Look up an object
	         Object obj = ctx.lookup(name);

	         // Print it out
	         System.out.println(name + " is bound to: " + obj);

	         // Close the context
	         ctx.close();
	      } catch (NamingException e) {
	         System.err.println("Problem looking up " + name + ": " + e);
	      }
	   }
	}

