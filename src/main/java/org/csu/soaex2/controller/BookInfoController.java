package org.csu.soaex2.controller;

import org.csu.soaex2.common.CommonResponse;
import org.csu.soaex2.entity.BookInfo;
import org.csu.soaex2.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    private final String GET_ALL_BOOKINFO = "-GET http://localhost:8080/bookinfo";
    private final String CREATE_BOOKINFO = "-POST http://localhost:8080/bookinfo";
    private final String UPDATE_BOOKINFO = "-PUT http://localhost:8080/bookinfo/{book_id}";
    private final String DELETE_BOOKINFO = "-DELETE http://localhost:8080/bookinfo/{book_id}";
    private final String GET_ALL_API = "-GET http://localhost:8080/bookinfo/api";
    private final String GET_BOOKINFO_BY_ID = "-GET http://localhost:8080/bookinfo/{book_id}";


    @GetMapping("/api")
    public CommonResponse getAllApi(){
        CommonResponse<Object> response = CommonResponse.success();
        Link selfLink = linkTo(methodOn(BookInfoController.class).getAllApi()).withSelfRel(); // 当前 API 的链接
        Link createBookInfo= Link.of(CREATE_BOOKINFO).withRel("create-bookinfo");
        Link getAllBookInfo = Link.of(GET_ALL_BOOKINFO).withRel("get-all-bookinfo");
        Link updateBookInfo = Link.of(UPDATE_BOOKINFO).withRel("update-bookinfo");
        Link deleteBookInfo = Link.of(DELETE_BOOKINFO).withRel("delete-bookinfo");
        Link getBookInfoById = Link.of(GET_BOOKINFO_BY_ID).withRel("get-bookinfo-by-id");

        response.addLinks(List.of(selfLink, createBookInfo,updateBookInfo,getAllBookInfo,deleteBookInfo));

        return response;
    }

    @GetMapping
    public CommonResponse getAllBookInfo(){
        List bookInfo = bookInfoService.getAllBookInfo();
        CommonResponse<List> response;
        if(bookInfo.size()>0&&bookInfo!=null){
            response = CommonResponse.success(bookInfo);
        }else {
            response = CommonResponse.error(HttpStatus.NOT_FOUND.value(),"未查询到书籍信息，请先添加书籍信息");
        }
        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(BookInfoController.class).getAllBookInfo()).withSelfRel(); // 当前 API 的链接
        Link nextStepLink = Link.of(CREATE_BOOKINFO).withRel("create-bookinfo");
        Link allApi = Link.of(GET_ALL_API).withRel("get-all-api");

        response.addLinks(List.of(selfLink, nextStepLink,allApi));

        return response;
    }

    @PostMapping
    public CommonResponse createBookInfo(@RequestBody BookInfo bookInfo){
        Boolean created = bookInfoService.createBookInfo(bookInfo);
        CommonResponse response;
        if(created){
            response = CommonResponse.success("创建图书信息成功",null);
        }else {
            response = CommonResponse.error(HttpStatus.NOT_FOUND.value(), "创建图书信息失败");
        }

        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(BookInfoController.class).createBookInfo(bookInfo)).withSelfRel(); // 当前 API 的链接
        Link nextStepLink = Link.of(GET_ALL_BOOKINFO).withRel("get-all-bookinfo");
        Link getBookInfoById = Link.of(GET_BOOKINFO_BY_ID).withRel("get-bookinfo-by-id");
        Link allApi = Link.of(GET_ALL_API).withRel("get-all-api");

        response.addLinks(List.of(selfLink, nextStepLink,getBookInfoById,allApi));

        return response;
    }

    @DeleteMapping("/{book_id}")
    public CommonResponse deleteBookInfoById(@PathVariable("book_id")String bookId){
        Boolean deleted = bookInfoService.deleteBookInfo(bookId);
        CommonResponse response;
        if(deleted){
            response = CommonResponse.success("删除图书信息成功",null);
        }else {
            response = CommonResponse.error(HttpStatus.NOT_FOUND.value(), "删除图书信息失败");
        }

        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(BookInfoController.class).deleteBookInfoById(bookId)).withSelfRel(); // 当前 API 的链接
        Link nextStepLink = Link.of(GET_ALL_BOOKINFO).withRel("get-all-bookinfo");
        Link getBookInfoById = Link.of(GET_BOOKINFO_BY_ID).withRel("get-bookinfo-by-id");
        Link allApi = Link.of(GET_ALL_API).withRel("get-all-api");

        response.addLinks(List.of(selfLink, nextStepLink,getBookInfoById,allApi));

        return response;
    }

    @PutMapping("/{book_id}")
    public CommonResponse updateBookInfoById(@PathVariable("book_id")String bookId,@RequestBody BookInfo bookInfo){
        Boolean updated = bookInfoService.updateBookInfo(bookId,bookInfo);
        CommonResponse response;
        if(updated){
            response = CommonResponse.success("修改图书信息成功",null);
        }else {
            response = CommonResponse.error(HttpStatus.NOT_FOUND.value(), "修改图书信息失败");
        }

        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(BookInfoController.class).updateBookInfoById(bookId, bookInfo)).withSelfRel(); // 当前 API 的链接
        Link nextStepLink = Link.of(GET_ALL_BOOKINFO).withRel("get-all-bookinfo");
        Link getBookInfoById = Link.of(GET_BOOKINFO_BY_ID).withRel("get-bookinfo-by-id");
        Link allApi = Link.of(GET_ALL_API).withRel("get-all-api");

        response.addLinks(List.of(selfLink, nextStepLink,getBookInfoById,allApi));

        return response;
    }

    @GetMapping("/{book_id}")
    public CommonResponse getBookInfoById(@PathVariable("book_id")String bookId){
        BookInfo bookInfo = bookInfoService.getBookInfoById(bookId);
        CommonResponse response;
        if(bookInfo!=null){
            response = CommonResponse.success(bookInfo);
        }else {
            response = CommonResponse.error(HttpStatus.NOT_FOUND.value(),"未查询到相关书籍信息");
        }
        // 添加超媒体链接
        Link selfLink = linkTo(methodOn(BookInfoController.class).getBookInfoById(bookId)).withSelfRel(); // 当前 API 的链接
        Link nextStepLink = Link.of(CREATE_BOOKINFO).withRel("create-bookinfo");
        Link deleteBookInfoById = Link.of(DELETE_BOOKINFO).withRel("delete-bookinfo");
        Link updateBookInfoById = Link.of(UPDATE_BOOKINFO).withRel("update-bookinfo");
        Link getAllBookInfo = Link.of(GET_ALL_BOOKINFO).withRel("get-all-bookinfo");
        Link allApi = Link.of(GET_ALL_API).withRel("get-all-api");

        response.addLinks(List.of(selfLink, nextStepLink,deleteBookInfoById,updateBookInfoById,getAllBookInfo,allApi));

        return response;
    }
}
