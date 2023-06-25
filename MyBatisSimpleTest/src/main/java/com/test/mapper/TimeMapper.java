package com.test.mapper;

import org.apache.ibatis.annotations.Select;

import lombok.extern.log4j.Log4j;

public interface TimeMapper {
	
	@Select("select sysdate from dual")
	public String getTime();
	// log.info(mapper.getTime())
	// XML 매퍼 파일 사용하기
		//log.info(mapper.getTime())
	//}

	public String getTime2();
	

}
