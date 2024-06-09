package com.team.backendjibi.cmi.QrModule;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.team.backendjibi.shared.AESUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    //// THE Static secret key
    //private static final SecretKey STATIC_KEY = AESUtil.getStaticKey();
//////////////////////////////////////////////////////////////////////////////////////////////
//    public static void generateQRCodeImage(String text, int width, int height, String filePath)
//            throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//    }


    public static byte[] getQRCodeImage(String text, int width, int height) throws Exception {
        //String encryptedText = AESUtil.encrypt(text, STATIC_KEY);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //BitMatrix bitMatrix = qrCodeWriter.encode(encryptedText, BarcodeFormat.QR_CODE, width, height);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        //////more as a bitmap that can then be converted to a png
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000000 , 0xFFFFFFFF ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        //System.out.println("encryptedText :" + encryptedText);

        return pngData;
    }

    public static String decodeQRCode(MultipartFile qrCodeImage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeImage.getInputStream());
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Result result = new MultiFormatReader().decode(bitmap);
            System.out.println("encryptedText 2 :" + result.getText());
            //String Decryptedtext = AESUtil.decrypt(result.getText(), STATIC_KEY);
            //System.out.println("Decryptedtext :" + Decryptedtext);
            return result.getText();
            //return Decryptedtext;
        } catch (Exception e) {
            throw new IOException("Error decoding QR Code", e);
        }
    }


}
