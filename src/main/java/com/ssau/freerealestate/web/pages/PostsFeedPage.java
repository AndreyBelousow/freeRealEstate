package com.ssau.freerealestate.web.pages;

import com.ssau.freerealestate.model.postgresqlModel.Post;
import com.ssau.freerealestate.model.postgresqlModel.services.PostService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route(value="feed")
public class PostsFeedPage extends VerticalLayout {

    private final PostService repo;

    final Grid<Post> grid;

    final TextField filter;

    private final Button addNewBtn;

    public PostsFeedPage(PostService repo) {
        this.repo = repo;
        this.grid = new Grid<>(Post.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New post", VaadinIcon.PLUS.create());
        // build layout
        this.setSizeFull();
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);

        grid.setSizeFull();

        grid.setColumns("date", "views");
        grid.addColumn(post -> post.getRealEstate().getInfo()).setHeader("Description");
        grid.addComponentColumn(person -> {
            Button button = new Button("Click me!");
            button.addClickListener(click ->
            {button.getUI().ifPresent(ui -> ui.navigate("post/1"));});
            return button;
        });

        //grid.addColumn("date");
        //grid.addColumn("views");
        grid.getColumnByKey("date").setWidth("200px").setFlexGrow(0);
        grid.getColumnByKey("views").setWidth("80px").setFlexGrow(0);
        add(grid);

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> displayAllPosts(e.getValue()));

        // Initialize listing
        displayAllPosts(null);
    }

    // tag::displayAllPosts[]
    private void displayAllPosts(String filterText) {
        // if (StringUtils.isEmpty(filterText)) {
        grid.setItems(repo.getAll());
       /* } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }*/
    }

}
