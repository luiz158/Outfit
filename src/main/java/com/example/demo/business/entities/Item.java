package com.example.demo.business.entities;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String color;

    @NotNull
    private String material;

    @NotEmpty
    private String size;

    @NotNull
    @Size(min = 10)
    private String description;

    //@NotNull
    //@Size(min = 4)
    private String picturePath;


    @NotNull
    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    @NotNull
    @OneToOne
    private String occasion;

    @OneToMany(mappedBy = "item")
    private Set<Temperature> temperature;

    public Item() {
        temperature = new HashSet<>();
    }

    public Item(@NotNull @Size(min = 4) String color, @NotNull @Size(min = 3) String material, @NotEmpty String size, String picturePath, @NotNull @Size(min = 10) String description, User user, Category category) {
        this();
        this.color = color;
        this.material = material;
        this.size = size;
        this.picturePath = picturePath;
        this.description = description;
        this.user = user;
        this.category = category;
        this.occasion = occasion;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial()git  {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


     public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

 public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(Set<Temperature> temperature) {
        this.temperature = temperature;
    }

    public Set<Occasion> getOccasion(){return occasion; }

    public void setOccasion(Set<Occasion> occasion) {
        this.occasion() = occasion;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", size=" + size +
                ", picturePath='" + picturePath + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
