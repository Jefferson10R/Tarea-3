


public class Arbol {
    
    Nodo raiz;
    int grado;

    
    public Arbol(int grado) {
        this.grado = grado;
        raiz = new Nodo(grado);
    }

    public int buscarClaveMayor() {
        int claveMaxima = getClaveMayor(this.raiz);

        return claveMaxima;
    }

    private int getClaveMayor(Nodo current) {
        if (current == null) {
            return 0;
        }

        
        while (!current.leaf) {
            
            current = current.child[current.k];
        }

        return claveMayorPorNodo(current);
    }

    private int claveMayorPorNodo(Nodo current) {
        
        return current.key[current.k - 1];
    }

    public void mostrarClavesNodoMinimo() {
        Nodo temp = buscarNodoMinimo(raiz);

        if (temp == null) {
            System.out.println("Sin minimo");
        } else {
            temp.Mostrar();
        }
    }

    public Nodo buscarNodoMinimo(Nodo nodoActual) {
        if (raiz == null) {
            return null;
        }

        Nodo aux = raiz;

        
        while (!aux.leaf) {
            
            aux = aux.child[0];
        }

        
        return aux;
    }

    
    public void buscarNodoPorClave(int num) {
        Nodo temp = search(raiz, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    
    private Nodo search(Nodo actual, int key) {
        int i = 0;

        
        while (i < actual.k && key > actual.key[i]) {
            i++;
        }

       
        if (i < actual.k && key == actual.key[i]) {
            return actual;
        }

        
        if (actual.leaf) {
            return null;
        } else {
            
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        Nodo r = raiz;

        
        if (r.k == ((2 * grado) - 1)) {
            Nodo s = new Nodo(grado);
            raiz = s;
            s.leaf = false;
            s.k = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }
    
   
    private void split(Nodo x, int i, Nodo y) {
        
        Nodo z = new Nodo(grado);
        z.leaf = y.leaf;
        z.k = (grado - 1);

        
        for (int j = 0; j < (grado - 1); j++) {
            z.key[j] = y.key[(j + grado)];
        }

        
        if (!y.leaf) {
            for (int k = 0; k < grado; k++) {
                z.child[k] = y.child[(k + grado)];
            }
        }

                                                    
        y.k = (grado - 1);                                                          
                                                                                
        
        for (int j = x.k; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
                                             
        x.child[(i + 1)] = z;                                                   
                                                                              
        
        for (int j = x.k; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        
        x.key[i] = y.key[(grado - 1)];                                              
        x.k++;                                                                 
    }

    private void nonFullInsert(Nodo x, int key) {
        
        if (x.leaf) {
            int i = x.k; 
            
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];
                i--;
            }

            x.key[i] = key;
            x.k++; 
        } else {
            int j = 0;
            
            while (j < x.k && key > x.key[j]) {
                j++;
            }

            
            if (x.child[j].k == (2 * grado - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(raiz);
    }

    
    private void print(Nodo n) {
        n.Mostrar();

        
        if (!n.leaf) {
            
            for (int j = 0; j <= n.k; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
}
