package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "teachers", schema = "mydb", catalog = "")
public class TeachersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "teacher_id", nullable = false)
    private int teacherId;
    @Basic
    @Column(name = "teacher_name", nullable = true, length = 45)
    private String teacherName;
    @Basic
    @Column(name = "teacher_surname", nullable = true, length = 45)
    private String teacherSurname;
    @Basic
    @Column(name = "teacher_patronymic", nullable = true, length = 45)
    private String teacherPatronymic;
    @OneToMany(mappedBy = "teachersByTeacherId")
    private Collection<FormsEntity> formsByTeacherId;
    @OneToMany(mappedBy = "teachersByTeacherId")
    private Collection<TeacherSubjectEntity> teacherSubjectsByTeacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherPatronymic() {
        return teacherPatronymic;
    }

    public void setTeacherPatronymic(String teacherPatronymic) {
        this.teacherPatronymic = teacherPatronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachersEntity that = (TeachersEntity) o;
        return teacherId == that.teacherId && Objects.equals(teacherName, that.teacherName) && Objects.equals(teacherSurname, that.teacherSurname) && Objects.equals(teacherPatronymic, that.teacherPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, teacherSurname, teacherPatronymic);
    }

    public Collection<FormsEntity> getFormsByTeacherId() {
        return formsByTeacherId;
    }

    public void setFormsByTeacherId(Collection<FormsEntity> formsByTeacherId) {
        this.formsByTeacherId = formsByTeacherId;
    }

    public Collection<TeacherSubjectEntity> getTeacherSubjectsByTeacherId() {
        return teacherSubjectsByTeacherId;
    }

    public void setTeacherSubjectsByTeacherId(Collection<TeacherSubjectEntity> teacherSubjectsByTeacherId) {
        this.teacherSubjectsByTeacherId = teacherSubjectsByTeacherId;
    }
}
