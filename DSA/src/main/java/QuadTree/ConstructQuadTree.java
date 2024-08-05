package QuadTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        int[][] grid2 = {{1, 0}, {1, 1}};
        //   Node node = construct(grid, 0, grid.length - 1, 0, grid.length - 1);
        //  Node node = construct(grid2, 0, grid2.length - 1, 0, grid2.length - 1);
        Map<String, GridNode> mp = new HashMap<>();
        prepareGridValueMap(grid, 0, grid.length - 1, 0, grid.length - 1, mp);
        constructQuadTree(grid, 0, grid.length - 1, 0, grid.length - 1, mp);
        System.out.println(mp);

    }


    public static Node constructQuadTree(int[][] grid, int stRow, int endRow, int stCol, int endCol, Map<String, GridNode> gridValueMap) {

        if (stRow == endRow && stCol == endCol) {
            int val = grid[stRow][stCol];
            return new Node(val == 1, true);
        }

        String key = stRow + "," + endRow + "," + stCol + "," + endCol;

        boolean isLeaf = gridValueMap.get(key).isLeaf;
        if (isLeaf) {
            int val = grid[stRow][stCol];
            return new Node(val == 1, true);
        }

        int midRow = (stRow + endRow) / 2;
        int midCol = (stCol + endCol) / 2;

        Node topLeft = constructQuadTree(grid, stRow, midRow, stCol, midCol, gridValueMap);
        Node topRight = constructQuadTree(grid, stRow, midRow, midCol + 1, endCol, gridValueMap);
        Node bottomLeft = constructQuadTree(grid, midRow + 1, endRow, stCol, midCol, gridValueMap);
        Node bottomRight = constructQuadTree(grid, midRow + 1, endRow, midCol + 1, endCol, gridValueMap);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static GridNode prepareGridValueMap(int[][] grid, int stRow, int endRow, int stCol, int endCol,
                                               Map<String, GridNode> gridValueMap) {
        String key = stRow + "," + endRow + "," + stCol + "," + endCol;

        //for 2*2 grid no need to store in map, will just return grid value;
        if (endRow - stRow == 1 && endCol - stCol == 1) {
            int topLeft = grid[stRow][stCol];
            int topRight = grid[stRow][endCol];
            int bottomLeft = grid[endRow][stCol];
            int bottomRight = grid[endRow][endCol];
            GridNode node;
            if ((topLeft == topRight && topRight == bottomRight && bottomRight == bottomLeft)) {
                node = new GridNode(topLeft, true);
            } else {
                node = new GridNode(0, false); //Any random for non leaf node
            }
            gridValueMap.put(key, node);
            return node;
        }

        int midRow = (stRow + endRow) / 2;
        int midCol = (stCol + endCol) / 2;

        GridNode topLeft = prepareGridValueMap(grid, stRow, midRow, stCol, midCol, gridValueMap);
        GridNode topRight = prepareGridValueMap(grid, stRow, midRow, midCol + 1, endCol, gridValueMap);
        GridNode bottomLeft = prepareGridValueMap(grid, midRow + 1, endRow, stCol, midCol, gridValueMap);
        GridNode bottomRight = prepareGridValueMap(grid, midRow + 1, endRow, midCol + 1, endCol, gridValueMap);
        GridNode node;
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            node = new GridNode(topLeft.val, true);
        } else {
            node = new GridNode(0, false);
        }
        gridValueMap.put(key, node);
        return node;
    }

    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }


        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", isLeaf=" + isLeaf +
                    ", topLeft=" + topLeft +
                    ", topRight=" + topRight +
                    ", bottomLeft=" + bottomLeft +
                    ", bottomRight=" + bottomRight +
                    '}';
        }
    }

    private static class GridNode {
        public int val;
        public boolean isLeaf;

        public GridNode(int val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;

        }
    }

}
