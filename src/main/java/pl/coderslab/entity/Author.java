package pl.coderslab.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	private List<Article> articles;

	public Author() {
		articles = new ArrayList<>();
	}

	public Author(String firstName, String lastName, List<Article> articles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.articles = articles;
	}

	public Author(int id, String firstName, String lastName, List<Article> articles) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.articles = articles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

}
