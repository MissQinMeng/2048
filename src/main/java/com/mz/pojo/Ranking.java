package com.mz.pojo;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="ranking")
public class Ranking implements Serializable{

	@Id
	private String r_id;//排行榜id


	
	private String name;//姓名
	private String addr;//所在地区
	private String score;//得分

	
	public String getR_id() {		
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {		
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getScore() {		
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}


	
}
