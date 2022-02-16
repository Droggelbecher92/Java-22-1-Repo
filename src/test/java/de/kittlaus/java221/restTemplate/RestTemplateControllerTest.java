package de.kittlaus.java221.restTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnAllMyRepos(){
        //GIVEN
        String url = "/rest/droggelbecher92";
        //WHEN
        ResponseEntity<GithubUserRepos[]> actual = testRestTemplate.getForEntity(url, GithubUserRepos[].class);
        //THEN
        assertEquals(HttpStatus.OK,actual.getStatusCode());
        List<GithubUserRepos> actualList = Arrays.stream(actual.getBody()).toList();
        assertTrue(actualList.contains(new GithubUserRepos("Dominion")));
        assertTrue(actualList.contains(new GithubUserRepos("Kirschbaum")));
    }

}