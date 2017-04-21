///*
// *    Copyright 2010-2015 the original author or authors.
// *
// *    Licensed under the Apache License, Version 2.0 (the "License");
// *    you may not use this file except in compliance with the License.
// *    You may obtain a copy of the License at
// *
// *       http://www.apache.org/licenses/LICENSE-2.0
// *
// *    Unless required by applicable law or agreed to in writing, software
// *    distributed under the License is distributed on an "AS IS" BASIS,
// *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *    See the License for the specific language governing permissions and
// *    limitations under the License.
// */
//
//package com.iyihua.itimes.mapper;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.iyihua.itimes.model.Item;
//import com.iyihua.model.query.UserItemQueryDTO;
//
///**
// * 
// * @ClassName: SuperItemMapper
// * @Description: SuperItemMapper is for Item complex queries. If need simple crud opration for Item,
// * 	look for ItemMapper or ItemRepository
// * @author: wanglvyh@cf-ec.com
// * @date: 2016年1月11日 上午11:05:33
// */
//@Component
//public class SuperItemMapper {
//
//	@Autowired
//	private SqlSessionTemplate sqlSessionTemplate;
//
//	public Item selectItemById(long id) {
//		return this.sqlSessionTemplate.selectOne("selectItemById", id);
//	}
//	
//	public List<Item> findItemsByParams(UserItemQueryDTO query) {
//		return this.sqlSessionTemplate.selectList("findItemsByParams", query);
//	}
//	
//	public List<Item> listItems(UserItemQueryDTO query) {
//		return this.sqlSessionTemplate.selectList("listItems", query);
//	}
//	
//	public int countItemsByParams(UserItemQueryDTO query) {
//		return this.sqlSessionTemplate.selectOne("countItemsByParams", query);
//	}
//	
//	public int countItems(UserItemQueryDTO query) {
//		return this.sqlSessionTemplate.selectOne("countItems", query);
//	}
//
//}
