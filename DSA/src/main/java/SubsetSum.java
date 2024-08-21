import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class SubsetSum {


    private static List<List<Integer>> findSubsetSum(int[] set, int sum) {
        int totalSum = 0;
        for (int i : set) {
            totalSum = totalSum + i;
        }
        List<List<Integer>> subsets = new ArrayList<>();
        recursiveSolve(set, sum, 0, 0, totalSum, new ArrayList<>(), subsets);
        System.out.println(subsets);


        return null;
    }

    private static void recursiveSolve(int[] set, int sum, int index, int currentSum,
                                       int remSum, List<Integer> subset, List<List<Integer>> subsets) {
        if (currentSum == sum) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        if (remSum == 0 || currentSum > sum) {
            return;
        }


        subset.add(set[index]);
        recursiveSolve(set, sum, index + 1, currentSum + set[index], remSum - set[index], subset, subsets);

        subset.remove(subset.size() - 1);
        recursiveSolve(set, sum, index + 1, currentSum, remSum - set[index], subset, subsets);

    }


    public static void main(String[] args) {
        int[] set = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 10;
        findSubsetSum(set, sum);

    }
}
