package image.encryption;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PixelEncryptor {
    public static void main(String[] args) {
        try {
            // Load original image from project root
            File inputFile = new File("C:/Users/subin/eclipse-workspace/ImageEncryptor/treee.jpg");

            if (!inputFile.exists()) {
                System.out.println("❌ Image file not found!");
                return;
            }

            BufferedImage image = ImageIO.read(inputFile);

            // Basic pixel encryption - invert colors
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int rgba = image.getRGB(x, y);
                    int inverted = 0xFFFFFF - rgba;
                    image.setRGB(x, y, inverted);
                }
            }

            // Save the encrypted image
            File outputFile = new File("encrypted.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("✅ Encrypted image saved as encrypted.png");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
