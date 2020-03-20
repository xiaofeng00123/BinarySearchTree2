package Tree;

class Node{
    int element;
    Node right;
    Node left;

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node(){}

    public Node(int element){
        this.element=element;
    }
}
public class BinarySearchTree {

    //查找节点
    public static Node find(Node T, int element){
        Node n = new Node();
        if(T==null||T.getElement()==element)
            return T;
        if(element>T.getElement()){
            n=find(T.getRight(),element);
        }else{
            n=find(T.getLeft(),element);
        }
        return n;
    }

    //插入节点
    public static Node insert(Node T, int element){
        if(T==null){
            T=new Node();
            T.setElement(element);
            return T;
        }
        if(element<T.getElement()){
            T.setLeft(insert(T.getLeft(),element));
        }else{
            T.setRight(insert(T.getRight(),element));
        }
        return T;
    }

    //删除节点
    public static Node delete(Node T, int element){
        if(T==null)
            return null;
        if(element<T.getElement()){
            T.setLeft(delete(T.getLeft(),element));
        }else if(element>T.getElement()){
            T.setRight(delete(T.getRight(),element));
        }else{    //找到了待删除节点
            //待删除节点有两个子节点
            if(T.getRight()!=null&&T.getLeft()!=null){
                Node minNode = findMin(T.getRight());
                minNode.setRight(delete(T.getRight(),minNode.getElement()));
                minNode.setLeft(T.getLeft());
                T.setLeft(null);
                T.setRight(null);
                return minNode;
            }else{   //待删除节点有一个子节点或没有子节点
                if(T.getLeft()==null){
                    return T.getRight();
                }
                if(T.getRight()==null){
                    return T.getLeft();
                }
            }
        }
        return T;
    }

    public static Node findMin(Node T){
        if(T.getLeft()==null||T==null){
            return T;
        }
        Node min = findMin(T.getLeft());
        return min;
    }

    //前序遍历
    public static void preOrder(Node T){
        if(T==null)
            return;
        System.out.println(T.getElement());
        preOrder(T.getLeft());
        preOrder(T.getRight());
    }

    //中序遍历(可以从大到小打印树中的数据)
    public static void inOrder(Node T){
        if(T==null)
            return;
        inOrder(T.getLeft());
        System.out.println(T.getElement());
        inOrder(T.getRight());
    }

    //后序遍历
    public static void afterOrder(Node T){
        if(T==null)
            return;
        afterOrder(T.getLeft());
        afterOrder(T.getRight());
        System.out.println(T.getElement());
    }

}
