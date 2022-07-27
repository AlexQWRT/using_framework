package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id", nullable = false)
    private int studentId;
    @Basic
    @Column(name = "student_name", nullable = true, length = 45)
    private String studentName;
    @Basic
    @Column(name = "student_surname", nullable = true, length = 45)
    private String studentSurname;
    @Basic
    @Column(name = "student_patronymic", nullable = true, length = 45)
    private String studentPatronymic;
    @Basic
    @Column(name = "form_id", nullable = true)
    private Integer formId;
    @OneToMany(mappedBy = "studentsByStudentId")
    private Collection<Marks> marksByStudentId;
    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private Forms formsByFormId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentPatronymic() {
        return studentPatronymic;
    }

    public void setStudentPatronymic(String studentPatronymic) {
        this.studentPatronymic = studentPatronymic;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Collection<Marks> getMarksByStudentId() {
        return marksByStudentId;
    }

    public void setMarksByStudentId(Collection<Marks> marksByStudentId) {
        this.marksByStudentId = marksByStudentId;
    }

    public Forms getFormsByFormId() {
        return formsByFormId;
    }

    public void setFormsByFormId(Forms formsByFormId) {
        this.formsByFormId = formsByFormId;
    }
}
