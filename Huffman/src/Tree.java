
public class Tree extends Nodo {

    private Nodo root;

    public Tree() {
        root = null;
    }

    public Tree(Nodo node1, Nodo node2) {
        root = super.addNode(node1, node2);
    }

    public void insertNode(int freq, char c) {
        root.freq= freq;
        root.c = c;
        root.left = null;
        root.right = null;
    }

    public void insertNode(int freq, char c, Nodo left, Nodo right) {
        root.freq = freq;
        root.c = c;
        this.root.left = left;
        this.root.right = right;
    }

    public void insertNode(Nodo node) {
        this.root.freq = node.freq;
        this.root.c = node.c;
        this.root.left = node.left;
        this.root.right = node.right;
    }

    public void insertNode(Nodo node1, Nodo node2) {
        root = super.addNode(node1, node2);
    }
}
