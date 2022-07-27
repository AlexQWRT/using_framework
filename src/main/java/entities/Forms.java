package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Forms {
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
    private Collection<EducationPlan> educationPlansByFormId;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teachers teachersByTeacherId;
    @OneToMany(mappedBy = "formsByFormId")
    private Collection<Students> studentsByFormId;

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

    public Collection<EducationPlan> getEducationPlansByFormId() {
        return educationPlansByFormId;
    }

    public void setEducationPlansByFormId(Collection<EducationPlan> educationPlansByFormId) {
        this.educationPlansByFormId = educationPlansByFormId;
    }

    public Teachers getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(Teachers teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    public Collection<Students> getStudentsByFormId() {
        return studentsByFormId;
    }

    public void setStudentsByFormId(Collection<Students> studentsByFormId) {
        this.studentsByFormId = studentsByFormId;
    }
}
