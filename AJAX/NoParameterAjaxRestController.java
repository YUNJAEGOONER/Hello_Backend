package kr.co.hanbit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoParameterAjaxRestController {

    // 해당 경로로 요청이 들어온 경우 ~
    // get-with-no-parameter 라는 경로로 요청이 들어온 경우
    @RequestMapping("/get-with-no-parameter")
    public String getWithNoParameter(){
        return "파라미터가 없는 GET 요청"; // 해당 String을 return 한다.
    }
}
