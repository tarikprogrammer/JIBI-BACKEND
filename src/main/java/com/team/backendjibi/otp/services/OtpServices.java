package com.team.backendjibi.otp.services;

import com.team.backendjibi.backOffice.entities.ClientEntity;
import com.team.backendjibi.otp.dto.EnumStatus;
import com.team.backendjibi.otp.dto.OtpDtoRequest;
import com.team.backendjibi.otp.dto.OtpDtoResponse;
import com.team.backendjibi.otp.entity.OtpEntity;
import com.team.backendjibi.otp.repoOtp.Repo;
import com.team.backendjibi.repositoryJibi.repoEntities.RepoClient;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Random;

@Service

public class OtpServices {
    @Autowired
    private Repo repOtp;
    @Autowired
    private RepoClient repoClient;
    @Value("${vonage.api.key}")
    private String apiKey;

    @Value("${vonage.api.secret}")
    private String apiSecret;
    @Autowired
    private Repo repo;

    public OtpDtoResponse sendSms(OtpDtoRequest otpDtoRequest) throws Exception {
        OtpEntity otpEntity = new OtpEntity();
        StringBuilder sendTo = new StringBuilder("+212");
        for (int i=1;i<otpDtoRequest.getPhoneNumber().length();i++){
            sendTo.append(otpDtoRequest.getPhoneNumber().charAt(i));
        }
        String otpGenerator=generateOtp();
        OtpDtoResponse otpDtoResponse = new OtpDtoResponse();
        String message="Votre code de vérification OTP est "+otpGenerator  +".Ne partagez pas ce code avec d'autres personnes.\nApplicatio JIBI\n";
        VonageClient client = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();
        TextMessage textMessage = new TextMessage("JIBI",sendTo.toString(), message);
        SmsSubmissionResponse response = client.getSmsClient().submitMessage(textMessage);
        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            otpDtoResponse.setEnumStatus(EnumStatus.DELIVERED);
            otpDtoResponse.setOtp(otpGenerator);
            Long findclient =repoClient.findClient(otpDtoRequest.getPhoneNumber()).getId();
            if(findclient!=null){
                ClientEntity clientEntity = repoClient.findById(findclient).get();
                if(clientEntity.getOtpClient().getId()==null){
                    BeanUtils.copyProperties(otpDtoResponse,otpEntity);
                    otpEntity.setClient(repoClient.findById(findclient).get());
                    OtpEntity otpSave =repOtp.save(otpEntity);
                }else{
                   OtpEntity findOtp=repOtp.findById(clientEntity.getOtpClient().getId()).get();
                   findOtp.setOtp(otpDtoResponse.getOtp());
                    OtpEntity otpSave =repOtp.save(findOtp);
                }

            }else{
                throw  new Exception("id client not found ...");
            }


        } else {
            otpDtoResponse.setEnumStatus(EnumStatus.FAILED);
        }
        return otpDtoResponse;
    }
    public  String generateOtp(){
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
    public boolean verifyOtp(OtpDtoRequest otpDtoRequest){
        OtpEntity otpEntity =repOtp.findByOtp(otpDtoRequest.getOtp());
        boolean status=false;
        if(otpEntity!=null){
            status=true;
        }
        return status;

    }
}