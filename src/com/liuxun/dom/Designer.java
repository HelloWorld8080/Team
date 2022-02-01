package com.liuxun.dom;

import com.liuxun.service.Status;

public class Designer extends Programmer{
    private double bonus;

    @Override
    public String getDetailForTeam(){
        return getMemberId() + "/" + getId()
                +" \t"+getName()
                +" \t"+getAge()
                + " \t" +getSalary()
                +" \t" + "设计师"
                +" \t" +getBonus();
    }
    @Override
    public String toString() {
        return getDescription() + "\t设计师\t" + getStatus() + " \t" + bonus+"\t\t\t\t" +getEquipment().getDescription();
    }

    public Designer(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
