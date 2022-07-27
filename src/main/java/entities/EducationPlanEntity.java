package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "education_plan", schema = "mydb", catalog = "")
public class EducationPlanEntity {
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @Basic
    @Column(name = "form_id", nullable = true)
    private Integer formId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private SubjectsEntity subjectsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private FormsEntity formsByFormId;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationPlanEntity that = (EducationPlanEntity) o;
        return Objects.equals(subjectId, that.subjectId) && Objects.equals(formId, that.formId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, formId);
    }

    public SubjectsEntity getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(SubjectsEntity subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }

    public FormsEntity getFormsByFormId() {
        return formsByFormId;
    }

    public void setFormsByFormId(FormsEntity formsByFormId) {
        this.formsByFormId = formsByFormId;
    }
}
