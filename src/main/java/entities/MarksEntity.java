package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "marks", schema = "mydb", catalog = "")
public class MarksEntity {
    @Basic
    @Column(name = "student_id", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @Basic
    @Column(name = "mark", nullable = true)
    private Integer mark;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentsEntity studentsByStudentId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private SubjectsEntity subjectsBySubjectId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarksEntity that = (MarksEntity) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(subjectId, that.subjectId) && Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId, mark);
    }

    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    public SubjectsEntity getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(SubjectsEntity subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
}
