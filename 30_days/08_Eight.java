//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String[] argh)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,String> mapNamePhone = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            String phone = in.next();
            mapNamePhone.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            String num = mapNamePhone.get(s);
            if(num==null)
                System.out.println("Not found");
            else
                System.out.println(s+"="+num);
        }
        in.close();
    }
}
