package datastorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Point {

    public HashMap<String, Double> points ;
    public int docNum = 0;
    private int cluster_number = 0;
    
    public Point(HashMap<String, Double> points,int docNum)
    {
        this.points = points;
        this.docNum = docNum;
    }
    
    public void setVal(HashMap<String,Double> points) {
        this.points = points;
    }
    
    public HashMap<String,Double> getVal()  {
        return this.points;
    }
    
    public void setCluster(int n) {
        this.cluster_number = n;
    }
    
    public int getCluster() {
        return this.cluster_number;
    }
    
    //Calculates the distance between two points.
    protected static double distance(Point p, Point centroid) {
        Iterator it = centroid.points.entrySet().iterator();
        double tmp = 0;
        while (it.hasNext()) {
            Map.Entry<String,Double> pair = (Map.Entry)it.next();
//            System.out.println(centroid.docNum);
            tmp += Math.pow(centroid.points.get(pair.getKey()) - p.points.get(pair.getKey()), 2);
            it.remove(); // avoids a ConcurrentModificationException
        }
        return Math.sqrt(tmp);
    }
    
    //Creates random point
    protected static Point createRandomPoint(int min, int max , ArrayList<String> demention) {
    	Random r = new Random();
        HashMap<String,Double> tmpHash = new HashMap<>();
        for(String dem : demention) {
            tmpHash.put(dem, min + (max - min) * r.nextDouble());
        };
    	return new Point(tmpHash,-1);
    }
    
    protected static ArrayList<Point> createRandomPoints(int min, int max, int number,ArrayList<String> demention) {
    	ArrayList<Point> points = new ArrayList();
    	for(int i = 0; i < number; i++) {
    		points.add(createRandomPoint(min,max,demention));
    	}
    	return points;
    }
    
    @Override
    public String toString() {
    	return "";
    }
}