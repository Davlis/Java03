/*
 * Created by Dawid Liszka
 */
import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Figures
{
    public static void main(String[] args)
     {
        // simple tests
        try
        {
            List<Quadrangle> listOfQuadrangles = new ArrayList<Quadrangle>();

            Point x1 = new Point(0,0);
            Point x2 = new Point(4,0);
            Point x3 = new Point(0,4);
            Point x4 = new Point(4,4);

            Point xx1 = new Point(0,0);
            Point xx2 = new Point(1,0);
            Point xx3 = new Point(1,1);
            Point xx4 = new Point(0,1);


            Quadrangle a = new Quadrangle(x1,x2,x3,x4); 
            a.setPointA(new Point(10,10));
            listOfQuadrangles.add(new Quadrangle());
            listOfQuadrangles.add(a);

            Collections.sort(listOfQuadrangles);
            System.out.println(listOfQuadrangles);

            System.out.println(xx1);

            Quadrangle aa = new Quadrangle(xx1,xx2,xx3,xx4);
            System.out.println(aa.diagonal(new Point(0,0)));
        }
        catch(RuntimeException e)
        {
            System.out.println(e);
        }  
     }
}