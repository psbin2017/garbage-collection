package com.collection.gc.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * https://woowacourse.github.io/javable/2020-05-08/First-Class-Collection
 */
public class FirstCollectionSample {

    @DisplayName("라이언의 전자지갑에서 카카오 카드를 찾다")
    @Test
    public void findCardByName_NameKakao_Find() {
        
        List<Card> cards = new ArrayList<Card>();
        cards.add( new Card("카카오", 100000L ) );
        cards.add( new Card("비자", 300000L ) );
        
        ElectronicWallet wallet = new ElectronicWallet( "라이언", new Cards(cards) );

        String expect = "카카오";
        assertEquals( expect, wallet.findCardByName("카카오").getName() );
    }
    
}

@Getter
@AllArgsConstructor
class ElectronicWallet {
    private String userName;
    private Cards cards;
    // ...

    public Card findCardByName(String name) {
        return cards.findCardByName(name);
    }
}

/**
 * 일급 객체
 */
class Cards {
    private List<Card> cards;

    public Cards(List<Card> cards) {
        validateSize(cards);
        this.cards = cards;
    }

    /**
     * 컬렉션 멤버 변수의 불변성을 보장
     */
    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public Card findCardByName(String name) {
        return cards.stream()
                    .filter(e -> name.equals(e.getName()) )
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
    }

    private void validateSize(List<Card> cards) {
        if ( cards.size() > 10 ) {
            throw new IllegalArgumentException("카드는 최대 10개까지 입니다.");
        }
    }
}

@Getter
@AllArgsConstructor
class Card {
    private String name;
    private long limitAmount;
    // ...
}