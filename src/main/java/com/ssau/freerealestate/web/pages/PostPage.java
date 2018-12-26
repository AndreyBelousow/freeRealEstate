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
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value="post")
public class PostPage extends VerticalLayout implements HasUrlParameter<String> {

    private final PostService repo;

    final Grid<Post> grid;

    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {
        displayAllPosts(1);
    }

    public PostPage(PostService repo){
        this.repo = repo;
        this.grid = new Grid<>(Post.class);

        this.setSizeFull();
        /*HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
*/
        grid.setSizeFull();

        grid.setColumns("date", "views");

        //grid.addColumn("date");
        //grid.addColumn("views");
        grid.getColumnByKey("date").setWidth("200px").setFlexGrow(0);
        grid.getColumnByKey("views").setWidth("80px").setFlexGrow(0);
        add(grid);

        // Initialize listing
        //displayAllPosts(null);
    }

    // tag::displayAllPosts[]
    private void displayAllPosts(int id) {
        // if (StringUtils.isEmpty(filterText)) {
        grid.setItems(repo.getById(id));
       /* } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }*/
    }
}
