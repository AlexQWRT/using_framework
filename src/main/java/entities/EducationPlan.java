package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "education_plan", schema = "mydb", catalog = "")
public class EducationPlan {
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @Basic
    @Column(name = "form_id", nullable = true)
    private Integer formId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subjects subjectsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private Forms formsByFormId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }

    public Forms getFormsByFormId() {
        return formsByFormId;
    }

    public void setFormsByFormId(Forms formsByFormId) {
        this.formsByFormId = formsByFormId;
    }
}
