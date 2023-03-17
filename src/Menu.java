import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {
    private static final double[] COIN_CONVERSION_RATES = {0.0051, 0.0047, 0.0042, 0.69, 6.59, 197.56, 210.84, 237.28, 1.46, 0.15};

	public static void main(String[] args) {
        String[] options = {
        		"Conversor de moneda", 
        		"Conversor de temperatura"
        		};
        
        ImageIcon icon = new ImageIcon(new ImageIcon("src/images/convertir.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
        String response = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

        switch (response) {
            case "Conversor de moneda":
                showCoinConversionMenu();
                break;

            case "Conversor de temperatura":
                showTemperatureConversionMenu();
                break;
        }
	}
	
	 private static void showCoinConversionMenu() {
		 String[] coinOptions = { 
					"De pesos a Dólar", 
					"De pesos a Euro",
					"De pesos a Libras",
					"De pesos a Yen",
					"De pesos a Won Coreano",
					"De Dólar a pesos",
					"De Euro a pesos",
					"De Libras a pesos",
					"De Yen a pesos",
					"De Won Coreano a pesos"
					};
	
	    ImageIcon icon = new ImageIcon(new ImageIcon("src/images/convertir.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
	    int ventanaYesNotCancel = 1;
	    do {
	    	
	    	boolean noError = false;
	    	double amount = 0;
	    	String quantity = "";
	    	
	    	while (!noError) {
	    		quantity = JOptionPane.showInputDialog(null, "Ingresa la cantidad de dinero que deseas convertir:");
	    		
	    		try {
	    			amount = Double.parseDouble(quantity);
	    			noError = true;
	    		} catch (NumberFormatException e) {
	    			JOptionPane.showMessageDialog(null,"Valor no valido");
	    			noError = false;
	    		}
	    		
	    		if(amount < 0) {
	    			JOptionPane.showMessageDialog(null,"Debe poner numeros positivos");
	    			noError = false;
	    		}
	    	}
	    	
	    	String response = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, icon, coinOptions, coinOptions[0]);
	    	
	    	double conversionRate = COIN_CONVERSION_RATES[Arrays.asList(coinOptions).indexOf(response)];	    
	    	
	    	double result = amount * conversionRate;
	    	String[] words = response.split(" ");
	    	JOptionPane.showMessageDialog(null, "Tienes " + result + " " +
	    			(words.length > 4
	    					? words[3] + " " + words[4]
	    							: words[3]
	    					));
	    	
	    	ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Selecciona una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	    	
	    	if(ventanaYesNotCancel != 0) {
	            JOptionPane.showMessageDialog(null, "Programa terminado");
	    	}else if(ventanaYesNotCancel == 0){
	    		System.out.println("Has pulsado Continuar");
	    	}
	    } while (ventanaYesNotCancel == 0);
	 }
	 
	 private static void showTemperatureConversionMenu() {
		 String[] tempOptions = { 
					"Conversor de Celsius a Fahrenheit", 
					"Conversor de Fahrenheit a Celsius"
					};
		 
		 ImageIcon icon = new ImageIcon(new ImageIcon("src/images/convertir.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
		 int ventanaYesNotCancel = 1;

		 do {
		    	
		    	boolean noError = false;
		    	double amount = 0;
		    	String quantity = "";
		    	
		    	while (!noError) {
		    		quantity = JOptionPane.showInputDialog(null, "Ingresa la temperatura que deseas convertir:");
		    		
		    		try {
		    			amount = Double.parseDouble(quantity);
		    			noError = true;
		    		} catch (NumberFormatException e) {
		    			JOptionPane.showMessageDialog(null,"Valor no valido");
		    			noError = false;
		    		}
		    		
		    	}
		    	
		    	String response = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, icon, tempOptions, tempOptions[0]);
		    	double conversionRate = Arrays.asList(tempOptions).indexOf(response);	    
		    	
		    	double result = 0;
		    	
		    	if(conversionRate == 0) {
		    		result = (amount * 1.8) + 32;
		    	} else {
		    		result = (amount - 32) / 1.8;
		    	}
		    
		    	
		    	String[] words = response.split(" ");
		    	JOptionPane.showMessageDialog(null, "El resultado de la conversion de " + words[2] + " a " + words[4] + " es: " + result);
		    	
		    	ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Selecciona una opcion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		    	
		    	if(ventanaYesNotCancel != 0) {
		            JOptionPane.showMessageDialog(null, "Programa terminado");
		    	}else if(ventanaYesNotCancel == 0){
		    		System.out.println("Has pulsado Continuar");
		    	}
		    } while (ventanaYesNotCancel == 0);

	 }
}