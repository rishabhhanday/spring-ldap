package com.practice.springldap;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import com.practice.springldap.entry.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;

@SpringBootApplication
@EnableLdapRepositories
public class SpringLdapApplication {

  public static void main(String[] args) {
    final ConfigurableApplicationContext context = SpringApplication
        .run(SpringLdapApplication.class, args);

/*    LdapTemplate ldapTemplate = context.getBean("ldapTemplate", LdapTemplate.class);

    List<User> all = ldapTemplate.findAll(User.class);

    System.out.println(all);

    final UserRepository userRepository = context.getBean("userRepository", UserRepository.class);

    //userRepository.findAll().forEach(System.out::println);

    userRepository.findByUserName("Joe Smeth").forEach(System.out::println);*/

    LdapTemplate ldapTemplate = context.getBean("ldapTemplate", LdapTemplate.class);
    User user = ldapTemplate.findOne(
        query().where("cn").is("Joe Smeth"),User.class
    );

    System.out.println(user);
  }
}
