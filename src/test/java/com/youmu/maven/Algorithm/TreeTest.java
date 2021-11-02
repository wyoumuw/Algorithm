package com.youmu.maven.Algorithm;

import com.youmu.maven.Algorithm.struct.Tree;
import com.youmu.maven.Algorithm.utils.TreeUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyoumuw on 2019/3/30.
 */
public class TreeTest {

    @Test
    public void preTraversalTest() {
        Tree tree = makeTree();
        System.out.println(tree.traversal(Tree.TraversalType.PRE));
    }

    @Test
    public void midTraversalTest() {
        Tree tree = makeTree();
        System.out.println(tree.traversal(Tree.TraversalType.MID));
    }

    @Test
    public void tailTraversalTest() {
        Tree tree = makeTree();
        System.out.println(tree.traversal(Tree.TraversalType.TAIL));
    }

    @Test
    public void levelTraversalTest() {
        Tree tree = makeTree();
        System.out.println(tree.traversal(Tree.TraversalType.LEVEL));
    }

    @Test
    public void level2TraversalTest() {
        Tree tree = makeTree2();
        List list = new ArrayList();
        tree.minMemTraversal(list);
        System.out.println(list);
    }

    @Test
    public void printTest() throws Exception {
        TreeUtils.printTree(makeTree());
    }
    @Test
    public void print2Test() throws Exception {
        TreeUtils.printTree(makeTree2());
    }
    @Test
    public void print3Test() throws Exception {
        TreeUtils.printTree(makeTree3());
    }


    //            A
    //      B|         |C
    //   D|  |E     F|   |G
    //H| |I    |J    |K
    public static Tree<Character> makeTree() {
        Tree tree = new Tree();
        tree.root = new Tree.TreeNode('A');
        tree.root.left = new Tree.TreeNode('B');
        tree.root.right = new Tree.TreeNode('C');
        tree.root.left.left = new Tree.TreeNode('D');
        tree.root.left.right = new Tree.TreeNode('E');
        tree.root.right.left = new Tree.TreeNode('F');
        tree.root.right.right = new Tree.TreeNode('G');
        tree.root.left.left.left = new Tree.TreeNode('H');
        tree.root.left.left.right = new Tree.TreeNode('I');
        tree.root.left.right.right = new Tree.TreeNode('J');
        tree.root.right.left.right = new Tree.TreeNode('K');
        return tree;
    }

    //            5
    //      2|         |6
    //   1|   |4         |7
    //      3|
    public static Tree<Character> makeTree2() {
        Tree tree = new Tree();
        tree.root = new Tree.TreeNode('5');
        tree.root.left = new Tree.TreeNode('2');
        tree.root.right = new Tree.TreeNode('6');
        tree.root.left.left = new Tree.TreeNode('1');
        tree.root.left.right = new Tree.TreeNode('4');
        tree.root.left.right.left = new Tree.TreeNode('3');
        tree.root.right.right = new Tree.TreeNode('7');
        return tree;
    }

    //            5111
    //      2|         |6
    //   11|   |4         |72432
    //   33333|
    public static Tree<String> makeTree3() {
        Tree<String> tree = new Tree<>();
        tree.root = new Tree.TreeNode<>("5111");
        tree.root.left = new Tree.TreeNode<>("2");
        tree.root.right = new Tree.TreeNode<>("6");
        tree.root.left.left = new Tree.TreeNode<>("11");
        tree.root.left.right = new Tree.TreeNode<>("4");
        tree.root.left.right.left = new Tree.TreeNode<>("33333");
        tree.root.right.right = new Tree.TreeNode<>("72432");
        return tree;
    }
}
