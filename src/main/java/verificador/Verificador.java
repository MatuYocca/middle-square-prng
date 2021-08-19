/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author matu
 */
public class Verificador extends InputVerifier {

    public static boolean isValidInteger(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean verify(JComponent jc) {
        if (jc instanceof JTextField) {
            String texto = ((JTextField) jc).getText();
            try {
                // Si se puede convertir en entero, está bien
                Integer.parseInt(texto);
                return true;
            } catch (Exception e) {
                // Si no se ha podido convertir a entero, mostramos
                // una ventana de error y devolvemos false
                JOptionPane.showMessageDialog(jc, "No es un número");
                return false;
            }
        }
        return true;
    }

}
