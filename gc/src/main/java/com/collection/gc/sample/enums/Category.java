package com.collection.gc.sample.enums;

import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ToString
@AllArgsConstructor
public enum Category {

    APPLE("사과", 1, ImmutableSet.of(SubCategory.A, SubCategory.B)),
    GRAPE("포도", 2, ImmutableSet.of(SubCategory.A, SubCategory.C)),
    BANANA("바나나", 2, ImmutableSet.of(SubCategory.A, SubCategory.B)),
    STRAWBERRY("딸기", 2, ImmutableSet.of(SubCategory.C)),
    PEACH("복숭아", 1, ImmutableSet.of(SubCategory.B)),
    PLUM("자두", 1, ImmutableSet.of(SubCategory.A));

    @Getter
    private final String title;

    @Getter
    private final int size;

    @Getter
    private final Set<SubCategory> subCategories;

    enum SubCategory {
        A,
        B,
        C,
        D
    }

    private static Predicate<Category> predicateTitleEquals(String title) {
        return o -> o.getTitle().equals(title);
    }

    private static Predicate<Category> predicateSubCategory(SubCategory subCategory) {
        return o -> o.getSubCategories()
                        .stream().anyMatch( s -> s == subCategory);
    }

    public static Category findByTitle(String title) {
        return Arrays.stream(Category.values())
                .filter( predicateTitleEquals(title) )
                .findFirst()
                .orElse(null);
    }

    public static Set<Category> findBySubCategory(SubCategory subCategory) {
        return Arrays.stream(Category.values())
                .filter( predicateSubCategory(subCategory) )
                .collect(Collectors.toSet());
    }

    public static Category findByTitleAndSubCategory(String title, SubCategory subCategory) {
        return Arrays.stream(Category.values())
                .filter( predicateSubCategory(subCategory)
                            .and(predicateTitleEquals(title)) )
                .findFirst()
                .orElse(null);
    }

}