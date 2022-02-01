package com.liuxun.service;

import com.liuxun.dom.Architect;
import com.liuxun.dom.Designer;
import com.liuxun.dom.Employee;
import com.liuxun.dom.Programmer;

public class TeamService {
    private static int counter =1; //给memberID 赋值
    private final int MAX_MEMBWE = 5;
    private Programmer[] team = new Programmer[MAX_MEMBWE];
    private int total = 0; //记录开发人数

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return  team;
    }
    public void addMember(Employee e) throws TeamException {
        if(total >= MAX_MEMBWE){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if(isExist(e)){
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p = (Programmer) e;
        if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该员工已在其他团队");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假");
        }
        int numOfArch =0,numOfDes = 0,numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        if(p instanceof Architect){
            if(numOfArch >=1){
                throw new TeamException("团队中只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(numOfDes >= 2){
                throw new TeamException("团队中只能有两名设计师");
            }
        }else if(p instanceof Programmer){
            if(numOfPro >= 3){
                throw new TeamException("团队中只能有三名程序员");
            }
        }
        p.setStatus(Status.BUSY);
        p.setMemberId(String.valueOf(counter++));
        team[total++] = p;

    }
    public void removeMember(int memberId) throws TeamException {
        int i=0;
        for (i = 0; i < total; i++) {
            if(team[i].getMemberId().equals(String.valueOf(memberId))){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i>=total){
            throw new TeamException("未找到memberid指定的成员，删除失败");
        }
        for (int j = i+1; j < total; j++) {
            team[j-1] = team[j];
        }
        team[--total] = null;
    }
    private boolean isExist(Employee e){
        for (int i = 0; i < total; i++) {
            return team[i].getId() == e.getId();
        }
        return false;
    }
}
