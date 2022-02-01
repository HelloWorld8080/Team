package com.liuxun.dom;

import com.liuxun.service.Status;

public class Architect extends Designer{
    private double stack;
    public Architect(double bonus) {
        super(bonus);
        this.stack = stack;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, double stack) {
        super(id, name, age, salary, equipment, bonus);
        this.stack = stack;
    }

    public String getDetailForTeam(){
        return getMemberId() + "/" + getId()
                +" \t"+getName()
                +" \t"+getAge()
                + " \t" +getSalary()
                +" \t" + "架构师"
                +" \t" +getBonus()
                +" \t" + getStack();
    }
    @Override
    public String toString() {
        return getDescription() + "\t架构师\t" + getStatus() + "\t" + getBonus() + " \t" + getStack() + " \t" + getEquipment().getDescription();
    }

    public double getStack() {
        return stack;
    }

    public void setStack(double stack) {
        this.stack = stack;
    }
}
