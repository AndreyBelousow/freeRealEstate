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

@Route("authorisation")
public class LoginPage extends VerticalLayout {

    private TextField loginField;
    private TextField passwordField;
    private UserService repo;

    private final Button loginBtn;
    private final Button registerBtn;

    public LoginPage(UserService repo) {
        this.repo = repo;
        this.loginBtn = new Button("Log in", VaadinIcon.ENTER.create());
        loginBtn.addClickListener(e -> tryLogIn());
        this.registerBtn = new Button("Create account", VaadinIcon.ENTER.create());
        registerBtn.addClickListener(e -> {loginBtn.getUI().ifPresent(ui -> ui.navigate("register"));});

        FormLayout nameLayout = new FormLayout();

        loginField = new TextField();
        loginField.setLabel("Username");
        loginField.setPlaceholder("Sir");
       /* TextField firstNameField = new TextField();
        firstNameField.setLabel("First name");
        firstNameField.setPlaceholder("John");*/
        passwordField = new TextField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Doe");

        nameLayout.add(loginField, passwordField, loginBtn, registerBtn);

        nameLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("21em", 2),
                new FormLayout.ResponsiveStep("22em", 3));

        add(nameLayout);
    }

    private void tryLogIn(){
        String login = loginField.getValue();
        String pass = passwordField.getValue();

        User current = null;
        List<User> users = repo.getAll();
        for (User user:users) {
            if(user.getUsername().equals(login)) {
                current = user;
                break;
            }
        }
        if(current==null){
            Notification.show(String.format("Invalid username %s, try again", login));
            return;
        }
        if(!current.getPassword().equals(pass)){
            Notification.show("Invalid password");
            return;
        }
        loginBtn.getUI().ifPresent(ui -> ui.navigate("feed"));
    }
}
