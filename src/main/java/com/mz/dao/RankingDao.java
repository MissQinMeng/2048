package com.mz.dao;



import com.mz.pojo.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RankingDao extends JpaRepository<Ranking,String>,JpaSpecificationExecutor<Ranking>{

    @Query(value=" select * from ranking order by score  DESC  limit 10 ",nativeQuery=true)
    List<Ranking> findTopByNameOrderByScore();
}
