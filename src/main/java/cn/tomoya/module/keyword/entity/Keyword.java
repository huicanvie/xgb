package cn.tomoya.module.keyword.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 关键字
 * 
 * @author ddppfamily
 *
 */
@Entity
@Table(name = "pybbs_keyword")
public class Keyword implements Serializable {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "keyword")
	private String keyword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
