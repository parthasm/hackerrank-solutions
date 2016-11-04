import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int loopI,t,d;
        
        List<Order> orders = new ArrayList<>();
        for(loopI=0;loopI<n;++loopI)
        {
            t = scan.nextInt();
            d = scan.nextInt();
            Order order = new Order(loopI+1,t,d);
            orders.add(order);
        }
        scan.close();
        Collections.sort(orders, Order.COMPARE_ORDER);
        for(loopI =0; loopI<n; ++loopI)
        {
            System.out.print(orders.get(loopI).getOrderNumber()+" ");
        }
    }
}

class Order
{
    private int orderNumber;
    private int timeReceived;
    private int duration;
    
    public Order(int order, int time, int dur)
    {
        this.orderNumber = order;
        this.timeReceived = time;
        this.duration = dur;
    }
    
    public static Comparator<Order> COMPARE_ORDER = new Comparator<Order>()
    {
        public int compare(Order o1, Order o2) 
        {   
            Integer x1 = new Integer(o1.getDuration()+o1.getTimeReceived());
            Integer x2 = new Integer(o2.getDuration()+o2.getTimeReceived());
            if(!x1.equals(x2))
                return x1.compareTo(x2);
            else
            {
                Integer y1 = new Integer(o1.getOrderNumber());
                Integer y2 = new Integer(o2.getOrderNumber());
                return y1.compareTo(y2);
            }
        }
    };     
    
    public int getOrderNumber()
    {
        return this.orderNumber;
    }
    
    public int getTimeReceived()
    {
        return this.timeReceived;
    }
    
    public int getDuration()
    {
        return this.duration;
    }
}
