package com.vigo.bookmarker.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 03/10/2022
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarksDTO {

    private Long id;

    private String url;

    private String name;

    private LocalDateTime createdAt;
}
