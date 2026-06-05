package com.slide1.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Views")
    private Integer views;

    public Video(){}

    public Video(String title, String poster, String description, Boolean active, Integer views){
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.active = active;
        this.views = views;
    }
    public Long GetId(){
        return this.id;
    }
    public String GetTitle(){
        return this.title;
    }
    public String GetPoster(){
        return this.poster;
    }
    public String GetDescription(){
        return this.description;
    }
    public Boolean GetActive(){
        return this.active;
    }
    public Integer GetViews(){
        return this.views;
    }
    public void SetId(Long id){
        this.id = id;
    }
    public void SetTitle(String title){
        this.title = title;
    }
    public void SetPoster(String poster){
        this.poster = poster;
    }
    public void SetDescription(String description){
        this.description = description;
    }
    public void SetActive(Boolean active){
        this.active = active;
    }
    public void SetViews(Integer views){
        this.views = views;
    }
    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;

}
