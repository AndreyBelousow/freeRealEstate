package com.ssau.freerealestate.model.postgresqlModel.repositories;

        import com.ssau.freerealestate.model.postgresqlModel.User;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}

