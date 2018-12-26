package com.ssau.freerealestate.web.pages;

import com.ssau.freerealestate.model.postgresqlModel.User;
import com.ssau.freerealestate.model.postgresqlModel.services.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("register")
public class RegisterPage extends VerticalLayout {

    private TextField loginField;
    private TextField passwordField;
    private UserService repo;

    private final Button addNewBtn;

    public RegisterPage(UserService repo) {
        this.repo = repo;
        this.addNewBtn = new Button("Create account", VaadinIcon.ENTER.create());
        addNewBtn.addClickListener(e -> CreateUser());

        FormLayout nameLayout = new FormLayout();

        loginField = new TextField();
        loginField.setLabel("Username");
        loginField.setPlaceholder("username");
       /* TextField firstNameField = new TextField();
        firstNameField.setLabel("First name");
        firstNameField.setPlaceholder("John");*/
        passwordField = new TextField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("1337");

        nameLayout.add(loginField, passwordField, addNewBtn);

        nameLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("21em", 2),
                new FormLayout.ResponsiveStep("22em", 3));

        add(nameLayout);
    }

    private void CreateUser(){
        String login = loginField.getValue();
        String pass = passwordField.getValue();

        User current = new User();
        current.setRole("user");
        current.setUsername(login);
        current.setPassword(pass);

        repo.create(current);
        Notification.show("Success");

        addNewBtn.getUI().ifPresent(ui -> ui.navigate("feed"));
    }
}
