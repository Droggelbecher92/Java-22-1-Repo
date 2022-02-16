package de.kittlaus.java221.restTemplate;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUserRepos that = (GithubUserRepos) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
