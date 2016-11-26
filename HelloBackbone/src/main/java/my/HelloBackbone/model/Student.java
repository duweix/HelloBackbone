package my.HelloBackbone.model;

import com.jfinal.plugin.activerecord.Model;

public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    public static final Student dao = new Student();
}
