module Aims {
	exports hust.soict.globalict.aims;
	exports hust.soict.globalict.aims.screen.customer.controller;
	exports hust.soict.globalict.aims.cart;
	exports hust.soict.program.test.screen.customer.store;
	exports hust.soict.globalict.aims.exception;
	exports hust.soict.globalict.aims.screen.manager;
	exports hust.soict.globalict.aims.store;
	exports hust.soict.globalict.aims.media;

	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.naming;
	requires javafx.swing;
	opens hust.soict.globalict.aims.screen.customer.controller to javafx.fxml;
}