package cn.tomoya.module.keyword.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.tomoya.module.keyword.entity.Keyword;

/**
 * 关键字dao
 */
@Repository
@CacheConfig(cacheNames = "keyword")
public interface KeywordDao extends JpaRepository<Keyword, Integer> {

	@Cacheable
	Keyword findById(int id);

}
