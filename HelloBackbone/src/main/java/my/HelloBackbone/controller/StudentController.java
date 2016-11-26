package my.HelloBackbone.controller;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;

import my.HelloBackbone.model.Student;

public class StudentController extends Controller {

    public void save() throws Exception {

    }

    public void fetch() {
        String strCode = getPara();
        Object obj = null;
        if (strCode != null)
            obj = Student.dao.findById(strCode);
        else
            obj = Student.dao.find("SELECT Code, Name, Score FROM student ORDER BY Code ASC");

        renderJson(obj);
    }

    public void destroy() {

    }

    public void create() {
        String strJSON = getPara("model");
        JSON objJSON = JSON.parseObject(strJSON);

        @SuppressWarnings("unchecked")
        Student stu = Student.dao.put(JSON.toJavaObject(objJSON, Map.class));
        Boolean blnSaveState = stu.save();

        Map<String, String> mapRtn = new HashMap<String, String>();
        mapRtn.put("Code", blnSaveState ? "0" : "1");
        renderJson(JSON.toJSONString(mapRtn));
    }
}
