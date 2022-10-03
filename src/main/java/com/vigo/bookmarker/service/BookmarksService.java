package com.vigo.bookmarker.service;

import com.vigo.bookmarker.entity.Bookmarks;
import com.vigo.bookmarker.model.BookmarksDTO;
import com.vigo.bookmarker.model.BookmarksResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 02/10/2022
 **/
public interface BookmarksService {

     List<BookmarksDTO> getBookmarks();

    BookmarksResponseDTO getBookmarksPaginated(Pageable pageable);


    BookmarksDTO createBookmarks(BookmarksDTO bookmarks);
}
