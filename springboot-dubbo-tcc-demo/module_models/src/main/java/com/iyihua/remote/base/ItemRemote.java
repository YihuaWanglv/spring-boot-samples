package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.ItemDTO;
import com.iyihua.model.base.ItemListDTO;
import com.iyihua.model.component.Page;
import com.iyihua.model.query.UserItemQueryDTO;

public interface ItemRemote {

	List<ItemDTO> findItemsByUserId(Long userId);

	List<ItemDTO> findItemsByQueryParams(UserItemQueryDTO query);

	Page<ItemDTO> findItemsByQueryParamsWithPage(UserItemQueryDTO query);

	ItemDTO saveItem(ItemDTO item);

	void deleteItem(Long itemId);

	ItemListDTO listNext(ItemListDTO itemListDTO);
}
