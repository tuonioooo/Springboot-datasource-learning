package com.datasouce;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class SpringbootDatasouce2XApplicationTests {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("cloudJdbcTemplate")
	private JdbcTemplate cloudJdbcTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDatasource(){
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from cc_material_items limit 0,10");
		log.info("result.size() = " + result.size());
	}

	@Test
	public void testCloudDatasource(){
		List<Map<String, Object>> result = cloudJdbcTemplate.queryForList("select * from cc_material_items limit 0,10");
		log.info("result.size() = " + result.size());
	}

}
