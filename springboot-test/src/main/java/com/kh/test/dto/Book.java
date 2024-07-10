package com.kh.test.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long book_id;
    private String book_isbn;
    private String book_title;
    private String book_author;
    private String book_pubdate;
}
