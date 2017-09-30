package com.test.design_pattern.builder;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class WithDirector {
}

class Actor{
    private  String Type;
    private int sex;
    private String face;
    private String costume;
    private String hairStyle;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public String getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }
}

//抽象类作为构建者抽象
abstract class ActorBuilder{
    protected Actor actor=new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairStyle();

    public Actor build(){
        return this.actor;
    }
}

class HeroBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        this.actor.setType("hero");
    }

    @Override
    public void buildSex() {
        this.actor.setSex(1);
    }

    @Override
    public void buildFace() {
        this.actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        this.actor.setCostume("盔甲");
    }

    @Override
    public void buildHairStyle() {
        this.actor.setHairStyle("飘逸");
    }

    @Override
    public Actor build() {
        return super.build();
    }
}

class AngleBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        this.actor.setType("天使");
    }

    @Override
    public void buildSex() {
        this.actor.setSex(0);
    }

    @Override
    public void buildFace() {
        this.actor.setFace("漂亮");
    }

    @Override
    public void buildCostume() {
        this.actor.setCostume("白裙");
    }

    @Override
    public void buildHairStyle() {
        this.actor.setHairStyle("披肩长发");
    }

    @Override
    public Actor build() {
        return super.build();
    }
}

class ActorController{
    public Actor construct(ActorBuilder builder){
        builder.buildType();
        builder.buildSex();
        builder.buildCostume();
        builder.buildFace();
        builder.buildHairStyle();

        return builder.build();
    }
}

class Client{
    public static void main(String[] args) {
        ActorController actorController=new ActorController();
        ActorBuilder builder=new HeroBuilder();
        Actor actor=actorController.construct(builder);

        System.out.println(actor.getType());
        System.out.println(actor.getCostume());
    }
}

