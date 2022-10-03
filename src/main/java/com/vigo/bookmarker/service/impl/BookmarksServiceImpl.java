package com.vigo.bookmarker.service.impl;

import com.vigo.bookmarker.entity.Bookmarks;
import com.vigo.bookmarker.model.BookmarksDTO;
import com.vigo.bookmarker.model.BookmarksResponseDTO;
import com.vigo.bookmarker.repository.BookmarksRepository;
import com.vigo.bookmarker.service.BookmarksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 02/10/2022
 **/

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookmarksServiceImpl implements BookmarksService {

    private final BookmarksRepository bookmarksRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookmarksDTO> getBookmarks(){
        return bookmarksRepository.findAll().stream().map(this::convertEntityToData).collect(Collectors.toList());
    }

    private BookmarksDTO convertEntityToData(Bookmarks bookmarks) {
        return BookmarksDTO.builder().createdAt(bookmarks.getCreatedAt()).id(bookmarks.getId())
        .name(bookmarks.getName()).url(bookmarks.getUrl()).build();
    }

    @Override
    @Transactional(readOnly = true)
    public BookmarksResponseDTO getBookmarksPaginated(Pageable pageable) {
        return new BookmarksResponseDTO(bookmarksRepository.findBookmarks(pageable));
    }

    @Override
    public BookmarksDTO createBookmarks(BookmarksDTO bookmarks) {
        return convertEntityToData(bookmarksRepository.save(convertDataToEntity(bookmarks)));
    }

    private Bookmarks convertDataToEntity(BookmarksDTO bookmarksDTO) {
        return Bookmarks.builder().name(bookmarksDTO.getName()).url(bookmarksDTO.getUrl()).build();
    }
}
