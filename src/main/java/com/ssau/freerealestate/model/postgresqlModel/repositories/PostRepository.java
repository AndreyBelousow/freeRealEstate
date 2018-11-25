package com.ssau.freerealestate.model.postgresqlModel.repositories;

import com.ssau.freerealestate.model.postgresqlModel.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{

}

