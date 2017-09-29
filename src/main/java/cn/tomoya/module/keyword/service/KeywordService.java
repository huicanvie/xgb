package cn.tomoya.module.keyword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tomoya.module.keyword.dao.KeywordDao;
import cn.tomoya.module.keyword.entity.Keyword;

/**
 * 关键字
 * @author ddppfamily
 */
@Service
@Transactional
public class KeywordService {

  @Autowired
  private KeywordDao keywordDao;

  /**
   * search user by score desc
   *
   * @param p
   * @param size
   * @return
   */
  public Page<Keyword> findByScore(int p, int size) {
    Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "score"));
    Pageable pageable = new PageRequest((p - 1) * size, size, sort);
    return keywordDao.findAll(pageable);
  }

  public void save(Keyword blacklist) {
    keywordDao.save(blacklist);
  }

  /**
   * 分页查询用户列表
   *
   * @param p
   * @param size
   * @return
   */
  public Page<Keyword> pageUser(int p, int size) {
    Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "inTime"));
    Pageable pageable = new PageRequest(p - 1, size, sort);
    return keywordDao.findAll(pageable);
  }

 
}
