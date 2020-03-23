package com.chang.team.junit;

import org.junit.jupiter.api.Test;

import com.chang.team.domain.Employee;
import com.chang.team.service.NameListService;
import com.chang.team.service.TeamException;

/**
 * 对NameListService类的测试
 * 
 * @Description TODO
 * @author ChangZhi Email:chriszchang@163.com
 * @version
 * @date 2020年3月6日下午8:31:06
 *
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 120;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}

}
