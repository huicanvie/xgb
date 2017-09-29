package cn.tomoya.module.keyword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tomoya.module.blacklist.entity.Blacklist;
import cn.tomoya.module.keyword.dao.KeywordDao;
import cn.tomoya.module.keyword.entity.Keyword;

/**
 * 关键字
 * 
 * @author ddppfamily
 */
@Service
@Transactional
public class KeywordService {

	@Autowired
	private KeywordDao keywordDao;

	public void save(Keyword keyword) {
		keywordDao.save(keyword);
	}

	public Page<Keyword> findAll(int p, int size) {
		Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));
		Pageable pageable = new PageRequest(p - 1, size, sort);
		return keywordDao.findAll(pageable);
	}

	public Keyword findById(Integer id) {
		return keywordDao.findById(id);
	}

	public void delete(Keyword keyword) {
		keywordDao.delete(keyword);
	}

	@CacheEvict("keyword")
	public void clearCache() {
	}
}
