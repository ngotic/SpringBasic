package com.test.persistence;

import java.util.List;
import java.util.Map;

import com.test.domain.MyBatisDTO;

public interface MyBatisDAO {
	void test();

	void m1();

	void add(MyBatisDTO dto);
	
	int m2(String seq);

	int m3(Map<String, String> map);

	int m4();

	MyBatisDTO m5(String seq);

	List<String> m6();

	List<MyBatisDTO> m7();

	int m8(String table);

	List<MyBatisDTO> m9(int age);

	List<MyBatisDTO> m10(String word);

	int m11(MyBatisDTO dto);

	List<String> m12(String type);

	List<MyBatisDTO> m13(Map<String, String> map);

	List<MyBatisDTO> m14(String address);

	List<MyBatisDTO> m15(List<String> word);
	

}
