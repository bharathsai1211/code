package com.stackroute.userauthetication.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stackroute.userauthentication.model.UserDao;
import com.stackroute.userauthentication.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
	@Autowired
	private UserRepository repo;
	@Test
	public void add()
	{
		UserDao user=new UserDao();
		UserDao retu=repo.save(user);
		assertEquals(retu.getEmail(),user.getEmail());
	}

}
