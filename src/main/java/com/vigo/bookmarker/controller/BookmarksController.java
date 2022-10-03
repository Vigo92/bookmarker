package com.vigo.bookmarker.controller;

import com.vigo.bookmarker.model.BookmarksDTO;
import com.vigo.bookmarker.model.BookmarksResponseDTO;
import com.vigo.bookmarker.service.BookmarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 02/10/2022
 **/

@RestController
@RequestMapping("api/v1/bookmarks")
@RequiredArgsConstructor
public class BookmarksController {

    private final BookmarksService bookmarksService;


    @GetMapping("/all")
    public ResponseEntity<List<BookmarksDTO>> getBookmarks(){
        List<BookmarksDTO> bookmarksList = bookmarksService.getBookmarks();
        return new ResponseEntity<>(bookmarksList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BookmarksResponseDTO> getBookmarks(@RequestParam(value = "page",defaultValue = "0") int page,
                                                             @RequestParam(value = "size",defaultValue = "10") int size){
        BookmarksResponseDTO bookmarksList = bookmarksService.getBookmarksPaginated(PageRequest.of(page,size, Sort.Direction.DESC,"createdAt"));
        return new ResponseEntity<>(bookmarksList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookmarksDTO> createBookmark(@RequestBody BookmarksDTO bookmarks){
        BookmarksDTO bookmarksDTO = bookmarksService.createBookmarks(bookmarks);
        return new ResponseEntity<>(bookmarksDTO, HttpStatus.OK);
    }

}
