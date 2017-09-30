package com.test.design_pattern.builder;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class WithoutDirector {
}

abstract class ActorBuilder2 {
    private Actor actor;

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairStyle();

    public Actor construct(){
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairStyle();

        return this.actor;
    }
}
