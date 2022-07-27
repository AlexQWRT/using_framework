package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Subjects {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subject_id", nullable = false)
    private int subjectId;
    @Basic
    @Column(name = "subject_name", nullable = true, length = 45)
    private String subjectName;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<EducationPlan> educationPlansBySubjectId;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<Marks> marksBySubjectId;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<TeacherSubject> teacherSubjectsBySubjectId;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Collection<EducationPlan> getEducationPlansBySubjectId() {
        return educationPlansBySubjectId;
    }

    public void setEducationPlansBySubjectId(Collection<EducationPlan> educationPlansBySubjectId) {
        this.educationPlansBySubjectId = educationPlansBySubjectId;
    }

    public Collection<Marks> getMarksBySubjectId() {
        return marksBySubjectId;
    }

    public void setMarksBySubjectId(Collection<Marks> marksBySubjectId) {
        this.marksBySubjectId = marksBySubjectId;
    }

    public Collection<TeacherSubject> getTeacherSubjectsBySubjectId() {
        return teacherSubjectsBySubjectId;
    }

    public void setTeacherSubjectsBySubjectId(Collection<TeacherSubject> teacherSubjectsBySubjectId) {
        this.teacherSubjectsBySubjectId = teacherSubjectsBySubjectId;
    }
}
