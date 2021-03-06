package com.fixmyfolks.data.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

import com.fixmyfolks.justgiving.model.SearchResult;

@Entity("problems")
public class Problem {
    @Id
    private ObjectId id;
    private String tag;
    private String description;
    private Double price;
    @Indexed
    private ObjectId folk;
    @Indexed
    private ObjectId fixer;
    private boolean fixed;
    private boolean donationReceived;
    @Embedded
    private SearchResult charity;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public boolean isDonationReceived() {
		return donationReceived;
	}

	public void setDonationReceived(boolean donationReceived) {
		this.donationReceived = donationReceived;
	}

	public SearchResult getCharity() {
        return charity;
    }

    public void setCharity(SearchResult charity) {
        this.charity = charity;
    }

}
