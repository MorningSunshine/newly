package org.my.framework.repo;

import org.my.framework.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Integer> {

}
