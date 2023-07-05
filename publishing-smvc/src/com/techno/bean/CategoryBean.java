package com.techno.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name="category")
@Data
public class CategoryBean {
	
	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer categoryId;
	
	@Column(name="categoryName")
	private String categoryName;

}
