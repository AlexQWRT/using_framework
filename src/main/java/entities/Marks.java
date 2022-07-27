package entities;

import jakarta.persistence.*;

@Entity
public class Marks {
    @Basic
    @Column(name = "student_id", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "subject_id", nullable = true)
    private Integer subjectId;
    @Basic
    @Column(name = "mark", nullable = true)
    private Integer mark;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Students studentsByStudentId;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subjects subjectsBySubjectId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Students getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(Students studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
}
