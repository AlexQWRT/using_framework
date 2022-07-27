package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "mydb", catalog = "")
public class StudentsEntity {
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
    private Collection<MarksEntity> marksByStudentId;
    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "form_id")
    private FormsEntity formsByFormId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return studentId == that.studentId && Objects.equals(studentName, that.studentName) && Objects.equals(studentSurname, that.studentSurname) && Objects.equals(studentPatronymic, that.studentPatronymic) && Objects.equals(formId, that.formId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentSurname, studentPatronymic, formId);
    }

    public Collection<MarksEntity> getMarksByStudentId() {
        return marksByStudentId;
    }

    public void setMarksByStudentId(Collection<MarksEntity> marksByStudentId) {
        this.marksByStudentId = marksByStudentId;
    }

    public FormsEntity getFormsByFormId() {
        return formsByFormId;
    }

    public void setFormsByFormId(FormsEntity formsByFormId) {
        this.formsByFormId = formsByFormId;
    }
}
