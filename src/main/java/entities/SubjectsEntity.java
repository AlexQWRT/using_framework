package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subjects", schema = "mydb", catalog = "")
public class SubjectsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subject_id", nullable = false)
    private int subjectId;
    @Basic
    @Column(name = "subject_name", nullable = true, length = 45)
    private String subjectName;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<EducationPlanEntity> educationPlansBySubjectId;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<MarksEntity> marksBySubjectId;
    @OneToMany(mappedBy = "subjectsBySubjectId")
    private Collection<TeacherSubjectEntity> teacherSubjectsBySubjectId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectsEntity that = (SubjectsEntity) o;
        return subjectId == that.subjectId && Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, subjectName);
    }

    public Collection<EducationPlanEntity> getEducationPlansBySubjectId() {
        return educationPlansBySubjectId;
    }

    public void setEducationPlansBySubjectId(Collection<EducationPlanEntity> educationPlansBySubjectId) {
        this.educationPlansBySubjectId = educationPlansBySubjectId;
    }

    public Collection<MarksEntity> getMarksBySubjectId() {
        return marksBySubjectId;
    }

    public void setMarksBySubjectId(Collection<MarksEntity> marksBySubjectId) {
        this.marksBySubjectId = marksBySubjectId;
    }

    public Collection<TeacherSubjectEntity> getTeacherSubjectsBySubjectId() {
        return teacherSubjectsBySubjectId;
    }

    public void setTeacherSubjectsBySubjectId(Collection<TeacherSubjectEntity> teacherSubjectsBySubjectId) {
        this.teacherSubjectsBySubjectId = teacherSubjectsBySubjectId;
    }
}
