package com.example.kurlyitem.item;

import com.example.kurlyitem.item.categories.PrimaryCategories;
import com.example.kurlyitem.item.categories.SecondaryCategories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "primary_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private PrimaryCategories primaryCategory;

    @Column(name = "secondary_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private SecondaryCategories secondaryCategory;
}
