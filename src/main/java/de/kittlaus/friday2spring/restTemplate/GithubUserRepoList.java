package de.kittlaus.friday2spring.restTemplate;

import java.util.List;

public class GithubUserRepoList {

    private List<GithubUserRepos> allrepos;

    public GithubUserRepoList(List<GithubUserRepos> allrepos) {
        this.allrepos = allrepos;
    }

    public GithubUserRepoList() {
    }

    public List<GithubUserRepos> getAllrepos() {
        return allrepos;
    }

    public void setAllrepos(List<GithubUserRepos> allrepos) {
        this.allrepos = allrepos;
    }
}
