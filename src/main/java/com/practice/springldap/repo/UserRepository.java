package com.practice.springldap.repo;

import com.practice.springldap.entry.User;
import java.util.List;
import org.springframework.data.ldap.repository.LdapRepository;

public interface UserRepository extends LdapRepository<User> {

  List<User> findByUserName(String userName);
}
