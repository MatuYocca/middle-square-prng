package prng;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class CuadradosMedios {

    /***
     * Devuelve un arreglo con la secuencia de numeros pseudoaleatorios generados con los parametros dados
     * @param x0 El numero inicial
     * @param n El parametro n
     * @param iter La cantidad de iteraciones
     * @return La cadena correspondiente a la secuencia
     */
    public static ArrayList<String> generateSequence(BigInteger x0, int n, int iter) {

        ArrayList<String> out = new ArrayList<>();
        out.add(leadingZeros(x0, n << 1));

        for (int i = 0; i++ != iter; ) {
            x0 = nextIteration(x0, n);
            out.add(leadingZeros(x0, n << 1));
        }

        return out;
    }

    /***
     * Genera una cadena con la secuencia de numeros pseudoaleatorios correspondientes a los parametros dados
     * @param x0 El numero inicial
     * @param n El parametro n
     * @param iter La cantidad de iteraciones
     * @returns La cadena generada
     */
//    public static String generateSequenceString(int x0, int n, int iter) {
//
//        StringBuilder str = new StringBuilder();
//
//        for (Integer x : generateSequence(x0, n, iter)) {
//            str.append(leadingZeros(x, n << 1));
//        }
//
//        return str.toString();
//    }

    /***
     * Agrega ceros a la izquierda del numero para que tenga una cantidad de digitos especifica.
     * @param x El numero a ser truncado
     * @param d La cantidad de digitos requerida
     * @return La cadena con el numero x con ceros iniciales en caso de ser necesario
     */
    public static String leadingZeros(BigInteger x, int d) {
        return (new String(new char[d]).replace("\0", "0") + x).substring(String.valueOf(x).length());
    }


    /***
     * Dado un numero x(i) de la secuencia y un parametro n, devuelve el numero x(i+1) de la misma secuencia.
     * @param xi El parametro x(i)
     * @param n El parametro n
     * @return El parametro x(i+1)
     */
    public static BigInteger nextIteration(BigInteger xi, int n) {

        xi = xi.multiply(xi);
        xi = xi.divide(BigDecimal.valueOf(Math.pow(10, n)).toBigInteger());
        //xi /= Math.pow(10, n);
        xi = xi.mod(BigDecimal.valueOf(Math.pow(10, n << 1)).toBigInteger());
        //xi %= Math.pow(10, n << 1);

        return xi;
    }


//    public static void main(String[] args) {
//
//        int i = 0;
//        for (String x : generateSequence(4825, 2, 150)) {
//            System.out.println("x" + i++ + ": " + x);
//        }
//
//    }

}
