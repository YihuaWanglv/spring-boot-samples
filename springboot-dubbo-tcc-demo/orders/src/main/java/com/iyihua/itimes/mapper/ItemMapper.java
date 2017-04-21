//
//package com.iyihua.itimes.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Select;
//
//import com.iyihua.itimes.model.Item;
//
//
//
///**
// * @author iyihua
// */
//public interface ItemMapper {
//
//	// @Select("select * from items where state = #{state}")
//	// City findByState(@Param("state") String state);
//	@Select("select * from item")
//	List<Item> findAll();
//	
////	@SelectProvider(type = SampleProvider.class,  
////            method = "findUserByParams") 
////	List<Item> findItemsByParams(@Param("item")Item item);
//	
//
//}
