package com.test.designpattern._006;

/**
 * Created by DaiYan on 2017/9/15.
 */
public class Proxy {
    public static Object newInstance(){
        String src=
                "package com.test.designpattern._006;\n" +
                "\n" +
                "/**\n" +
                " * Created by DaiYan on 2017/9/15.\n" +
                " */\n" +
                "public class TimeProxy implements Movable{\n" +
                "    private Movable t;\n" +
                "    public TimeProxy(Movable t){\n" +
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
                "    }"+
                "}";

        return null;
    }
}
