package com.stackroute.favouriteservice.repository;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.favouriteservice.domain.Match;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class MatchRepositoryTest {
	@Autowired
	private transient MatchRepository repo;

	public void setRepo(MatchRepository repo) {
		this.repo = repo;
	}

	@Test
	public void testSavematch() throws Exception {
		repo.save(new Match(1, "India vs Pakistan","12345", "rohithakalla@gmail.com"));
		final Match match = repo.getOne(1);
		assertThat(match.getId()).isEqualTo(1);
	}



	@Test
	public void testGetMymatchs() throws Exception {
		repo.save(new Match(1, "India vs Pakistan","12345", "rohithakalla@gmail.com"));
		repo.save(new Match(2, "India vs Aus","123456", "rohithakalla@gmail.com"));
		final List<Match> matches = repo.findByUserId("rohithakalla@gmail.com");
		assertEquals("12345", matches.get(0).getUniqueId());
	}

}
