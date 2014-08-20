/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.*;
/**
 *
 * @author Derick
 */
public class arreglo {

    public static void main(String args[]) {

        int[] ai = {1, 2, 3, 4, 4, 5, 2, 5};	// Array que trataremos.
        int ocurrencias = 0;
        HashMap h = new HashMap();	// Almacena Num-Ocurrencias.

        for (int i = 0; i < ai.length; i++) {
            if ((Integer) h.get(String.valueOf(ai[i])) == null) {
// Si es la primera ocurrencia insertamos en la tabla con valor 1.
                h.put(String.valueOf(ai[i]), new Integer(1));
            } else {
// Si no es la primera ocurrencia incrementamos en uno la cantidad.
                ocurrencias = ((Integer) h.get(String.valueOf(ai[i]))).intValue();
                h.put(String.valueOf(ai[i]), new Integer(++ocurrencias));
            }
        }
        System.out.println("Tabla Número-Ocurrencias:" + h);

        Iterator it = h.keySet().iterator();
        HashMap h2 = new HashMap();	// Almacena Ocurrencias- Números del array con esas ocurrencias.
        TreeSet s = null;
        Integer maxOcurrencias = new Integer(0);
        Integer Ocurrencias = new Integer(0);

        while (it.hasNext()) {
            String numeroArray = (String) it.next();
            Integer ocurrenciasNumArray = (Integer) h.get(numeroArray);

            if (ocurrenciasNumArray.intValue() > maxOcurrencias.intValue()) {
                maxOcurrencias = ocurrenciasNumArray;
            }

            s = (TreeSet) h2.get(ocurrenciasNumArray);
            if (s == null) {
// Primera vez que encontramos un número con esa cantidad de ocurrencias
// Creamos el conjunto de números para esa ocurrencia añadimos el número 
// y actualizamos la tabla.
                s = new TreeSet();
                s.add(numeroArray);
                h2.put(ocurrenciasNumArray, s);
            } else {
// Actualizamos el conjunto pues hay más números con esa ocurrencia.
                s.add(numeroArray);
            }
        }
        System.out.println("Tabla Ocurrencias-Número:" + h2);
        System.out.println("Los números " + (TreeSet) h2.get(maxOcurrencias) + " tienen ocurrencias máximas:" + maxOcurrencias.intValue());
    }

}
