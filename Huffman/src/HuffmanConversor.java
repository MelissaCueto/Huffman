
public class HuffmanConversor {

    private Nodo rootNode;
    private char c;
    private char charArray[];
    private int i = 0;
    public String bitFn = "";

    public HuffmanConversor(Nodo myNode, char[] charArray) {
        String temp;
        int i;
        rootNode = myNode;
        this.charArray = charArray;
        for (i = 0; i < charArray.length; i++) {
            temp = Buscar(rootNode, "", charArray[i]);
            bitFn += temp + " ";
            System.out.println("Valor: " + charArray[i] + " " + temp);
        }
    }

    public String Buscar(Nodo rootNode, String value, char myChar) {
        String valueL = "";
        if (rootNode != null) {
            if (rootNode.left != null) {
                valueL = Buscar(rootNode.left, value + "0", myChar);
            }
            if (rootNode.c == myChar) {
                return value;
            } else if (valueL == "") {
                return Buscar(rootNode.right, value + "1", myChar);
            } else {
                return valueL;
            }
        } else {
            return "";
        }
    }

}
