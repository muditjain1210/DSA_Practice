package algosec;


import java.util.List;

public class MaxIntersection {

    public static int findMaxIntersection(List<Segment> segmentList) {
        int intersections = 0;
        float minIntersectionPoint = Integer.MIN_VALUE;

        //First sort the segment using their left value, using lambda exp (java 8+)
        segmentList.sort((s1, s2) -> Float.compare(s1.getLeft(), s2.getLeft()));

        //Print the sorted list
        System.out.println("Sorted list is : " + segmentList);

        //Make the first element of sorted list as starting segment
        Segment comparingSeg = segmentList.get(0);
        for (int i = 1; i < segmentList.size(); i++) {
            Segment currentSeg = segmentList.get(i);

            //When there is no intersection i.e., if current segment left element is greater than right of comparing segment,
            //change comparing segment to current segment. e.g. ComparingSeg:- (-10,-9) Current : (-8,3)
            if (currentSeg.getLeft() > comparingSeg.getRight()) {
                comparingSeg = currentSeg;
                continue;
            }

            intersections++;
            minIntersectionPoint = currentSeg.getLeft();

            // will make right of comparing segment as minimum of right of current and comparing segment
            // will make left of comparing segment as left of current segment. [left is already sorted]
            comparingSeg.setRight(Math.min(currentSeg.getRight(), comparingSeg.getRight()));
            comparingSeg.setLeft(currentSeg.getLeft());

        }

        //Minimum intersection point for maximum intersections
        if (intersections > 0) {
            System.out.println("Minimum point for max intersections is : " + minIntersectionPoint);
        }

        //We need to add 1, if there is at least one intersection
        return intersections == 0 ? intersections : intersections + 1;
    }

    class VertexWeight {
        String vertex;
        double weight;

        public VertexWeight(String vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "VertexWeight{" +
                    "vertex='" + vertex + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
