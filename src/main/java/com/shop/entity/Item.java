package com.shop.entity;


import com.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity   //item클래스를 entity로 선언
@Table(name = "item")  //@Table 어노테이션으로 어떤 테이블과 매핑될지 지정, item테이블과 매핑되로고 name를 item으로 지정
@Getter
@Setter
@ToString
public class Item {



    @Id  //기본키가 되는 멤버변수에 선언을 해줘야한다.
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  //상품코드

    @Column(nullable = false, length = 50)
    private String itemNm;  //상품명

    @Column(name = "price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태

    private LocalDateTime regTime; //등록시간

    private LocalDateTime updateTime; //수정시간

}
