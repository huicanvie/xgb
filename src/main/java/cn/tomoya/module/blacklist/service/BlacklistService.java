package cn.tomoya.module.blacklist.service;

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

/**
 * 黑名单
 * @author ddppfamily
 */
@Service
@Transactional
public class BlacklistService {

  @Autowired
  private BlacklistDao blacklistDao;

  /**
   * search user by score desc
   *
   * @param p
   * @param size
   * @return
   */
  public Page<Blacklist> findByScore(int p, int size) {
    Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "score"));
    Pageable pageable = new PageRequest((p - 1) * size, size, sort);
    return blacklistDao.findAll(pageable);
  }

  public List<Blacklist> findById(int id) {
//    return blacklistDao.findOne(id);
	  return blacklistDao.getListByUserId(id);
  }

  public void save(Blacklist blacklist) {
    blacklistDao.save(blacklist);
  }

  /**
   * 分页查询用户列表
   *
   * @param p
   * @param size
   * @return
   */
  public Page<Blacklist> pageUser(int p, int size) {
    Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
    Pageable pageable = new PageRequest(p - 1, size, sort);
    return blacklistDao.findAll(pageable);
  }

 
}
