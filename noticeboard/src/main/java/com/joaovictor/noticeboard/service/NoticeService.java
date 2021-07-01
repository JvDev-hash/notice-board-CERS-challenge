package com.joaovictor.noticeboard.service;

import java.util.*;

import com.joaovictor.noticeboard.exception.UserNotFoundException;
import com.joaovictor.noticeboard.model.Notice;
import com.joaovictor.noticeboard.repo.NoticeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    private final NoticeRepo noticerepo;

    @Autowired
    public NoticeService(NoticeRepo noticeRepo){
        this.noticerepo = noticeRepo;
    }

    public Notice addNotice(Notice notice){
        notice.setPublishDate(new Date());
        notice.setViewDate(new Date());
        return noticerepo.save(notice);
    }

    public List<Notice> findAllNotices(){
        return noticerepo.findAll();
    }

    public Notice updateNotice(Notice notice){
        return noticerepo.save(notice);
    }

    public void deleteNotice(Long id){
        noticerepo.deleteNoticeById(id);
    }

    public Notice findNoticeById(Long id){
        return noticerepo.findNoticeById(id)
                .orElseThrow(() -> new UserNotFoundException ("User by id: "+id+ "was not found."));
    }
}
