package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "teacher_subject", schema = "mydb", catalog = "")
public class TeacherSubjectEntity {
    @Basic
    @Column(name = "teacher_id", nullable = true)
    private Integer teacherId;
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private TeachersEntity teachersByTeacherId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private SubjectsEntity subjectsBySubjectId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherSubjectEntity that = (TeacherSubjectEntity) o;
        return Objects.equals(teacherId, that.teacherId) && Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectId);
    }

    public TeachersEntity getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(TeachersEntity teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    public SubjectsEntity getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(SubjectsEntity subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
}
