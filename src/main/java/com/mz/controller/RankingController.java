package com.mz.controller;

import com.mz.dto.PageResult;
import com.mz.pojo.Ranking;
import com.mz.dto.Result;
import com.mz.dto.StatusCode;
import com.mz.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	private RankingService rankingService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",rankingService.findAll());
	}
	

	/**
	 * 分页+多条件查询
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	 @RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@PathVariable int page, @PathVariable int size){
		Page<Ranking> pageList = rankingService.getPageSort( page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Ranking>(pageList.getTotalElements(), pageList.getContent()) );
	}


	
	/**
	 * 增加
	 * @param ranking
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Ranking ranking  ){
		rankingService.add(ranking);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	

	
}
