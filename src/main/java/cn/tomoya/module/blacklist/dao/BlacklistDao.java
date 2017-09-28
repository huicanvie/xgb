package cn.tomoya.module.blacklist.dao;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.tomoya.module.blacklist.entity.Blacklist;

/**
 * 黑名单dao
 */
@Repository
@CacheConfig(cacheNames = "blacklist")
public interface BlacklistDao extends JpaRepository<Blacklist, Integer> {

  @Cacheable
  Blacklist findOne(int id);

  @CacheEvict
  void delete(int id);
  
  @Query("select b from Blacklist b where b.user_id=:userId")
  public List<Blacklist> getListByUserId(@Param("userId") int userId);
  
  @Query("select b from Blacklist b")
  public Page<Blacklist> findAll(Pageable pageable);
}
