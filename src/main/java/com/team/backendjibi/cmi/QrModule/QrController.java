package com.team.backendjibi.cmi.QrModule;

import com.google.zxing.WriterException;
import com.team.backendjibi.dto.ClientDto;
import com.team.backendjibi.request.QrRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@CrossOrigin("*")
@RequestMapping("/jibi/")
public class QrController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/ressources/static/QrCodes/QRCode.png";

    @GetMapping("/qr")
    public ResponseEntity<String> generateQRCode(@RequestBody String Rib) {
        //String rib = request.getClient().getAccount().getRef();
        String rib= Rib;
        byte[] image = new byte[0];
        try {
            // Generate QR Code image
            image = QRCodeGenerator.getQRCodeImage(rib, 250, 250);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generating QR Code");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        // Create JSON response
        String jsonResponse = String.format("{\"Rib\":\"%s\", \"qrcode\":\"%s\"}", rib, qrcode);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return ResponseEntity.ok().headers(headers).body(jsonResponse);
    }


    @PostMapping("qr/img")
    public ResponseEntity<byte[]> generateQRCodeImg(@RequestBody String Rib) {
        String rib= Rib;
        byte[] image;
        try {
            // Generate QR Code image
            image = QRCodeGenerator.getQRCodeImage(rib, 250, 250);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(image.length);

        return ResponseEntity.ok().headers(headers).body(image);
    }


    @PostMapping("/qr/decode")
    public ResponseEntity<String> decodeQRCode(@RequestParam("file") MultipartFile file) {
        try {
            String decodedText = QRCodeGenerator.decodeQRCode(file);
            return ResponseEntity.ok(decodedText);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not decode QR Code");
        }
    }
}
