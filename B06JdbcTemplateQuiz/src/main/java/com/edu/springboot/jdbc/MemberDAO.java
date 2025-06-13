package com.edu.springboot.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.edu.springboot.B06JdbcTemplateQuizApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements IMemberService
{

    private final B06JdbcTemplateQuizApplication b06JdbcTemplateQuizApplication;
	@Autowired
	private JdbcTemplate jdbcTemplate;

    MemberDAO(B06JdbcTemplateQuizApplication b06JdbcTemplateQuizApplication) {
        this.b06JdbcTemplateQuizApplication = b06JdbcTemplateQuizApplication;
    }
	
//	@Override
//	public List<MemberDTO> select()
//	{
//		String sql = "SELECT * FROM member "
//				+ " ORDER BY regidate DESC ";
//		
//		return jdbcTemplate.query(sql, 
//				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
//	}
	
	@Override
	public List<MemberDTO> select(MemberDTO memberDTO)
	{
		String sql = "SELECT * FROM member ";
		
		if(memberDTO.getSearchKeyword() != null && 
				!memberDTO.getSearchKeyword().equals(""))
		{
			sql += "WHERE " + memberDTO.getSearchField() + " LIKE '%" + memberDTO.getSearchKeyword() + "%'";	
		}
		sql += " ORDER BY regidate DESC ";
		System.out.println(sql);
		
		return jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	@Override
	public int insert(MemberDTO memberDTO)
	{
		int result = jdbcTemplate.update(new PreparedStatementCreator()
		{
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				String sql = "INSERT INTO member (id, pass, name) "
						+ " VALUES (?, ?, ?) ";
				
				PreparedStatement psmt = con.prepareStatement(sql);
				
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPass());
				psmt.setString(3, memberDTO.getName());
				
				return psmt;
			}
		});
		return result;
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO)
	{
		String sql = "SELECT * FROM member WHERE id=?";
		memberDTO = jdbcTemplate.queryForObject(sql,
				new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),
				new Object[] { memberDTO.getId() });
		return memberDTO;
	}

	@Override
	public int update(MemberDTO memberDTO)
	{
		String sql = "UPDATE member SET pass=?, name=? WHERE id=?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement ps) throws SQLException
			{
				ps.setString(1, memberDTO.getPass());
				ps.setString(2, memberDTO.getName());
				ps.setString(3, memberDTO.getId());
			}
		});
		return result;
	}

	@Override
	public int delete(MemberDTO memberDTO)
	{
		String sql = "DELETE FROM member WHERE id=?";
		int result = jdbcTemplate.update(sql,
				new Object[] {memberDTO.getId()});
		return result;
	}
}
