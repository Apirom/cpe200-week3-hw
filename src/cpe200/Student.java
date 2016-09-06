package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public Student() {
        // implement here
        this.std_name = "John Doe";
        this.std_id = "560610000";
        this.yob = 1990;
        this.active = false;
    }

    // implement all missing constructors here
    public Student(String n,String std_id,int y,boolean Active)
    {
        this.std_name = !n.equals("")?n:"John Doe";
        this.std_id = isValidStudent_id(std_id)?std_id:"560610000";
        this.yob = (y>1989)?y:1990;
        this.active = Active;
    }
    // implement all get and set methods here

    @Override
    public String toString() {
        String o = std_name + " (" + std_id +") " + "was born in "+yob+" is an INACTIVE student.";
        return o;
    }

    private boolean isValidStudent_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        return m.matches();
    }

    private boolean isValidYOB(int yob) {
        if(yob>1989)
        {
            return true;
        }else
        {
            return false;
        }
    }

    // declare your attributes here
    public String getName()
    {
        return this.std_name;
    }
    public void setName(String name)
    {
        this.std_name = !name.equals("")?name:std_name;
    }

    public String getStudent_id() {
            return this.std_id;
    }

    public void setStudent_id(String std_id) {
        this.std_id = isValidStudent_id(std_id)?std_id:this.std_id;
    }

    public int getYearOfBirth() {
        if(yob<1990) {
            return 1990;
        }
        else {
            return this.yob;
        }
    }

    public void setYearOfBirth(int yob) {
        this.yob = isValidYOB(yob)?yob:this.yob;
    }
    public boolean isActive()
    {
        return active;
    }

    private static final String idREGEX = "5[6-9]061[0-2][0-9]{3}";

    private String std_name;
    private String std_id;
    private int yob;
    private  boolean active;
}
