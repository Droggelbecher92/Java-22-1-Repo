package de.kittlaus.friday2spring.restTemplate;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestTemplateService {
    public List<GithubUserRepos> findAllRepos(String whichUser) {
        String requestUrl = "https://api.github.com/users/"+whichUser+"/repos";
        RestTemplate template = new RestTemplate();
        ResponseEntity<GithubUserRepos[]> response =  template.getForEntity(requestUrl,GithubUserRepos[].class);
        return Arrays.stream(response.getBody()).toList();
    }

}
