package com.liuxun.dom;

import com.liuxun.service.Status;

public class Programmer extends Employee{
    private String memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
        super();
    }

    public Programmer(int id,String name, int age, double salary,Equipment equipment) {
        super(id,name, age, salary);
        this.equipment = equipment;
    }
    public String getDetailForTeam(){
        return memberId + "/" + getId() +" \t"+getName()+" \t"+getAge() + " \t" +getSalary()+" \t" + "程序员";
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return super.toString()+"\t程序员\t" + status + "\t\t\t\t\t\t" + equipment.getDescription();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
