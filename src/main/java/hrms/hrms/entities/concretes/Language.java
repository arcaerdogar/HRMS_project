package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hrms.hrms.entities.concretes.cvElements.CvLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	
	public Language(int languageId, String languageName, List<CvLanguage> cvLanguage) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.cvLanguage = cvLanguage;
	}
	public Language() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="language_name")
	private String languageName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "language")
	private List<CvLanguage> cvLanguage;

	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public List<CvLanguage> getCvLanguage() {
		return cvLanguage;
	}
	public void setCvLanguage(List<CvLanguage> cvLanguage) {
		this.cvLanguage = cvLanguage;
	}
	
	
}
