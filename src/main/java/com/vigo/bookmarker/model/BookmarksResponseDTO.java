package com.vigo.bookmarker.model;

import com.vigo.bookmarker.entity.Bookmarks;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 02/10/2022
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarksResponseDTO {

    private List<BookmarksDTO> bookmarksList;
    private int totalPages;
    private int totalElements;
    private int currentPage;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksResponseDTO(Page<BookmarksDTO> bookmarks){
        this.setBookmarksList(bookmarks.getContent());
        this.setTotalElements(bookmarks.getNumberOfElements());
        this.setTotalPages(bookmarks.getTotalPages());
        this.setFirst(bookmarks.isFirst());
        this.setLast(bookmarks.isLast());
        this.setHasNext(bookmarks.hasNext());
        this.setHasPrevious(bookmarks.hasPrevious());

    }
}
