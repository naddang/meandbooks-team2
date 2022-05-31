package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.FaqDto;
import com.meandbooksteam2.shoppingmall.dto.NoticeDto;
import com.meandbooksteam2.shoppingmall.dto.QnaQDto;
import com.meandbooksteam2.shoppingmall.service.cs.FaqServiceImpl;
import com.meandbooksteam2.shoppingmall.service.cs.NoticeServiceImpl;
import com.meandbooksteam2.shoppingmall.service.cs.QnaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/*고객센터 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class CsController {

    @Autowired
    private FaqServiceImpl faqService;
    @Autowired
    private NoticeServiceImpl noticeService;
    @Autowired
    private QnaServiceImpl qnaService;
//    @Autowired
//    private AdminSession adminSession;


/*    private boolean isAdmin(HttpSession session) {
        String mem_uid = (String)session.getAttribute("mem_uid");
        return adminSession.isAdmin(mem_uid);
    }*/

    @GetMapping("cs")
    public String cs() {
        return "cs/menu";
    }
    
    /*FAQ 시작*/

    /*FAQ 목록으로 이동*/
    @GetMapping("cs/faq")
    public String faq(Model model) {
        List<FaqDto> listFaq = faqService.listFaq();
        model.addAttribute("list", listFaq);
        return "cs/faq/listFaq";
    }

    /*FAQ 작성 페이지로 - 작성 이후에는 목록으로 이동*/
    @GetMapping("cs/faq/writeFaq")
    public String writeFaq(@RequestParam HashMap<String, String> param) {
        int result = faqService.insertFaq(param);

        if (result == 1) {
            return "redirect:cs/faq";
        } else {
            return "redirect:cs/faq/writeFaq";
        }
    }

    /*FAQ 삭제 - 성공하면 목록, 실패하면 어디로 갈까...*/
    @GetMapping("cs/faq/deleteFaq")
    public String deleteFaq(@RequestParam HashMap<String, String> param) {
        int result = faqService.deleteFaq(param);

        if (result == 1) {
            return "redirect:cs/faq";
        } else {
            return "error";
        }
    }

    /*선택한 FAQ의 내용을 보여주고, 수정 가능하도록 하는 페이지*/
    @GetMapping("cs/faq/updateFaq")
    public String updateFaq(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("faq", faqService.viewFaq(param));
        return "cs/faq/updateFaq";
    }

    /*수정이 성공하면 리스트로 가고 아니면 다시 수정 화면으로*/
    @GetMapping("cs/faq/updateFaq_ok")
    public String updateFaqOk(@RequestParam HashMap<String, String> param) {
        int result = faqService.updateFaqStatus(param);

        if (result == 1) {
            return "redirect:cs/faq/listFaq";
        } else {
            return "redirect:cs/faq/updateFaq";
        }
    }
    
    /*--------FAQ 끝--------*/

    /*--------Notice 시작--------*/

    /*공지사항 목록으로 이동 - 이거 페이징 처리 해야하는데 어떻게 해야할지 잘 모르겠음*/
    /*매개변수 달아놓은 이유가 페이징 때문에 달아둠*/
    @GetMapping("cs/notice")
//    public String listNotice(@RequestParam HashMap<String, String> param, Model model){ - 페이징 처리할 때 사용
    public String listNotice(Model model) {
//        List<NoticeDto> listNotice = noticeService.listNotice(param); - 페이징 처리할 때 사용
        List<NoticeDto> listNotice = noticeService.listNotice();
        model.addAttribute("list", listNotice);
        return "cs/notice/listNotice";
    }

    /*검색어로 공지사항 목록 가져오기*/
    @GetMapping("cs/notice/searchNotice")
//    public String searchNotice(@RequestParam HashMap<String, String> param, Model model) { - 페이징 처리할 때 사용
    public String searchNotice(Model model) {
        List<NoticeDto> searchNotice = noticeService.searchNotice();
        model.addAttribute("list", searchNotice);
        return "cs/notice/listNotice";
    }

    /*공지 작성*/
    @GetMapping("cs/notice/writeNotice")
    public String writeNotice(@RequestParam HashMap<String, String> param) {
        int result = noticeService.insertNotice(param);

        if (result == 1) {
            return "redirect:cs/notice";
        } else {
            return "redirect:cs/notice/writeNotice";
        }
    }

    /*수정하기 위해서 내용을 보여주는 페이지로 이동, 이 페이지에서 삭제도*/
    @GetMapping("cs/notice/updateNotice")
    public String updateNotice(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("notice", noticeService.viewNotice(param));
        return "cs/notice/updateNotice";
    }

    /*수정 완료되면 목록으로, 아니면 수정 페이지에 머물도록*/
    @GetMapping("cs/notice/updateNotice_ok")
    public String updateNoticeOk(@RequestParam HashMap<String, String> param) {
        int result = noticeService.updateNoticeStatus(param);

        if (result == 1) {
            return "redirect:cs/notice";
        } else {
            return "redirect:cs/notice/updateNotice";
        }
    }

    /*삭제 완료*/
    @GetMapping("cs/notice/delete_ok")
    public String deleteNotice(@RequestParam HashMap<String, String> param) {
        int result = noticeService.deleteNotice(param);

        if (result == 1) {
            return "redirect:cs/notice";
        } else {
            return "redirect:cs/notice/updateNotice";
        }
    }

    /*개별 공지 내용 확인*/
    @GetMapping("cs/notice/viewNotice")
    public String viewNotice(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("notice", noticeService.viewNotice(param));
        return "redirect:cs/notice/viewNotice";
    }

    /*--------Notice 끝--------*/

    /*--------QNA 시작--------*/

    /*qna 목록*/
    @GetMapping("cs/qna")
//    public String qna(@RequestParam HashMap<String, String> param, Model model) { - 페이징 처리 때 사용
    public String qna(Model model) {
        List<QnaQDto> listQna = qnaService.listQna();
        model.addAttribute("list", listQna);
        return "cs/qna/listQna";
    }

    /*비밀번호 확인 페이지로 이동*/
    @GetMapping("cs/qna/checkQnaPw")
    public String checkQnaPw() {
        return "cs/qna/checkQnaPw";
    }

    /*위에서 입력하고 확인 누르면 여기로*/
    @GetMapping("cs/qna/checkQnaPw_ok")
    public String checkQnaPwOk(@RequestParam HashMap<String, String> param, Model model) {
        int result = qnaService.checkQnaPW(param);
        if (result == 1) {
            return "redirect:cs/qna/viewQna";
        } else {
            return "redirect:cs/qna";
        }
    }

    /*개별 qna 확인*/
    @GetMapping("cs/qna/viewQna")
    public String viewQna(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("qna_q", qnaService.viewQnaQ(param));
        model.addAttribute("qna_a", qnaService.viewQnaA(param));
        return "cs/qna/viewQna";
    }

    /*qna질문 작성 페이지로*/
    @GetMapping("cs/qna/writeQna")
    public String writeQnaQ() {
        return "cs/qna/writeQna";
    }

    /*qna 질문 작성*/
    @GetMapping("cs/qna/writeQna_ok")
    public String writeQnaOk(@RequestParam HashMap<String, String> param) {
        int result = qnaService.insertQnaQ(param);
        if (result == 1) {
            return "redirect:cs/qna";
        } else {
            return "redirect:cs/qna/writeQna";
        }
    }

    /*qna 수정화면으로 이동*/
    @GetMapping("cs/qna/updateQna")
    public String updateQna(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("qna_q", qnaService.viewQnaQ(param));
        model.addAttribute("qna_a", qnaService.viewQnaA(param));
        return "cs/qna/updateQna";
    }

    /*수정 성공하면 그 질문 읽는 페이지, 아니면 다시 수정 페이지*/
    @GetMapping("cs/qna/updateQnaQ_ok")
    public String updateQnaQOk(@RequestParam HashMap<String, String> param) {
        int result = qnaService.updateQnaQStatus(param);
        if (result == 1) {
            return "redirect:cs/qna/viewQna";
        } else {
            return "redirect:cs/qna/updateQna";
        }
    }

    /*문의 질문 삭제를 위해서 답변부터 삭제하고 문의 글 삭제*/
    @GetMapping("cs/qna/deleteQnaQ")
    public String deleteQnaQ(@RequestParam HashMap<String, String> param) {
        int result_a = qnaService.deleteQnaA(param);
        int result_q = qnaService.deleteQnaQ(param);

        if (result_a == 1) {
            if (result_q == 1) {
                return "redirect:cs/qna";
            } else {
                return "redirect:cs/qna/updateQna";
            }
        } else {
            return "redirect:cs/qna/updateQna";
        }
    }

    /*문의 답변은 작성 성공하면 시크하게 목록으로 나가는 느낌 - 관리자면 항상 답변은 수정 가능한 폼으로 보이도록*/
    /*회원은 읽기 전용 뷰로 보이게*/

    /*문의에 답변 작성 - 뷰에서 타임리프로 관리자만 작성 가능하도록 분기처리*/
    @GetMapping("cs/qna/insertQnaA")
    public String insertQnaA(@RequestParam HashMap<String, String> param) {
        int result = qnaService.insertQnaA(param);
        if (result == 1) {
            return "redirect:cs/qna";
        } else {
            return "redirect:cs/qna/viewQna";
        }
    }

    /*문의 답변 수정*/
    @GetMapping("cs/qna/updateQnaA")
    public String updateQnaA(@RequestParam HashMap<String, String> param) {
        int result = qnaService.updateQnaAStatus(param);
        if (result == 1) {
            return "redirect:cs/qna";
        } else {
            return "redirect:cs/qna/viewQna";
        }
    }

    /*문의 답변 삭제*/
    @GetMapping("cs/qna/deleteQnaA")
    public String deleteQnaA(@RequestParam HashMap<String, String> param) {
        int result = qnaService.deleteQnaA(param);
        if (result == 1) {
            return "redirect:cs/qna";
        } else {
            return "redirect:cs/qna/viewQna";
        }
    }

    /*--------Notice 끝--------*/
}
