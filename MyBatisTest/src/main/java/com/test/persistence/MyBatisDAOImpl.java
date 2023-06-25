package com.test.persistence;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.MyBatisDTO;


@Repository
public class MyBatisDAOImpl implements MyBatisDAO{
	
	//MyBatisDAO > (의존) > SqlSessionTemplate
	
	@Autowired
	private SqlSessionTemplate template; // 얘! 
	
	public void test() {
		System.out.println(this.template == null );
	}

	@Override
	public void m1() {
		
		//MyBatis(SqlSessionTemplate) > XML 기반 작업(XML Mapper)
		
		/*
		  1. executeUpdate()
		  	- template.insert()
		  	- template.update()
		  	- template.delete()
		  	
		  2. executeQuery()
		  	- template.selectOne()   > 결과셋 레코드 1개 > if(rs.next())
		  	
		  	- template.selectList()  > 결과셋 레코드 N개
		  	  						 > while(rs.next()) {}
		*/
		
		// this.template
		this.template.insert("mybatis.m1");
		// mybatis라는 매퍼에 m1이 있으니 호출시켜줘 
	}

	public void add(MyBatisDTO dto) {
		this.template.insert("mybatis.add", dto);
	}

	@Override
	public int m2(String seq) {
		return this.template.delete("mybatis.m2", seq);
	}

	@Override
	public int m3(Map<String, String> map) {
		return this.template.update("mybatis.m3", map);
	}

	@Override
	public int m4() { // 얘가 인트면 아래도 인트다. 문맥에 맞게 바뀐다. 이게 어레이리스트면 아래도 어레이리스트다.
		
		//SqlSessionTemplate
		// - selectOne()
		// - selectList()
		
		
		return this.template.selectOne("mybatis.m4");
	}

	@Override
	public MyBatisDTO m5(String seq) {
		return this.template.selectOne("mybatis.m5", seq);
	}

	@Override
	public List<String> m6() {
		// String sql = ""
		return this.template.selectList("mybatis.m6");
	}

	@Override
	public List<MyBatisDTO> m7() {
		return this.template.selectList("mybatis.m7");
	}

	@Override
	public int m8(String table) {
		return this.template.selectOne("mybatis.m8", table);
	}

	@Override
	public List<MyBatisDTO> m9(int age) {
		return this.template.selectList("mybatis.m9", age);
	}

	@Override
	public List<MyBatisDTO> m10(String word) {
		return this.template.selectList("mybatis.m10", word);
	}

	@Override
	public int m11(MyBatisDTO dto) {
		int result = this.template.insert("mybatis.m11",dto);
		System.out.println("방금 추가된 PK : " + dto.getSeq());		
		return result;
	}

	@Override
	public List<String> m12(String type) {
		return template.selectList("mybatis.m12", type);
	}

	@Override
	public List<MyBatisDTO> m13(Map<String, String> map) {
		return template.selectList("mybatis.m13", map);
	}

	@Override
	public List<MyBatisDTO> m14(String address) {
		return template.selectList("mybatis.m14", address);
	}

	@Override
	public List<MyBatisDTO> m15(List<String> word) {
		return template.selectList("mybatis.m15", word);
	}
		
}
