package com.ui.application.application.repository;

import com.ui.application.application.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

    Optional<Authorities> findAuthoritiesByUsername(String username);
}
