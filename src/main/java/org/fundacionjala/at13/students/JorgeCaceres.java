package org.fundacionjala.at13.students;
public class JorgeCaceres{
    private String name = "Jorge Caceres Velasco";
    private String nickName = "Jorge";
    private int age = 29;
    private String career = "Electronic Engineer";
    private String university = "San Simon";
    private String programingLanguages = "Java";
    private String residenceCity = "Cochabamba";

/*Jorge Rodrigo Caceres Velasco
Jorge
29
Electronic engineer
San Simon University
Java
Cochabamba*/
    public String getResidenceCity(){
        return "Currently I live in "+residenceCity+".";
    }
    public String ShowNickName(){
        return "I like to be called "+this.nickName;
    }

    public String showStudentsInformation() {
        return "Hello "+"my name is " + name + "\n" +
                "I like to be called '" + nickName + "\n" +
                "I am "+ age +" years old" + "\n" +
                "I am " + career + "\n" +
                "I study at " + university+ " university \n" +
                "My programming languages are " + programingLanguages +"\n" +
                "My residence city " + residenceCity;
    }
    public String ShowName(){
        return "Hi, my name is "+this.name;
    }
}
