package view.materialdesign;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class MaterialFonts {
	public static final Font DEFAULT_FONT () {
		try {
			return Font.createFont(Font.PLAIN, new File("res/fonts/Roboto/Roboto-Light.ttf")).deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			return Font.decode("Calibri").deriveFont(18f);
		}
	}
	
	public static final Font DATA_FONT () {
		return Font.decode("Corbel").deriveFont(18f);
	}
}
