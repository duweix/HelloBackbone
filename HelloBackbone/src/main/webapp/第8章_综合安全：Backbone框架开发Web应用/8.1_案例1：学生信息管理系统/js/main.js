require.config({
	paths: {
		"underscore": "/js/underscore-1.8.3.min",
		"jquery": "/js/jquery-3.1.1.min",
		"json2": "/js/json2",
		"backbone": "/js/backbone-1.3.3.min",
		"css": "/js/css.min",
		"app": "application"
	},
	map: {
		"*": ["css"]
	},
	shim: {
		"backbone": ["underscore", "jquery", "json2"],
		"app": ["backbone", "css!../css/student.css"]
	}
});
require(["app"], function () {
	// window.alert(g_AppMain);
});