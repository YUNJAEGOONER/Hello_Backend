package kr.co.hanbit;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class TestRedirect {
    //리다이렉트 : 요청을 처리하기 위해 다른 곳으로 이동시킴
    //요청을 서버에서 처리하지 않고 다른 곳으로 유도한다.

    @RequestMapping("/redirect-test")
    public ResponseEntity redirectToTarget(){
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/target-redirect"));
        // return을 통해 301번 상태 코드(MOVED_PERMANENTLY) 발생 시킴
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @RequestMapping("/target-redirect")
    public String TargetOfRedirect(){
        return "Redirected!!";
    }

}
