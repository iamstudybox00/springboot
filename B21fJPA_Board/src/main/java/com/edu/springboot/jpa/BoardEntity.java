package com.edu.springboot.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name="jpaboard")
public class BoardEntity
{
	@Id
	@SequenceGenerator(
		name = "mySequence",
		sequenceName = "jpaboard_seq",
		initialValue = 1,
		allocationSize = 1)
	@GeneratedValue(generator = "mySequence")
	private Long id;
	private String name;
	private String title;
	private String contents;
	private String password;
	private Long hits;
	@Column(columnDefinition = "DATE DEFAULT SYSDATE")
	private LocalDateTime postdate;
	
	@PrePersist
	protected void onPrePersist()
	{
		this.postdate = LocalDateTime.now();
		if(this.hits == null)
		{
			this.hits = 0L;
		}
	}
}
