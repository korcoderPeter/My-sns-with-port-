package com.peter.myport.sns;

import java.math.BigDecimal;
import java.util.Date;

public class Sns {

	private BigDecimal sns_no;
	private String writer;
	private String title;
	private String content;
	private Date when;
	
	public Sns() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getSns_no() {
		return sns_no;
	}

	public void setSns_no(BigDecimal sns_no) {
		this.sns_no = sns_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public Sns(BigDecimal sns_no, String writer, String title, String content, Date when) {
		super();
		this.sns_no = sns_no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.when = when;
	}


	
	
	
}
