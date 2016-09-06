package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("","","",30);
    }

    public Course(String n, String cid) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !n.equalsIgnoreCase(cid)?cid:"000000";
        this.lecturer = "TBA";
        this.max_students = 30;
        this.no_students = 0;
        //this(course_name,course_id,"",30);
    }

    public Course(String n, String cid, String l) {
        // implement here
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !n.equalsIgnoreCase(cid)?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = 30;
        this.no_students = 0;
        //this(course_name,course_id,lecturer,30);
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !n.equalsIgnoreCase(cid)?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = (max>=10)?max:30;
        this.no_students = 0;
        // implement the rest here
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here
        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        // implement here
        this.lecturer = !lecturer.equals("")?lecturer:"Pruet Boonma";

    }

    public int getMax_students() {
        // implement here
        return this.max_students;
    }

    public void setMax_students(int max_students) {
        // implement here
       this.max_students = (max_students >=10)?max_students:this.max_students;
    }

    public int getNo_students() {
        // implement here
        return 0;
    }

    public void setNo_students(int no_students) {
        this.no_students = (no_students<max_students)?no_students:0;
    }

    @Override
    public String toString() {
        if(no_students == 0)
        {
            String o = this.course_name + " (" + this.course_id + "), Teacher: " + this.lecturer + ", has NO student, [maximum: "
                    + max_students+"]";
            return o;
        }else if(no_students == 1)
        {
            String o = this.course_name + " (" + this.course_id + "), Teacher: " + this.lecturer + ", has ONE student, [maximum: "
                    + max_students+"]";
            return o;
        }else {
            String o = this.course_name + " (" + this.course_id + "), Teacher: " + this.lecturer + ", has " + no_students +
                    " students, [maximum: " + max_students + "]";
            return o;
        }

        // implement the rest here
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        // implement the rest here
        /*if(m.matches() == true)
            return true;
        else
            return false;*/
        return m.matches();
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}

