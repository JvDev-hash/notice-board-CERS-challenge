package com.joaovictor.noticeboard.repo;

import java.util.Optional;

import com.joaovictor.noticeboard.model.Notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepo extends JpaRepository<Notice, Long>{

    void deleteNoticeById(Long id);

    Optional<Notice> findNoticeById(Long id);
    
}
