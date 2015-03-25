package de.codecentric.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Developer {

    @Id
    @GeneratedValue
    private Long id;
    
    private String fullname;
    private String githubusername;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGithubusername() {
        return githubusername;
    }


    public void setGithubusername(String githubusername) {
        this.githubusername = githubusername;
    }
    
    @Override
    public String toString() {
        return "Developer [fullname=" + this.fullname + ", githubusername=" + this.githubusername + "]";
    }
}
