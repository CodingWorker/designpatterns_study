package com.test.design_pattern.prototype;

import java.io.*;

/**
 * Created by IntelliJ IDEA
 * Project: NotesDemo
 * User: DaiYan
 * Date: 2017/9/30
 */
public class SerializeToClone {
}

class MemberClass implements Serializable{

}

class Prototype implements Serializable {
    private MemberClass memberClass;

    public Prototype deepClone() {
        Prototype prototype = null;
        try {
            //serialize
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this);
            //deep clone
            ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            prototype = (Prototype) ois.readObject();

            return prototype;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return prototype;
    }
}
