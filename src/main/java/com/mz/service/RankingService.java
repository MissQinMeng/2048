package com.mz.service;



import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.mz.dao.RankingDao;
import com.mz.pojo.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RankingService {

	@Autowired
	private RankingDao rankingDao;
	


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Ranking> findAll() {
		return rankingDao.findTopByNameOrderByScore();
	}

	
	/**
	 * 条件查询+分页
	 *
	 * @return
	 */
      public Page<Ranking> getPageSort(int page, int size) {
		Sort sort = new Sort(Sort.Direction.DESC,"score");
		  PageRequest pageRequest =  PageRequest.of(page-1, size,sort);
		  return rankingDao.findAll(pageRequest);

	}




	/**
	 * 增加
	 * @param ranking
	 */
	public void add(Ranking ranking) {
		String uuid = UUID.randomUUID().toString();
		uuid=uuid.replace("-", "");
		ranking.setR_id(uuid);
		rankingDao.save(ranking);
	}



}
