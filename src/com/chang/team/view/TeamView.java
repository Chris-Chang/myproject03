package com.chang.team.view;

import com.chang.team.domain.Employee;
import com.chang.team.domain.Programmer;
import com.chang.team.service.NameListService;
import com.chang.team.service.TeamException;
import com.chang.team.service.TeamService;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {

		boolean loopFlag = true;
		char menu = 0;
		while(loopFlag) {
			if(menu != '1') {
				listAllEmployees();
			}
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
			menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N):");
				char isExist = TSUtility.readConfirmSelection();
				if(isExist == 'Y') {
					loopFlag = false;
				}
				break;
			
			}
		}
	}

	/**
	 * 显示所有员工信息
	 * @Description
	 * @author ChangZhi
	 * @date 2020年3月7日上午11:37:47
	 *
	 */
	private void listAllEmployees() {
System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if(employees == null || employees.length == 0) {
			System.out.println("公司中没有任何员工信息!");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for(int i = 0; i< employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * 查看开发团队列表
	 * @Description
	 * @author ChangZhi
	 * @date 2020年3月7日上午11:43:39
	 *
	 */
	private void getTeam() {
System.out.println("\n--------------------------团队成员列表----------------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if(team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员！");
		}else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for(int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println("-------------------------------------------------------------------");

	}

	/**
	 * 添加团队成员
	 * @Description
	 * @author ChangZhi
	 * @date 2020年3月7日上午11:44:25
	 *
	 */
	private void addMember() {
		System.out.println("\n--------------------------添加成员----------------------------\n");
		System.out.print("请输入要添加的员工ID:");
		int id = TSUtility.readInt();
		
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("添加成功");

		} catch (TeamException e) {
			System.out.println("添加失败.原因：" + e.getMessage());
		}
		//按回车继续
		TSUtility.readReturn();
	}

	/**
	 * 删除团队成员
	 * @Description
	 * @author ChangZhi
	 * @date 2020年3月7日上午11:44:56
	 *
	 */
	private void deleteMember() {
		System.out.println("\n--------------------------添加成员----------------------------\n");
		System.out.print("请输入要删除员工的TID：");
		int memberId = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败.原因：" + e.getMessage());
		}
		
		//按回车继续
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
