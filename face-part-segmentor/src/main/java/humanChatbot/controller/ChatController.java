package humanChatbot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import humanChatbot.service.ChatService;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @PostMapping("/segment")
    public String segmentImage(@RequestParam("image") MultipartFile image, Model model) {
        try {
            // 서비스에 위임
            String base64Img = chatService.getSegmentationImage(image);
            model.addAttribute("resultImage", base64Img);
           
        } catch (IOException e) {
            model.addAttribute("message", "이미지 분석 중 오류가 발생했습니다.");
            e.printStackTrace(); // 콘솔에 디버깅용 출력
        } catch (Exception e) {
            model.addAttribute("message", "FastAPI 서버와의 통신에 실패했습니다.");
            e.printStackTrace();
        }
        return "index";  // index.jsp로 렌더링
    }
}







