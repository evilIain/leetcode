package codinginterview.treesgraphs;

import algorithms.breadfirst.Neighbor;
import algorithms.breadfirst.Node;

import java.util.*;

public class ListOfDepths_4_3 {

    public static List<List<Integer>> printLevelOrder(Tree.Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Tree.Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Tree.Node node = queue.remove();
                temp.add(node.getValue());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
//        Tree bt = new Tree();
//
//        bt.add(6);
//        bt.add(4);
//        bt.add(8);
//        bt.add(3);
//        bt.add(5);
//        bt.add(7);
//        bt.add(9);
//
//
//        List<List<Integer>> result = printLevelOrder(bt.getRoot());
//        result.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
          int i = 0;
          int j = 0;

          boolean t = true;

          boolean r;

          r = (t & 0 < (i+=1));
          r = (t && 0 < (i+=2));
          r = (t | 0 < (j+=1));
          r = (t || 0 < (j+=2));
        System.out.println(i + " " + j);

    }

}
