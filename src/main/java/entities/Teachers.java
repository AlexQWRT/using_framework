package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Teachers {
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
    private Collection<Forms> formsByTeacherId;
    @OneToMany(mappedBy = "teachersByTeacherId")
    private Collection<TeacherSubject> teacherSubjectsByTeacherId;

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

    public Collection<Forms> getFormsByTeacherId() {
        return formsByTeacherId;
    }

    public void setFormsByTeacherId(Collection<Forms> formsByTeacherId) {
        this.formsByTeacherId = formsByTeacherId;
    }

    public Collection<TeacherSubject> getTeacherSubjectsByTeacherId() {
        return teacherSubjectsByTeacherId;
    }

    public void setTeacherSubjectsByTeacherId(Collection<TeacherSubject> teacherSubjectsByTeacherId) {
        this.teacherSubjectsByTeacherId = teacherSubjectsByTeacherId;
    }
}
