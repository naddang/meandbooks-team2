package com.meandbooksteam2.shoppingmall.service.admin;

import com.meandbooksteam2.shoppingmall.dao.admin.ManageBookDao;
import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.NoticeDto;
import com.meandbooksteam2.shoppingmall.dto.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Service
public class ManageBookServiceImpl {

    ManageBookDao dao;

    @Autowired
    public void setDao(ManageBookDao dao) {
        this.dao = dao;
    }

//    /*책 관리 화면에서 기준에 맞춰 책 목록을 보여주는 메서드*/
//    public List<BookDto> bookList(HashMap<String, String> param){
//        if (param.get("page") == null) {
//            param.put("page", "1");
//        }
//        return dao.listBook(param);
//    }
//
    /*keyword를 받아 책 리스트를 리턴하는 메서드*/ //이거 쓰는건가요
//    public List<BookDto> searchBook(HashMap<String, String> param){
//        return dao.searchBook(param);
//    }

    /*책 관리 화면에서 기준에 맞춰 책 목록을 보여주는 메서드*/
    public List<BookDto> listBook(BookDto params) {
        List<BookDto> list = Collections.emptyList();

        int bookTotalCount = dao.selectBookTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(bookTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (bookTotalCount > 0) {
            list = dao.listBook(params);
        }

        return list;
    }

    /*keyword를 받아 책 리스트를 리턴하는 메서드*/
    public List<BookDto> listSearchBook(BookDto params) {
        List<BookDto> list = Collections.emptyList();

        int bookSearchTotalCount = dao.selectBookSearchTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(bookSearchTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (bookSearchTotalCount > 0) {
            list = dao.listSearchBook(params);
        }

        return list;
    }


    /*book_no를 받아 해당 책에대한 정보를 리턴하는 메서드*/
    public BookDto viewBook(HashMap<String, String> param){
        return dao.viewBook(param);
    }

    /*form에서 입력받은 책 정보들을 DB에 삽입하는 메서드*/
//    public int insertBook(HashMap<String, String> param){
//        param.put("book_no", getBookNo(param));
//        return dao.insertBook(param);
//    }

    public int insertBook(HashMap<String, String> param, MultipartFile file, HttpServletRequest request) throws IOException {
        param.put("book_no", getBookNo(param));
        String resourceSrc = request.getServletContext().getRealPath("/book-imgs/");
        System.out.println(resourceSrc);
        String filename = file.getOriginalFilename();   //--- 파일명을 얻어옴.
        file.transferTo( new File( resourceSrc+filename ) );  //--- 저장할 경로를 설정
        param.put( "book_img", filename );  //--- 파일명을 저장합니다.

        System.out.println(filename);
        return dao.insertBook(param);
    }

    /*책 수량을 업데이트하는 메서드*/
    public int updateBook(HashMap<String, String> param){
        return dao.updateBook(param);
    }

    /*책 번호를 매개변수로 해당 책을 DB에서 삭제하는 메서드*/
    public int deleteBook(HashMap<String, String> param){
        return dao.deleteBook(param);
    }

    /*insert할 때 삽입해야 할 책 번호를 리턴하는 메서드*/
    private String getBookNo(HashMap<String, String> param){
        String book_no = String.valueOf(dao.getBookNo(param));

        if (book_no == null) {
            book_no = param.get("nation") + param.get("category") + "0001";
        }
        System.out.println(book_no);
        return book_no;
    }
}
