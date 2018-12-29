package ua.com.owu.spring_boot_third_try.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.owu.spring_boot_third_try.models.User;

@Repository
public interface UserDAO extends JpaRepository <User, Integer> {
}
