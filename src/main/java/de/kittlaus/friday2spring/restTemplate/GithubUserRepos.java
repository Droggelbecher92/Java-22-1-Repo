package de.kittlaus.friday2spring.restTemplate;

public class GithubUserRepos {

    private String name;

    public GithubUserRepos(String name) {
        this.name = name;
    }

    public GithubUserRepos() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
