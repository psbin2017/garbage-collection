package com.collection.gc.sample.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @DisplayName("findByTitle 색인 성공")
    @Test
    void findByTitle_findSuccess() {
        assertNotNull(Category.findByTitle("사과"));
    }

    @DisplayName("findByTitle 색인 실패")
    @Test
    void findByTitle_findFail() {
        assertNull(Category.findByTitle("귤"));
    }

    @DisplayName("findBySubCategory 색인 결과 있음")
    @Test
    void findBySubCategory_findSuccess() {
        assertTrue(Category.findBySubCategory(Category.SubCategory.A).size() > 0);
    }

    @DisplayName("findBySubCategory 색인 결과 비어있음")
    @Test
    void findBySubCategory_findFail() {
        assertEquals(0, Category.findBySubCategory(Category.SubCategory.D).size());
    }

    @DisplayName("findByTitleAndSubCategory 색인 성공")
    @Test
    void findByTitleAndSubCategory_findSuccess() {
        assertNotNull(Category.findByTitleAndSubCategory("딸기", Category.SubCategory.C));
    }

    @DisplayName("findByTitleAndSubCategory 색인 실패")
    @Test
    void findByTitleAndSubCategory_findFail() {
        assertNull(Category.findByTitleAndSubCategory("자두", Category.SubCategory.D));
    }

    @DisplayName("성능 테스트 전체 색인 성공")
    @Test
    void perf_findSuccess() {
        String title = "포도";
        Category.SubCategory subCategory = Category.SubCategory.A;
        int loopCount = 1000_0000;

        StopWatch st = new StopWatch();
        st.start("title 로 만 검색");
        for (int i = 0; i < loopCount; i++) {
            Category.findByTitle(title);
            assertNotNull(Category.findByTitle(title));
        }
        st.stop();

        st.start("title & subcategory 로 검색");
        for (int i = 0; i < loopCount; i++) {
            Category.findByTitle(title);
            assertNotNull(Category.findByTitleAndSubCategory(title, subCategory));
        }
        st.stop();

        System.out.println(st.getTotalTimeSeconds());
        System.out.println(st.prettyPrint());
    }

    @DisplayName("성능 테스트 전체 색인 실패")
    @Test
    void perf_findFail() {
        String title = "유자";
        Category.SubCategory subCategory = Category.SubCategory.D;
        int loopCount = 1000_0000;

        StopWatch st = new StopWatch();
        st.start("title 로 만 검색");
        for (int i = 0; i < loopCount; i++) {
            Category.findByTitle(title);
            assertNull(Category.findByTitle(title));
        }
        st.stop();

        st.start("title & subcategory 로 검색");
        for (int i = 0; i < loopCount; i++) {
            Category.findByTitle(title);
            assertNull(Category.findByTitleAndSubCategory(title, subCategory));
        }
        st.stop();

        System.out.println(st.getTotalTimeSeconds());
        System.out.println(st.prettyPrint());
    }
}