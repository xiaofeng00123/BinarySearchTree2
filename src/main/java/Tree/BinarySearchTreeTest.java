package Tree;

import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void findTest(){
        Node T = null;
        T=BinarySearchTree.insert(T,7);
        T=BinarySearchTree.insert(T,6);
        T=BinarySearchTree.insert(T,10);
        T=BinarySearchTree.insert(T,5);
        T=BinarySearchTree.insert(T,8);
//        T=BinarySearchTree.delete(T,6);
//        System.out.println(T.getElement());
//        System.out.println(T.getLeft().getElement());
//        System.out.println(T.getLeft().getLeft().getElement());
//        System.out.println(T.getLeft().getRight().getElement());
//        System.out.println(BinarySearchTree.find(T,6).getLeft().getElement());
        BinarySearchTree.inOrder(T);
    }

}
