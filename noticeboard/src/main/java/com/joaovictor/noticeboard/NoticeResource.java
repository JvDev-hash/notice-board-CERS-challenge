package com.joaovictor.noticeboard;

import com.joaovictor.noticeboard.model.Notice;
import com.joaovictor.noticeboard.repo.NoticeRepo;
import com.joaovictor.noticeboard.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/notice")
public class NoticeResource {
    
    @Autowired
    private final NoticeRepo noticeRepo;


    private final NoticeService noticeService;

    public NoticeResource(NoticeService noticeService, NoticeRepo noticeRepo){
        this.noticeService = noticeService;
        this.noticeRepo = noticeRepo;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Notice>> getAllNotices(){

        List<Notice> notices = noticeService.findAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable("id") Long id){

        Notice notice = noticeService.findNoticeById(id);
        return new ResponseEntity<>(notice, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Notice> addNotice(@RequestBody Notice notice){

        Notice newNotice = noticeService.addNotice(notice);
        return new ResponseEntity<>(newNotice, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Notice> updateNotice(@RequestBody Notice newNotice){

        Notice updNotice = noticeService.updateNotice(newNotice);
        //updNotice.setViewDate(new Date());
        return new ResponseEntity<>(updNotice, HttpStatus.OK);

    }

    @PutMapping("/view")
    public ResponseEntity<Notice> viewNotice(@RequestBody Notice newNotice){

        Notice updNotice = noticeService.viewNotice(newNotice);
        updNotice.setViewFlag("Viewed");
        updNotice.setViewDate(new Date());
        return new ResponseEntity<>(updNotice, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Notice> deleteNotice(@PathVariable("id") Long id){
        
        Notice notice = noticeService.findNoticeById(id);
        noticeRepo.delete(notice);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
