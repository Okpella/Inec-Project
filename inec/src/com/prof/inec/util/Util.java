package com.prof.inec.util;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

public class Util {
    public static String getFileAsBase64(File file) throws Exception{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String passportString = null;
        try {
            BufferedImage image = Thumbnails.of(ImageIO.read(file))
                    .size(100,100).asBufferedImage();
            ImageIO.write(image, "jpeg", bos);
            byte [] imageBytes = bos.toByteArray();
            passportString = Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e){e.printStackTrace();}

        finally {
            bos.close();
        }

        return passportString;
    }
}
