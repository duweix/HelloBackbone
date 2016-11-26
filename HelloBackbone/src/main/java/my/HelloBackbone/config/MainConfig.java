package my.HelloBackbone.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

import my.HelloBackbone.controller.StudentController;
import my.HelloBackbone.model.Student;

public class MainConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
	    me.setDevMode(true);
	}

	@Override
	public void configHandler(Handlers me) {

	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configPlugin(Plugins me) {
	    DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/hellojqgrid?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC", "root", "sy_12345");
	    dp.setDriverClass("com.mysql.cj.jdbc.Driver");
	    me.add(dp);

	    ActiveRecordPlugin ar = new ActiveRecordPlugin(dp);
	    me.add(ar);

	    ar.addMapping("student", "Code", Student.class);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/student", StudentController.class);
	}

}
