package Homework4;

public class RedBlackTree {
     Treenode root;

    public boolean add(int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.colour = Colour.BLACK;
            return result;
        } else{
            root = new Treenode(value);
            root.colour = Colour.BLACK;
            return true;
        }
    }
    private boolean addNode(Treenode node, int value){
        if (node.value==value) return false;
        if (node.value > value){
            if(node.left != null){
                boolean result = addNode(node.left, value);
                node.left = rebalance(node.left);
                return result;
            } else{
                node.left = new Treenode(value);
                node.left.colour = Colour.RED;
                return true;
            }
        } else{
            if (node.right != null){
                boolean result = addNode(node.right, value);
                node.right = rebalance(node.right);
                return result;
            } else{
                node.right = new Treenode(value);
                node.right.colour = Colour.RED;
                return true;
            }
        }
    }
    private Treenode rebalance(Treenode node){
        Treenode result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            if (result.right != null && result.right.colour == Colour.RED &&
                    (result.left == null || result.left.colour == Colour.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.colour == Colour.RED &&
                    (result.left.left != null && result.left.left.colour == Colour.RED)){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.colour == Colour.RED &&
                    (result.right != null && result.right.colour == Colour.RED)){
                needRebalance = true;
                colourSwap(result);
            }
        } while (needRebalance);
        return result;
    }
    private Treenode rightSwap(Treenode node){
        Treenode rightChild = node.right;
        Treenode betweenChild  = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.colour = node.colour;
        node.colour = Colour.RED;
        return rightChild;
    }
    private Treenode leftSwap(Treenode node){
        Treenode leftChild = node.left;
        Treenode betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.colour = node.colour;
        node.colour = Colour.RED;
        return leftChild;
    }
    private void colourSwap(Treenode node){
        node.left.colour = Colour.BLACK;
        node.right.colour = Colour.BLACK;
        node.colour = Colour.RED;
    }

    static class Treenode {
        int value;
         Colour colour;
         Treenode  left;
         Treenode  right;

        Treenode(){
        }
        Treenode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Treenode{" +
                    "value=" + value +
                    ", colour=" + colour +
                    '}';
        }
    }
    private enum Colour{
        RED, BLACK
    }
    static boolean containsOf(Treenode root, int value){
        if (root == null) return false;
        if (root.value == value) return true;
        return containsOf(root.left, value) || containsOf(root.right, value);
    }
}
