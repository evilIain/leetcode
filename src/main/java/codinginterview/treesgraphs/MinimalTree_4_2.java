package codinginterview.treesgraphs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MinimalTree_4_2 {

    public static Tree convertArrayToBinaryTree(List<Integer> list) {
        Tree tree = new Tree();
        tree.setRoot(convert(list, 0, list.size() - 1));
        return tree;
    }

    public static Tree.Node convert(List<Integer> list, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end)/2;
        int median = list.get(mid);
        Tree.Node node = new Tree.Node(median);
        node.setLeft(convert(list, start, mid - 1));
        node.setRight(convert(list, mid + 1, end));
        return node;
    }

    public static void traversePreOrder(Tree.Node node) {
        if (node != null) {
            System.out.println(node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public static void sort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        Tree tree = convertArrayToBinaryTree(list);
        traversePreOrder(tree.getRoot());
        int[] arr = {5,4,3,2,7};
        sort(arr);

    }
}
