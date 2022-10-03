package com.vigo.bookmarker.repository;

import com.vigo.bookmarker.entity.Bookmarks;
import com.vigo.bookmarker.model.BookmarksDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 02/10/2022
 **/
public interface BookmarksRepository extends JpaRepository<Bookmarks, Long> {


    @Query("select new com.vigo.bookmarker.model.BookmarksDTO(b.id, b.url, b.name,b.createdAt) from Bookmarks  b")
    Page<BookmarksDTO> findBookmarks(Pageable pageable);
}
