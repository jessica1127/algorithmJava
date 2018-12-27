import java.util.*;

class Intervals{
    int start;
    int end;
    Intervals(){
        start=0;
        end = 0;
    }
    Intervals(int s, int e){
        start = s;
        end = e;
    }
}

public class MergeIntervals56{
    public List<Intervals> merge(List<Intervals> intervals) {
        List<Intervals> res = new ArrayList<Intervals>();
        if(intervals.size() == 0){
            return res;
        }
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for(int i =0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0; i<intervals.size(); i++){
            int st = start[i];
            while(i<intervals.size()-1 && end[i] >= start[i+1]){
                i++;
            }
            int en = end[i];
            Intervals intv = new Intervals(st, en);
            res.add(intv);
        }
        return res;
    }


    public static void main(String[] args){
        List<Intervals> input = new ArrayList<Intervals>();
        input.add(new Intervals(1,3));
        input.add(new Intervals(2,6));
        input.add(new Intervals(8,10));
        input.add(new Intervals(15,18));
        for(int i=0; i<input.size(); i++){
            System.out.print("[" + input.get(i).start + " " + input.get(i).end + "]");
        }
        System.out.println(" ");
        MergeIntervals56 mi = new MergeIntervals56();
        List<Intervals> res = mi.merge(input);
        for (int i=0; i<res.size(); i++){
            System.out.print("["+res.get(i).start + " " + res.get(i).end+"]");
        }
        
    }
}