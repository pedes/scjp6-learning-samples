package net.mgorski.scjp.test2;

public class TryCatch {
    
public static void main(String[] args) {
    try
    {
        throw new NullPointerException(new Exception().toString());
    } catch (NullPointerException e)
    {
        System.out.print("x");
    }
    catch (RuntimeException e)
    {
        System.out.print("y");
    }
    catch (Exception e)
    {
        System.out.print("z");   
    }        
    finally{System.out.println("a");}
}

}
