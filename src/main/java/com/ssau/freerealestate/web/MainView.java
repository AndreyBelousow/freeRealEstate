package com.ssau.freerealestate.web;

import com.ssau.freerealestate.model.postgresqlModel.User;
import com.ssau.freerealestate.model.postgresqlModel.repositories.UserRepository;
import com.ssau.freerealestate.model.postgresqlModel.services.UserService;
import com.ssau.freerealestate.web.entityEditors.UserEditor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

//@Route
public class MainView extends VerticalLayout {

    private final UserService repo;

    private final UserEditor editor;

    final Grid<User> grid;

    final TextField filter;

    private final Button addNewBtn;

    NativeButton button = new NativeButton("Navigate to company");


    public MainView(UserService repo, UserEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(User.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());

        button.addClickListener( e-> {
            button.getUI().ifPresent(ui -> ui.navigate("feed"));
        });
        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn, button);
        add(actions, grid, editor);

        grid.setHeight("300px");
        grid.setColumns("id", "username", "password", "token", "role");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editCustomer(new User()));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(filter.getValue());
        });

        // Initialize listing
        listCustomers(null);
    }

    // tag::listCustomers[]
    void listCustomers(String filterText) {
       // if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.getAll());
       /* } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }*/
    }
// end::listCustomers[]
}