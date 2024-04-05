


public class Tarea3Progra {

   
    public static void main(String[] args) {
       
       
        int grado = 3;
        
        Arbol arbolB = new Arbol(grado);
        
        
        int[] valoresUno = {5, 60, 50, 15, 35};
        
        System.out.println("INSERTANDO Valores ");
        for(int i=0; i<valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }
        
        
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        
        System.out.println("Insertando... valor ");
        arbolB.insertar(70);
        
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");
        
        
        System.out.println("Insertando... valor ");
        arbolB.insertar(90);
        System.out.println("Insertando... valor ");
        arbolB.insertar(80);
        System.out.println("Insertando... valor ");
        arbolB.insertar(200);
        
        System.out.println("ESTADO ARBOL B");
        arbolB.showBTree();
        System.out.println("");

        
        System.out.println("\nBuscando el nodo con el valor 90 en el arbol B:");
        arbolB.buscarNodoPorClave(90);
        
        
        System.out.println("\nEl valor maximo del arbol B es : " + arbolB.buscarClaveMayor());
        
        System.out.print("El nodo minimo de la raiz del arbol B es :");
        arbolB.mostrarClavesNodoMinimo();
        
        
    }
    
}
