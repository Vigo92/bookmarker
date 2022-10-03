package com.vigo.bookmarker.controller;

import com.vigo.bookmarker.entity.Bookmarks;
import com.vigo.bookmarker.repository.BookmarksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 03/10/2022
 **/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@TestPropertySource(properties = {
//        "spring.datasource.url=jdbc:tc:mysql:latest:///coinx"
//})
public class BookmarksControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarksRepository bookmarksRepository;


    public void beforeSetup(){
        bookmarksRepository.deleteAllInBatch();
        List<Bookmarks> bookmarksList = new ArrayList<>();
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksList.add(new Bookmarks(null,"https://app.pluralsight.com/paths/skill/implementing-and-managing-amazon-eks-elastic-kubernetes-service","EKS", LocalDateTime.now()));
        bookmarksRepository.saveAll(bookmarksList);
    }

    @Test
    public void shouldGetBookmarks() throws Exception {

        mockMvc.perform(get("http://localhost:8080/api/v1/bookmarks")).
                andExpect(status().isOk());
//                .andExpect(jsonPath("$.totalPages",CoreMatchers.equalTo(4)))
//                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(4)))
//                        .andExpect( jsonPath("$.totalElements", CoreMatchers.equalTo(4)))
//                         .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(4)))
//                         .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(4)))
//                          .andExpect(jsonPath("$.hasPrevious", CoreMatchers.equalTo(4)));

    }
}
