import java.io.*;
import java.util.*;
public class Solution{
    static PrintWriter pw;
    
    static class Point{
        int x, y;
        Point left, right, top, bottom;
        Point(int x, int y){
            this.x = x;
            this.y = y;
            left = null;
            right = null;
            top = null;
            bottom = null;
        }
    }
    
    public static void main(String args[])throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        
        for(int q=1; q<=t; q++){
            pw.print("Case #"+q+": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            
            int n = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            int sr = Integer.parseInt(tokenizer.nextToken());
            int sc = Integer.parseInt(tokenizer.nextToken());
            
            String command = reader.readLine();
            
            HashMap<Integer, HashMap<Integer, Point>> map = new HashMap<>();
            
            Point orig = new Point(sr, sc);
            orig.top = orig;
            orig.bottom = orig;
            orig.left = orig;
            orig.right = orig;
            
            map.put(sr, new HashMap<>());
            map.get(sr).put(sc, orig);
            
            Point last = orig;
            for(char k: command.toCharArray()){
                Point newPoint = null;
                int newx = -1, newy = -1;
                switch(k){
                    case 'N':
                        newx = last.top.x-1;
                        newy = last.y;
                        break;
                    case 'E':
                        newx = last.x;
                        newy = last.right.y+1;
                        break;
                    case 'W':
                        newx = last.x;
                        newy = last.left.y-1;
                        break;
                    case 'S':
                        newx = last.bottom.x+1;
                        newy = last.y;
                        break;
                }
                newPoint = new Point(newx, newy);
                
                if(!map.containsKey(newx))
                    map.put(newx, new HashMap<>());
                map.get(newx).put(newy, newPoint);
                
                Point top = newPoint, left = newPoint, bottom = newPoint, right = newPoint;
                
                if(map.containsKey(newx-1) && map.get(newx-1).containsKey(newy))
                    top = map.get(newx-1).get(newy).top;
                    
                if(map.containsKey(newx+1) && map.get(newx+1).containsKey(newy))
                    bottom = map.get(newx+1).get(newy).bottom;
                    
                if(map.get(newx).containsKey(newy-1))
                    left = map.get(newx).get(newy-1).left;
                    
                if(map.get(newx).containsKey(newy+1))
                    right = map.get(newx).get(newy+1).right;
                    
                newPoint.top = top;
                newPoint.bottom = bottom;
                newPoint.left = left;
                newPoint.right = right;
                
                top.bottom = bottom;
                bottom.top = top;
                left.right = right;
                right.left = left;
                
                last = newPoint;
            }
        
            pw.println(+last.x+" "+last.y);
        }
        pw.flush();
        pw.close();
    }
}
