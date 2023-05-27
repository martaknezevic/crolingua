package com.miv.croatica.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutorials")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Tutorial {
    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "short_description")
    private String shortDescription;

    @NonNull
    @Column(name = "content")
    private String content;

    @NonNull
    @Column(name = "level")
    @Enumerated(EnumType.ORDINAL)
    private TutorialLevel level;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
}
