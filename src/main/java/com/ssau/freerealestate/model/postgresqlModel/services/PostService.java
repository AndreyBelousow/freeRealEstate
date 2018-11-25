package com.ssau.freerealestate.model.postgresqlModel.services;

import com.ssau.freerealestate.model.postgresqlModel.Post;

import java.util.List;

public interface PostService {
    void create(Post post);
    void update(Post post);
    void delete(int id);
    void delete(Post post);
    Post getById(int id);
    List<Post> getAll();
}
