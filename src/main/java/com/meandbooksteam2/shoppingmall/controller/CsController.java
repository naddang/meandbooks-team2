package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.*;
import com.meandbooksteam2.shoppingmall.service.cs.FaqServiceImpl;
import com.meandbooksteam2.shoppingmall.service.cs.NoticeServiceImpl;
import com.meandbooksteam2.shoppingmall.service.cs.QnaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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

    @GetMapping("cs")
    public String cs() {
        return "cs/menu";
    }
    
    /*FAQ 시작*/

    /*FAQ 목록으로 이동 - 완, 꾸미기 미완성*/
    @GetMapping("cs/faq")
    public String faq(Model model) {
        List<FaqDto> list = faqService.listFaq();
        model.addAttribute("list", list);
        return "cs/faq/listFaq";
    }

    /*FAQ 작성 페이지로 이동 - 완*/
    @GetMapping("cs/faq/writeFaq")
    public String writeFaq(HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {
            return "cs/faq/writeFaq";
        } else {
            return "/";
        }
    }

    /*FAQ 작성 완료 - 작성 이후에는 목록으로 이동 - 완*/
    @GetMapping("cs/faq/writeFaq_ok")
    public String writeFaqOk(@RequestParam HashMap<String, String> param) {
        int result = faqService.insertFaq(param);

        if (result == 1) {
            return "redirect:/cs/faq";
        } else {
            return "redirect:/cs/faq/writeFaq";
        }
    }

    /*FAQ 삭제 - 성공하면 목록, 실패하면 어디로 갈까... - 완*/
    @GetMapping("cs/faq/deleteFaq")
    public String deleteFaq(@RequestParam HashMap<String, String> param) {
        int result = faqService.deleteFaq(param);

        if (result == 1) {
            return "redirect:/cs/faq";
        } else {
            return "error";
        }
    }

    /*선택한 FAQ의 내용을 보여주고, 수정 가능하도록 하는 페이지 - 완*/
    @GetMapping("cs/faq/updateFaq")
    public String updateFaq(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {
            model.addAttribute("view", faqService.viewFaq(param));
            return "cs/faq/updateFaq";
        }else {
            return "/";
        }
    }

    /*수정이 성공하면 리스트로 가고 아니면 다시 수정 화면으로 - 완*/
    @GetMapping("cs/faq/updateFaq_ok")
    public String updateFaqOk(@RequestParam HashMap<String, String> param) {
        int result = faqService.updateFaqStatus(param);

        if (result == 1) {
            return "redirect:/cs/faq";
        } else {
            return "redirect:/cs/faq/updateFaq?faq_no="+param.get("faq_no");
        }
    }
    
    /*--------FAQ 끝--------*/

    /*--------Notice 시작--------*/

    /*공지 목록으로 */
    @GetMapping("cs/notice")
    public String openBoardList(@ModelAttribute("params") NoticeDto params, Model model) {
        List<NoticeDto> list = noticeService.listNotice(params);
        model.addAttribute("list", list);

        return "cs/notice/listNotice";
    }

    /*검색으로 목록 찾기*/
    @GetMapping("cs/notice/searchNotice")
    public String searchNotice(@ModelAttribute("params") NoticeDto params, Model model) {
        List<NoticeDto> list = noticeService.listSearchNotice(params);
        model.addAttribute("list", list);

        return "cs/notice/listNotice";
    }

    /*개별 공지 내용 확인 - 완*/
    @GetMapping("cs/notice/viewNotice")
    public String viewNotice(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("view", noticeService.viewNotice(param));
        return "cs/notice/viewNotice";
    }

    /*공지 작성 페이지로 - 관리자만 가능, 관리자 페이지에서 들어감 - 완*/
    @GetMapping("cs/notice/writeNotice")
    public String writeNotice(HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {
            return "cs/notice/writeNotice";
        } else {
            return "/";
        }
    }

    /*공지 작성완료 - 완*/
    /*작성완료되면 리스트로 가는데 거기서 다시 새로고침 해야 변경사항이 뜸 방법 찾아야 함*/
    @GetMapping("cs/notice/writeNotice_ok")
    public String writeNoticeOk(@RequestParam HashMap<String, String> param) {
        int result = noticeService.insertNotice(param);

        if (result == 1) {
            return "redirect:/cs/notice";
//            return "redirect:/cs/notice";
        } else {
            return "redirect:/cs/notice/writeNotice";
        }
    }

    /*수정하기 위해서 내용을 보여주는 페이지로 이동, 이 페이지에서 삭제도 - 완*/
    @GetMapping("cs/notice/updateNotice")
    public String updateNotice(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {
            model.addAttribute("view", noticeService.viewNotice(param));
            return "cs/notice/updateNotice";
        } else {
            return "/";
        }
    }

    /*수정 완료되면 내용 확인 페이지로, 아니면 수정 페이지에 머물도록 - 완*/
    @GetMapping("cs/notice/updateNotice_ok")
    public String updateNoticeOk(@RequestParam HashMap<String, String> param) {
        int result = noticeService.updateNoticeStatus(param);

        if (result == 1) {
            return "redirect:/cs/notice/viewNotice?noti_no="+param.get("noti_no");
        } else {
            return "redirect:/cs/notice/updateNotice";
        }
    }

    /*삭제 완료 - 완*/
    @GetMapping("cs/notice/delete_ok")
    public String deleteNotice(@RequestParam HashMap<String, String> param) {
        int result = noticeService.deleteNotice(param);

        if (result == 1) {
            return "redirect:/cs/notice";
        } else {
            return "redirect:/cs/notice/updateNotice?noti_no="+param.get("noti_no");
        }
    }

    /*--------Notice 끝--------*/

    /*--------QNA 시작--------*/

    /*관리자 qna 목록 - 완*/
    @GetMapping("cs/qna/adminListQna")
    public String openBoardList(@ModelAttribute("params") QnaQDto params, Model model, HttpSession session) {

        if (session.getAttribute("isAdmin").toString().equals("1")) {

            List<QnaQDto> list = qnaService.adminListQna(params);
            model.addAttribute("list", list);

            return "cs/qna/adminListQna";
        } else {
            return "/";
        }
    }

    @GetMapping("cs/qna/searchQna")
    public String searchQna(@ModelAttribute("params") QnaQDto params, Model model, HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {

            List<QnaQDto> list = qnaService.searchQna(params);
            model.addAttribute("list", list);

            return "cs/qna/adminListQna";
        } else {
            return "/";
        }
    }

    /*회원 qna 목록 - 페이징x - 완*/
    @GetMapping("cs/qna/memListQna")
    public String memQnaList(Model model, HttpSession session) {
        String mem_no = (String)session.getAttribute("mem_no");
        System.out.println(mem_no);
        List<QnaQDto> list = qnaService.memListQna(mem_no);
        model.addAttribute("list", list);

        return "cs/qna/memListQna";
    }

    /*회원이 개별 qna 확인 - 완*/
    @GetMapping("cs/qna/viewMemQna")
    public String viewMemQna(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("q", qnaService.viewQnaQ(param));
        if (qnaService.viewQnaA(param) != null) {
            model.addAttribute("a", qnaService.viewQnaA(param));
        }
            return "cs/qna/viewMemQna";
    }

    /*관리자가 개별 qna 확인 - 완*/
    @GetMapping("cs/qna/viewAdminQna")
    public String viewAdminQna(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
        if (session.getAttribute("isAdmin").toString().equals("1")) {
            model.addAttribute("q", qnaService.viewQnaQ(param));
            model.addAttribute("a", qnaService.viewQnaA(param));
            return "cs/qna/viewAdminQna";
        } else {
            return "/";
        }
    }

    /*qna질문 작성 페이지로 - 완*/
    @GetMapping("cs/qna/writeQna")
    public String writeQnaQ(HttpSession session) {
        //세션으로 분기문 처리
        //로그인 상태면 작성 페이지, 아니면 로그인 화면
        String mem_no = (String) session.getAttribute("mem_no");
        if (mem_no != null) {
            session.setAttribute("mem_no", mem_no);
            return "cs/qna/writeQna";
        } else {
            return "member/login";
        }
    }

    /*qna 질문 작성 완료 - 완*/
    @GetMapping("cs/qna/writeQna_ok")
    public String writeQnaOk(@RequestParam HashMap<String, String> param) {
        int result = qnaService.insertQnaQ(param);
        if (result == 1) {
            return "redirect:/cs/qna/memListQna";
        } else {
            return "redirect:/cs/qna/writeQna";
        }
    }

    /*qna 수정화면으로 이동 - 완*/
    @GetMapping("cs/qna/updateQnaQ")
    public String updateQna(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("q", qnaService.viewQnaQ(param));
//        model.addAttribute("a", qnaService.viewQnaA(param));
        return "cs/qna/updateQnaQ";
    }

    /*수정 성공하면 그 질문 읽는 페이지, 아니면 다시 수정 페이지 - 완*/
    @GetMapping("cs/qna/updateQnaQ_ok")
    public String updateQnaQOk(@RequestParam HashMap<String, String> param) {
        int result = qnaService.updateQnaQStatus(param);
        if (result == 1) {
            return "redirect:/cs/qna/viewMemQna?q_no="+param.get("q_no");
        } else {
            return "redirect:/cs/qna/updateQnaQ?q_no="+param.get("q_no");
        }
    }

    /*문의 질문 삭제를 위해서 답변부터 삭제하고 문의 글 삭제 - 만들긴 함 확인 필요*/
    @GetMapping("cs/qna/deleteQnaQ")
    public String deleteQnaQ(@RequestParam HashMap<String, String> param) {
        int result_a = qnaService.deleteQnaA(param);
        int result_q = qnaService.deleteQnaQ(param);

        if (result_a == 1) {
            if (result_q == 1) {
                return "redirect:/cs/qna/memListQna";
            } else {
                return "redirect:/cs/qna/viewMemQna?q_no="+param.get("q_no");
            }
        } else {
            if (result_q == 1) {
                return "redirect:/cs/qna/memListQna";
            } else {
                return "redirect:/cs/qna/viewQna?q_no="+param.get("q_no");
            }
        }
    }

    /*문의에 답변 작성 - 완*/
    @GetMapping("cs/qna/insertQnaA_ok")
    public String insertQnaAOk(@RequestParam HashMap<String, String> param, Model model) {
        int result = qnaService.insertQnaA(param);

        if (result == 1) {
            model.addAttribute("q_no", param.get("q_no"));
            return "cs/qna/updateAccessLevel";
        } else {
            return "redirect:/cs/qna/viewAdminQna?q_no="+param.get("q_no");
        }
    }

    /*답변 상태 변경 - 완*/
    @GetMapping("cs/qna/updateAccessLevel_ok")
    public String updateAccessLevelOK(@RequestParam HashMap<String, String> param) {
        int result = qnaService.updateAccessLevel(param);
        if (result == 1) {
            return "redirect:/cs/qna/adminListQna";
        } else {
            return "error";
//            return "redirect:cs/qna/viewAdminQna?q_no="+param.get("q_no");
        }
    }

    /*문의 답변 수정 - 완*/
    @GetMapping("cs/qna/updateQnaA")
    public String updateQnaA(@RequestParam HashMap<String, String> param) {
        int result = qnaService.updateQnaAStatus(param);
        if (result == 1) {
            return "redirect:/cs/qna/adminListQna";
        } else {
            return "redirect:/cs/qna/viewAdminQna?q_no="+param.get("q_no");
        }
    }

    /*문의 답변 삭제 - 완*/
    @GetMapping("cs/qna/deleteQnaA")
    public String deleteQnaA(@RequestParam HashMap<String, String> param) {
        int result = qnaService.deleteQnaA(param);
        if (result == 1) {
            return "redirect:/cs/qna/adminListQna";
        } else {
            return "redirect:/cs/qna/viewQna";
        }
    }

    /*--------QNA 끝--------*/
}
