import java.util.*;

class Program36
{
    public static void main(String A[])
    {
        ArrayList <Double> aobj = new ArrayList <Double> ();

        aobj.add(10.5);
        aobj.add(20.5);
        aobj.add(30.5);
        aobj.add(40.5);
        
        System.out.println(aobj);

        if(aobj.contains(20.5))
        {
            System.out.println("Element is present.");
        }

        aobj.remove(30.5);

        System.out.println(aobj);

        System.out.println("Number of problems in arraylist are : " + aobj.size());

        for(Double dValue : aobj)
        {
            System.out.println(dValue);
        }
    }
}