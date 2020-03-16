package eg.edu.alexu.csd.filestructure.sort;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import static eg.edu.alexu.csd.filestructure.sort.Controller.arr;
public class Main {
    public static void main(String[] args) {
        //Controller controller=new Controller();
        //Node s=new Node(1);
        //System.out.println(s.getNode());
   Heap h = new Heap();

   ArrayList<Comparable> j = new ArrayList<>() ;
   j.add(3);
   j.add(1);
   j.add(9);
   j.add(0);
   j.add(2);


       h.build(j);
        int limit =j.size()-1 ;
        while (h.size()>0){
            j.set(limit,  h.extract());
            limit--;
        }
        System.out.println(j.get(1));





    }
}
