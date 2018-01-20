
import java.util.*;

public class Huffman {

//Clases y variables
    private static char charArray[]; //Convertir a caracter
    private static int table[] = new int[0x7f]; //Frecuencia
    private static Nodo myNode[];
    private static int tamTb = 0;//Tamaño real del vector
    private static Tree myTree;
    private static int tamNd = 0;
    public static HuffmanTransversor hC;

    public Huffman(String value) {
        frequencyTable(value);
        nodeArrange();
        Nodo x = createTree();
        hC = new HuffmanTransversor(x, charArray);
    }

    public static void frequencyTable(String value) {
        int i;
        charArray = value.toCharArray();
        for (i = 0; i < charArray.length; i++) {
            table[getAscii(charArray[i])] += 1;
        }
    }

    public static int getAscii(char substringValue) {
        return substringValue & 0x7f;
    }

    public static void nodeArrange() {
        int aux = 0;
        int j = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > 0) {
                aux++;
            }
        }

        tamTb = aux;
        aux = 0;
        myNode = new Nodo[tamTb];

        for (int i = 0; i < 127; i++) {
            if (table[i] != 0) {
                myNode[aux] = new Nodo(table[i], (char) i, null, null) {
                };
                aux++;
            }
        }
        tamNd = myNode.length;
        sort();

    }

    public static Nodo createTree() {
        for (int i = 1; i < tamNd; i++) {
            try {
                if (myNode[1].freq >= myNode[0].freq) {
                    myTree = new Tree(myNode[0], myNode[i]);
                    myNode[0] = myTree;
                    moveItems(i, tamNd);
                    tamNd -= 1;
                    i -= 1;
                    sort();
                } else if (i + 1 < tamNd) {
                    myTree = new Tree(myNode[i], myNode[i + 1]);
                    myNode[1] = myTree;
                    moveItems(i + 1, tamNd);
                    sort();
                    tamNd -= 1;
                    i -= 1;
                } else {
                    myNode[1] = myNode[i];
                    myNode[0] = new Tree(myNode[0], myNode[1]);
                }
            } catch (Exception e) {
                //I dare this program to crash...hahaha
            }
        }
        return myNode[0];
    }

    private static void moveItems(int index, int length) {
        try {
            for (int i = index; i < length; i++) {
                myNode[i] = myNode[i + 1];
            }

        } catch (Exception e) {

        }
    }

    private static void sort() {
        Nodo temp;
        for (int i = tamNd - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (myNode[j].freq > myNode[j + 1].freq) {
                    temp = myNode[j + 1];
                    myNode[j + 1] = myNode[j];
                    myNode[j] = temp;
                }

                if (myNode[j].freq == myNode[j + 1].freq && myNode[j].left != null) {
                    temp = myNode[j + 1];
                    myNode[j + 1] = myNode[j];
                    myNode[j] = temp;
                }
            }
        }
    }
}
