package com.techno.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.persistence.*;

@Component
@Entity
@Table(name="publication")
@Data
public class PublicationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "pubId")
	private Integer pubId;
	
	@Column(name="Title")
	private String pubTitle;
	
	@ManyToOne
    @JoinColumn(name="categoryId")
	private CategoryBean category;
	
	@Column(name="content")
	private String pubContent;

}
