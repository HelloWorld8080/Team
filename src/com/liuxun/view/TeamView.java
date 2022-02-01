package com.liuxun.view;

import com.liuxun.dom.Employee;
import com.liuxun.dom.Programmer;
import com.liuxun.service.NameListService;
import com.liuxun.service.TeamException;
import com.liuxun.service.TeamService;
import com.liuxun.util.TSUtility;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();
    public void enterMainMenu(){
        boolean loop = true;
        char menu = '0';
        while (loop) {
            if (menu!='1') {
                 listAllEmployee();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu){
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
                    System.out.println("是否确认退出（Y/N）");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        loop = false;
                    }
                    break;

            }
        }
    }
    public void listAllEmployee(){

        System.out.println("--------------------------------开发团队调度软件------------------------");
        Employee[] employees = listSvc.getAllEmployee();
        if(employees == null && employees.length ==0){
            System.out.println("公司中没有任何员工信息");
        }else{
            System.out.println("ID\t姓名 \t年龄 \t 工资 \t职位 \t状态 \t奖金 \t股票 \t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println( employees[i]);
            }

        }
        System.out.println("-------------------------------------------------------------------------");


    }
    private void getTeam(){
        System.out.println("-------------------------------开发成员列表-----------------------------");
        Programmer[] team = teamSvc.getTeam();
        if(team == null || team.length == 0){
            System.out.println("开发团队中没有成员");
        }else{
            System.out.println("TID/ID\t姓名 \t年龄 \t工资 \t职位 \t奖金 \t股票");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailForTeam());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }
    private void addMember(){
        System.out.println("--------------------------添加成员----------------");
        System.out.println("请输入员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
            TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        //回车继续

    }
    private void deleteMember(){

        System.out.println("--------------------------删除成员----------------");
        System.out.println("请输入员工memberID：");
        int memberID = TSUtility.readInt();

        try {
            teamSvc.removeMember(memberID);
            System.out.println("删除成功");
            TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args){
        TeamView view = new TeamView();
        view.enterMainMenu();

    }
}
