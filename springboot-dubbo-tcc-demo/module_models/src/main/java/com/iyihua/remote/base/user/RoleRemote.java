package com.iyihua.remote.base.user;

import java.util.List;

public interface RoleRemote {

	List<String> findRoleNameByUserId(Long userId);
}
