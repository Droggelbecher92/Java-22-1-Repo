package de.kittlaus.java221.restTemplate;

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
