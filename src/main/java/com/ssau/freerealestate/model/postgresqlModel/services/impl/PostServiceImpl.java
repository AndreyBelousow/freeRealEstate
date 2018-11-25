package com.ssau.freerealestate.model.postgresqlModel.services.impl;

import com.ssau.freerealestate.model.postgresqlModel.Post;
import com.ssau.freerealestate.model.postgresqlModel.repositories.PostRepository;
import com.ssau.freerealestate.model.postgresqlModel.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public void create(Post post) {
        repository.saveAndFlush(post);
    }

    @Override
    public void update(Post post) {
        repository.saveAndFlush(post);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Post post) {
        repository.delete(post);
    }

    @Override
    public Post getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }
}
