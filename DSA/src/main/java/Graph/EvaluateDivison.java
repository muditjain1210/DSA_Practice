package Graph;

import java.util.*;

public class EvaluateDivison {


    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<VertexWeight>> adjList = prepareAdjancencyList(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < result.length; i++) {
            Set<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            String left = query.get(0);
            String right = query.get(1);
            if (!adjList.containsKey(left) || !adjList.containsKey(right)) {
                result[i] = -1.0;
                continue;
            }
            if (left.equals(right)) {
                result[i] = 1.0;
                continue;
            }
            visited.add(left);
            result[i] = dfs(left, right, adjList, visited);
        }
        return result;

    }

    public static double dfs(String left, String right, Map<String, List<VertexWeight>> adjList, Set<String> visited) {
        List<VertexWeight> vwtList = adjList.get(left);
        double result = 1.0;
        for (VertexWeight vwt : vwtList) {
            if (visited.contains(vwt.vertex)) {
                continue;
            }
            if (vwt.vertex.equals(right)) {
                return vwt.weight;
            }
            visited.add(vwt.vertex);
            result = vwt.weight * dfs(vwt.vertex, right, adjList, visited);
        }
        return result;
    }

    private static Map<String, List<VertexWeight>> prepareAdjancencyList(List<List<String>> equations, double[] values) {

        Map<String, List<VertexWeight>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double wt = values[i];
            String left = equation.get(0);
            String right = equation.get(1);

            VertexWeight vwt = new VertexWeight(right, wt);
            List<VertexWeight> vwtList = null;
            if (adjList.containsKey(left)) {
                vwtList = adjList.get(left);
                vwtList.add(vwt);
            } else {
                vwtList = new ArrayList<>();
                vwtList.add(vwt);
                adjList.put(left, vwtList);
            }

            // Add reverse as well
            VertexWeight vwtRev = new VertexWeight(left, 1 / wt);
            List<VertexWeight> vwtListRev = null;
            if (adjList.containsKey(right)) {
                vwtListRev = adjList.get(right);
                vwtListRev.add(vwtRev);
            } else {
                vwtListRev = new ArrayList<>();
                vwtListRev.add(vwtRev);
                adjList.put(right, vwtListRev);
            }

        }
        return adjList;

    }

    public static void main(String[] args) {
        String[][] equations1 = {{"a", "b"}, {"b", "c"}};
        List<List<String>> equations = new ArrayList<>();
        for (String[] eq : equations1) {
            equations.add(Arrays.asList(eq));
        }

        double[] values = new double[]{2.0, 3.0};

        String[][] array = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries = new ArrayList<>();
        for (String[] subArray : array) {
            queries.add(Arrays.asList(subArray));
        }

        double[] result = calcEquation(equations, values, queries);
        for (double v : result) {
            System.out.println(v);
        }
    }

    static class VertexWeight {
        String vertex;
        double weight;

        public VertexWeight(String vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public String toString() {
            return "VertexWeight{" + "vertex='" + vertex + '\'' + ", weight=" + weight + '}';
        }
    }
}
