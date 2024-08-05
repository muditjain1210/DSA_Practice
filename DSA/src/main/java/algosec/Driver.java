package algosec;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        //Interview example
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(new Segment(-10, 11));
        segmentList.add(new Segment(8, 10));
        segmentList.add(new Segment(0, 6));
        segmentList.add(new Segment(-6, 1));
        segmentList.add(new Segment(-2, 4));
        segmentList.add(new Segment(-4, 2));
        System.out.println(MaxIntersection.findMaxIntersection(segmentList)); //Ans: 5

        //No intersection
        List<Segment> segmentList2 = new ArrayList<>();
        segmentList2.add(new Segment(-10, 11));
        segmentList2.add(new Segment(12, 15));
        segmentList2.add(new Segment(16, 20));
        segmentList2.add(new Segment(21.0f, 23));
        segmentList2.add(new Segment(25.4f, 27));
        segmentList2.add(new Segment(27.8f, 29));
        System.out.println(MaxIntersection.findMaxIntersection(segmentList2)); //Ans: 0

        //two intersection
        List<Segment> segmentList3 = new ArrayList<>();
        segmentList3.add(new Segment(-10, 11));
        segmentList3.add(new Segment(11, 15));
        segmentList3.add(new Segment(16, 20));
        segmentList3.add(new Segment(21.0f, 23));
        segmentList3.add(new Segment(25.4f, 27));
        segmentList3.add(new Segment(27.8f, 29));
        System.out.println(MaxIntersection.findMaxIntersection(segmentList3)); //Ans: 2

        //All intersecting
        List<Segment> segmentList4 = new ArrayList<>();
        segmentList4.add(new Segment(-10, 11));
        segmentList4.add(new Segment(-9, 10));
        segmentList4.add(new Segment(-8, 8));
        segmentList4.add(new Segment(-7.0f, 7));
        segmentList4.add(new Segment(-6.4f, 6.5f));
        segmentList4.add(new Segment(-5.8f, 5));
        System.out.println(MaxIntersection.findMaxIntersection(segmentList4)); //Ans: 6
    }
}
