package com.edu.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO
{
	private int idx;
	private String userid;
	private String title;
	private String content;
}
