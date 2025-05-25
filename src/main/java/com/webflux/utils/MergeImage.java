package com.webflux.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class MergeImage {

    public static void main(String[] args) throws IOException {
        String matTruoc = "src/main/resources/images/mattruoc.png";
        String matSau = "src/main/resources/images/matsau.png";
        String base64 = handleImages(matTruoc, matSau);
        System.out.println(base64);
    }

    private static String handleImages(String firstImage, String secondImage) throws IOException {
        var front = ImageIO.read(new ByteArrayInputStream(Files.readAllBytes(Paths.get(firstImage))));
        var back = ImageIO.read(new ByteArrayInputStream(Files.readAllBytes(Paths.get(secondImage))));

        int width = Math.max(front.getWidth(), back.getWidth());
        BufferedImage img = new BufferedImage(width, front.getHeight() + back.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        Graphics g = img.getGraphics();
        g.drawImage(front, 0, 0, null);
        g.drawImage(back, 0, front.getHeight(), null);
        g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        var imageBytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
