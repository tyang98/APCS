import java.util.*;
/**
 * Write a description of class set here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class set
{
    public static void main(String[] args)
    {
        Q1();
    }
    public static void Q1() 
     {
         Set<Integer> s1 = new TreeSet<Integer>();
         Set<Integer> s2 = new TreeSet<Integer>();
   for (int i = 0; i < 10; i += 2)
   {
     s1.add(i);
   }
   for (int i = 0; i < 10; i += 3)
   {
     s2.add(i);
   }
   s1.retainAll(s2);
   s2.removeAll(s1);
   System.out.println(s1);
   System.out.println(s2);
 }

}
