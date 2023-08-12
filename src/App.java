// IMPORTAR LAS CLASES NECESARIAS
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {

    /**
     * PUNTO DE ENTRADA DEL PROGRAMA
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // OPCIONES PARA EL MENU PRINCIPAL
        Object[] options = {"CONVERTIR MONEDA", "CONVERTIR TEMPERATURA", "SALIR"};
        int elige = JOptionPane.showOptionDialog(null, "¿QUÉ QUIERES HACER?", "CONVERSOR", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        // SALIR DEL PROGRAMA SI SE ELIGE SALIR
        if (elige == 2) {
            JOptionPane.showMessageDialog(null, "Programa cerrado");
            System.exit(0);
        }

        // CONVERTIR MONEDA
        if (elige == 0) {
            // OBJETO PARA FORMATEAR DECIMALES
            DecimalFormat formatearDivisa = new DecimalFormat("#.##");
            
            // BUCLE PRINCIPAL PARA LA CONVERSIÓN DE MONEDAS
            boolean continuarPrograma = true;
            while (continuarPrograma){
                // OPCIONES DE CONVERSIÓN
                String [] opciones = {"pesos a Euros", "pesos a Dolares", "pesos a Libras Esterlinas", "pesos a Yenes", "pesos a Won"};
                String cambio = (String) JOptionPane.showInputDialog(null, "Eliga una Opcion;","Conversor de moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones [0]);
                    
                // INGRESO DE LA CANTIDAD DE PESOS
                String input = JOptionPane.showInputDialog(null,"Ingrese la cantidad de pesos:");
                double pesos = 0.00;
                
                // MANEJO DE EXCEPCIONES PARA EL INGRESO INCORRECTO
                try{
                    pesos = Double.parseDouble(input);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Valor no valido");
                }

                // CONVERSIÓN DE PESOS A OTRA MONEDA
                if(cambio.equals( "pesos a Euros")){
                    double euros = pesos / 18.79;
                    JOptionPane.showMessageDialog(null, pesos + " pesos mexicanos son: " + formatearDivisa.format(euros) + " Euros.");
                } else if (cambio.equals("pesos a Dolares")){
                    double dolares = pesos / 17.15;
                    JOptionPane.showMessageDialog(null, pesos + " pesos mexicanos son: " + formatearDivisa.format(dolares) + " Dolares.");
                } else if (cambio.equals("pesos a Libras")){
                    double libras = pesos / 21.99;
                    JOptionPane.showMessageDialog(null, pesos + " pesos mexicanos son: " + formatearDivisa.format(libras) + " Lbras.");
                } else if (cambio.equals("pesos a Yen")){
                    double yen = pesos / .12;
                    JOptionPane.showMessageDialog(null, pesos + " pesos mexicanos son: " + formatearDivisa.format(yen) + " Yen.");
                } else if (cambio.equals("pesos a Won")){
                    double won = pesos / 0.013;
                    JOptionPane.showMessageDialog(null, pesos + " pesos mexicanos son: " + formatearDivisa.format(won) + " Won.");
                }

                // CONFIRMACIÓN PARA CONTINUAR O SALIR DEL PROGRAMA
                int confirma = JOptionPane.showConfirmDialog(null, "Desea continuar usando el programa?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION );
                if(confirma == JOptionPane.NO_OPTION || confirma== JOptionPane.CANCEL_OPTION){
                    continuarPrograma = false;
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                }
            }
        }
        
        // CONVERTIR TEMPERATURA
        if(elige == 1){
            // BUCLE PRINCIPAL PARA LA CONVERSIÓN DE TEMPERATURAS
            boolean seguirPrograma = true;
            while (seguirPrograma){
                // OPCIONES DE CONVERSIÓN
                String [] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
                int opcion = JOptionPane.showOptionDialog(null, "Eliga una opcion", "Conversor de temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

                // INGRESO DEL VALOR A CONVERTIR
                String valorNominal = JOptionPane.showInputDialog(null, "Ingrese valor a convertir");
                double valor = 0.00;
                try{
                    valor = Double.parseDouble(valorNominal);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Valor no Valido");
                    System.exit(0);
                }

                // REALIZAR LA CONVERSIÓN DE TEMPERATURA
                double resultado = 0;
                if (opcion == 0) {
                    resultado = (valor * 9 / 5) + 32;
                    JOptionPane.showMessageDialog(null, valor + "°C son: " + resultado + "°F");                    
                } else if (opcion == 1) {
                    resultado = (valor - 32) * 5/9;     
                    JOptionPane.showMessageDialog(null, valor + "°F son" + resultado + "°C");                
                }

                // CONFIRMACIÓN PARA CONTINUAR O SALIR DEL PROGRAMA
                int continuar = JOptionPane.showConfirmDialog(null, "Desea Seguir usando el programa?", "Mensaje de salida", JOptionPane.YES_NO_CANCEL_OPTION); 
                if (continuar == JOptionPane.NO_OPTION) {
                    seguirPrograma = false;
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                }
            }
        }
    }
}
