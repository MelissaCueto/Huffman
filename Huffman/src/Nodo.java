public class Nodo
{
    public int freq;
    public char c;
    public Nodo left;
    public Nodo right;
    
    public Nodo(int freqc, char c, Nodo left, Nodo right)
    {
        this.freq = freqc;
        this.c = c;
        this.left = left;
        this.right = right;
    }
    
    public Nodo()
    {   
    }
    
    public Nodo addNode(Nodo node1, Nodo node2)
    {
        if(node1.freq < node2.freq)
        {
            left = node1;
            right = node2;
        }
        else
        {
            right = node1;
            left = node2;
        }
        freq = node1.freq + node2.freq;
        
        return this;
    }
    
}
