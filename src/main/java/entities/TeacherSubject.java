package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher_subject", schema = "mydb", catalog = "")
public class TeacherSubject {
    @Basic
    @Column(name = "teacher_id", nullable = true)
    private Integer teacherId;
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teachers teachersByTeacherId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subjects subjectsBySubjectId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teachers getTeachersByTeacherId() {
        return teachersByTeacherId;
    }

    public void setTeachersByTeacherId(Teachers teachersByTeacherId) {
        this.teachersByTeacherId = teachersByTeacherId;
    }

    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
}
