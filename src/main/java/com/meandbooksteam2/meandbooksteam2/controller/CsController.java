package com.meandbooksteam2.meandbooksteam2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*고객센터 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class CsController {

    @GetMapping("/cs")
    public String cs(){
        return "/cs/menu";
    }

    @GetMapping("/cs/faq")
    public String faq(){
        return "/cs/faq/faq";
    }

    @GetMapping("/cs/faq/writeFaq")
    public String writeFaq(){
        return "/cs/faq/writeFaq";
    }

    @GetMapping("/cs/faq/updateFaq")
    public String updateFaq(){
        return "/cs/faq/updateFaq";
    }

    @GetMapping("/cs/notice")
    public String notice(){
        return "/cs/notice/notice";
    }

    @GetMapping("/cs/notice/writeNotice")
    public String writeNotice(){
        return "/cs/notice/writeNotice";
    }

    @GetMapping("/cs/notice/updateNotice")
    public String updateNotice(){
        return "/cs/notice/updateNotice";
    }

    @GetMapping("/cs/qna")
    public String qna(){
        return "/cs/qna/qna";
    }

    @GetMapping("/cs/qna/writeQna")
    public String writeQna(){
        return "/cs/qna/writeQna";
    }

    @GetMapping("/cs/qna/updateQna")
    public String updateQna(){
        return "/cs/qna/updateQna";
    }
}
