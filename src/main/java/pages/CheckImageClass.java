package pages;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

public class CheckImageClass {

    public String getFromUrlImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        BufferedInputStream imageInFile = new BufferedInputStream(url.openConnection().getInputStream());
        byte[] imageData = new byte[2000];
        imageInFile.read(imageData);
        return encodeImageToBase64(imageData);
    }

    public String getFromExampleImage(String image) throws IOException {
        InputStream imageInFile = new FileInputStream(image);
        byte[] imageData = new byte[2000];
        imageInFile.read(imageData);
        return encodeImageToBase64(imageData);
    }

    public String encodeImageToBase64(byte[] imageByteArray) {
        return Base64.getMimeEncoder().encodeToString(imageByteArray);
    }
}