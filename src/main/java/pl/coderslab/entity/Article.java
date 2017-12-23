package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import pl.coderslab.validator.ArticleValidationGroup;
import pl.coderslab.validator.Content;
import pl.coderslab.validator.DraftValidationGroup;

@Entity
@Table(name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(max = 200)
	@NotEmpty(groups = { ArticleValidationGroup.class, DraftValidationGroup.class })
	private String title;

	@OneToOne
	private Author author;

	@NotEmpty(groups = ArticleValidationGroup.class)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(joinColumns = { @JoinColumn(name = "article_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private List<Category> categories;

	@Content(minLength = 50, groups = { ArticleValidationGroup.class, DraftValidationGroup.class })
	@NotEmpty(groups = { ArticleValidationGroup.class, DraftValidationGroup.class })
	@Column(columnDefinition = "TEXT")
	private String content;

	@CreationTimestamp
	private LocalDateTime created;

	@UpdateTimestamp
	private LocalDateTime updated;

	private boolean draft;

	public Article() {
		categories = new ArrayList<>();
	}

	public Article(String title, Author author, List<Category> categories, String content, LocalDateTime created,
			LocalDateTime updated) {
		this.title = title;
		this.author = author;
		this.categories = categories;
		this.content = content;
		this.created = created;
		this.updated = updated;
	}

	public Article(int id, String title, Author author, List<Category> categories, String content,
			LocalDateTime created, LocalDateTime updated) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.categories = categories;
		this.content = content;
		this.created = created;
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

}
