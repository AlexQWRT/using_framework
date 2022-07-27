package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "forms", schema = "mydb", catalog = "")
public class FormsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "form_id", nullable = false)
    private int formId;
    @Basic
    @Column(name = "form_number", nullable = true)
    private Integer formNumber;
    @Basic
    @Column(name = "form_letter", nullable = true, length = 1)
    private String formLetter;
    @Basic
    @Column(name = "teacher_id", nullable = true)
    private Integer teacherId;
    @OneToMany(mappedBy = "formsByFormId")
    private Collection<EducationPlanEntity> educationPlansByFormId;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private TeachersEntity teachersByTeacherId;
    @OneToMany(mappedBy = "formsByFormId")
    private Collection<StudentsEntity> studentsByFormId;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public Integer getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(Integer formNumber) {
        this.formNumber = formNumber;
    }

    public String getFormLetter() {
        return formLetter;
    }

    public void setFormLetter(String formLetter) {
        this.formLetter = formLetter;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormsEntity that = (FormsEntity) o;
        return formId == that.formId && Objects.equals(formNumber, that.formNumber) && Objects.equals(formLetter, that.formLetter) && Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, formNumber, formLetter, teacherId);
    }

    public Collection<EducationPlanEntity> getEducationPlansByFormId() {
        return educationPlansByFormId;
    }

    public void setEducationPlansByFormId(Collection<EducationPlanEntity> educationPlansByFormId) {
        this.educationPlansByFormId = educationPlansByFormId;
    }

    public TeachersEntity getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(TeachersEntity teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    public Collection<StudentsEntity> getStudentsByFormId() {
        return studentsByFormId;
    }

    public void setStudentsByFormId(Collection<StudentsEntity> studentsByFormId) {
        this.studentsByFormId = studentsByFormId;
    }
}
