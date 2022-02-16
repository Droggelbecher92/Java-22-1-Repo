package de.kittlaus.friday2spring.restTemplate;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/{username}")
    public List<GithubUserRepos> getAllReposOfUser(@PathVariable String username){
        return restTemplateService.findAllRepos(username);
    }




}
