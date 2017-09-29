package cn.tomoya.module.blacklist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tomoya.module.blacklist.dao.BlacklistDao;
import cn.tomoya.module.blacklist.entity.Blacklist;
import cn.tomoya.module.label.entity.Label;
import cn.tomoya.module.user.entity.User;

/**
 * 黑名单
 * 
 * @author ddppfamily
 */
@Service
@Transactional
public class BlacklistService {

	@Autowired
	private BlacklistDao blacklistDao;
	
	public Page findAll(int p, int size) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "user_id"));
		Pageable pageable = new PageRequest(p - 1, size, sort);
		return blacklistDao.findAll(pageable);
	}

	public Blacklist findByUserId(User user) {
		return blacklistDao.findByUserId(user.getId());
	}
	
	public void save(User user) {
		blacklistDao.save(user);
	}

}
