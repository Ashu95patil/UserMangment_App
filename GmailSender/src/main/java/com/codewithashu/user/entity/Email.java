package com.codewithashu.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
	
	private Integer id;
	
	private String to;
	
	private String from;
	
	private String subject;
	
	private String text;
	
	private String content;
	
	

}
