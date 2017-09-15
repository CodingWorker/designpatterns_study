package com.test.designpattern._006;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by DaiYan on 2017/9/15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        String src=
                "package com.test.designpattern._006;\n" +
                "\n" +
                "/**\n" +
                " * Created by DaiYan on 2017/9/15.\n" +
                " */\n" +
                "public class TimeProxy2 implements Movable{\n" +
                "    private Movable t;\n" +
                "    public TimeProxy2(Movable t){\n" +
                "        super();\n" +
                "        this.t=t;\n" +
                "    }\n" +
                "\n" +
                "    public void move(){\n" +
                "        long start=System.currentTimeMillis();\n" +
                "        System.out.println(\"startTime:\"+start);\n" +
                "        t.move();\n" +
                "        long end=System.currentTimeMillis();\n" +
                "        System.out.println(\"endTime:\"+end);\n" +
                "        System.out.println(\"timeSpan:\"+(end-start));\n" +
                "    }\n"+
                "}";

        String fileName=System.getProperty("user.dir")+"/src/main/java/com/test/designpattern/_006/TimeProxy2.java";
//        FileWriter fw=new FileWriter(fileName);
//        fw.write(src);
//        fw.flush();
//        fw.close();

        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());//com.sun.tools.javac.api.JavacTool
        StandardJavaFileManager fileManager=compiler.getStandardFileManager(null,null,null);
        //compiler.run(new FileInputStream("f:/TimeProxy.java"),new FileOutputStream("f:/tmp.class"),null);
        Iterable iterator= fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task=compiler.getTask(null,fileManager,null,null,null,iterator);
        task.call();
        fileManager.close();

        //load into memary and create object
        URL[] urls=new URL[]{ new URL("file:/"+System.getProperty("user.dir")+"/src/main/java")};
        URLClassLoader classLoader=new URLClassLoader(urls);
        Class clz=classLoader.loadClass("com.test.designpattern._006.TimeProxy2");
        System.out.println(clz);
        Constructor constructor=clz.getConstructor(Movable.class);
        Movable instance= (Movable) constructor.newInstance(new Car());
        instance.move();
    }
}
