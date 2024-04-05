


public class Nodo {
    
    
    int k; 
    boolean leaf; 
    int key[];  
    Nodo child[]; 

    
    public Nodo(int grado) {
        k = 0;
        leaf = true;
        key = new int[((2 * grado) - 1)];
        child = new Nodo[(2 * grado)];
    }

    public void Mostrar() {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            if (i < k - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    public int encontar(int k) {
        for (int i = 0; i < k; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
    
}
