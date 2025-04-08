package humanChatbot.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import humanChatbot.util.MultipartInputStreamFileResource;



@Service
public class ChatService {

    @Value("${fastapi.url:http://localhost:8000}")
    private String fastApiUrl;

    private final RestTemplate restTemplate;

    public ChatService() {
        this.restTemplate = new RestTemplate();
    }

    public String getSegmentationImage(MultipartFile image) throws IOException {
        String url = fastApiUrl + "/segment/image";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 이미지 파일을 multipart/form-data 형식으로 감싸기
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", 
     new MultipartInputStreamFileResource(image.getInputStream(), 
    		 image.getOriginalFilename()));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // FastAPI로 요청 보내기
        ResponseEntity<Map> response = restTemplate.postForEntity(url, requestEntity, Map.class);

        // 결과 받아서 base64 이미지 추출
        if (response.getBody() != null && response.getBody().containsKey("segmented_image")) {
            return (String) response.getBody().get("segmented_image");
        } else {
            throw new RuntimeException("세분화 실패 또는 잘못된 응답입니다.");
        }
    }
}





