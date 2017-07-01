package GUI;

/**
 * Created by Sadri on 01.07.2017.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class IconImageUtilities
{
    public static void setIconImage(Window window)
    {
        try
        {
            InputStream imageInputStream = window.getClass().getResourceAsStream("graphics/GUI/mastermind-icon.gif");
            BufferedImage bufferedImage = ImageIO.read(imageInputStream);
            window.setIconImage(bufferedImage);
           // frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icon.png"));
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
