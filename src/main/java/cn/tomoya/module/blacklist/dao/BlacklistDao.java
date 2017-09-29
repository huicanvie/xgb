package cn.tomoya.module.blacklist.dao;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.tomoya.module.blacklist.entity.Blacklist;
import cn.tomoya.module.user.entity.User;

/**
 * 黑名单dao
 */
@Repository
@CacheConfig(cacheNames = "blacklist")
public interface BlacklistDao extends JpaRepository<Blacklist, Integer> {

//	@Query(value = "select a.username userName, b.id, b.user_id from pybbs_blacklist b, pybbs_user a where a.id = b.user_id and b.user_id = ?1", nativeQuery = true)
//	public List getListByUserId(@Param("userId") int userId);
//
//	@Query(value = "select a.username userName, b.id, b.user_id from pybbs_blacklist b, pybbs_user a where a.id = b.user_id /*#pageable*/", countQuery = "select count(*) from pybbs_blacklist", nativeQuery = true)
//	public Page findAll(Pageable pageable);
	
	@Cacheable
	Blacklist findByUserId(int id);

}
