module Exam_Java_Project {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	 
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens controller to javafx.fxml;
	opens Ma.project.Beans to javafx.fxml;
	exports Ma.project.Beans;
}
