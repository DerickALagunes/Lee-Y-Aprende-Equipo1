/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leeyaprende;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

/**
 *
 * @author rosa
 */
public class LeeYAprende {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
//        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceDesertSandTheme");
        SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark("Imagenes/fondo.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.7));
        
        Inicio ini = new Inicio();
        ini.setVisible(true);
    }
    
}
