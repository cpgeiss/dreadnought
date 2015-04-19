package com.fixmyfolks.data.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity("problems")
public class Problem {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private List<String> tags;
    private Double price;
    @Indexed
    private ObjectId folk;
    @Indexed
    private ObjectId fixer;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	public ObjectId getFolk() {
		return folk;
	}

	public void setFolk(ObjectId folk) {
		this.folk = folk;
	}

	public ObjectId getFixer() {
		return fixer;
	}

	public void setFixer(ObjectId fixer) {
		this.fixer = fixer;
	}

}
