package com.youmu.maven.Algorithm;

import com.youmu.maven.Algorithm.struct.Tree;
import org.junit.Test;

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
}
