package com.wang.java_Learning.springKnight;

public class DamselRescueKnight implements Knight{

    private RescueDamselQuest quest;


    public DamselRescueKnight (){
        this.quest=new RescueDamselQuest();
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }


    public static void main(String[] args) {
        DamselRescueKnight damselRescueKnight=new DamselRescueKnight();
        damselRescueKnight.embarkOnQuest();
    }


}
