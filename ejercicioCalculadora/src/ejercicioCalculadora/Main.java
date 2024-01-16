package ejercicioCalculadora;

import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.mint.MintLookAndFeel;

public class Main {

	public static void main(String[] args) {
		
		try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            Properties props = new Properties();
            props.put("textAntiAliasingMode", "grey");
            MintLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calculadora frame = new Calculadora();
        frame.setTitle("Hoy quiero ser: Calculadora");
        frame.setVisible(true);
	}

}
