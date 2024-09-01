package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item,Long> {

   //itemNm상품명으로 데이터를 조회하기 위해서 By 뒤에 필드명이 ItemNm을 메소드의 이름에 붙임
   // 매개변수로는 검색할 때 사용할  상품명 변수를 넘겨줌
   List<Item> findByItemNm(String itemNm);

   //상품명과 상품상세설명을  or조건을 이용하여 조회하는 쿼리메소드
   List<Item> findByItemNmOrItemDetail(String itemNm,String itemDetail);


   //파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리메소드
   List<Item> findByPriceLessThan(Integer price);

   //
   List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

   @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
   List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);


   //value안에 네이티비 쿼리문을 작성하고 nativeQuery=true를 지정
   @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc",nativeQuery = true)
   List<Item> findByItemDetailByNative(@Param("itemDetail")String itemDetail);
}
