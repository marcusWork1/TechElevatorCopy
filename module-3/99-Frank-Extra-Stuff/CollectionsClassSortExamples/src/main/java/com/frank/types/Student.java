package com.frank.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/********************************************************************************************
 * Represent a basic student object with an id
 ********************************************************************************************/
public class Student implements Cloneable {
//*******************************************************************************
// Instance Variables
//*******************************************************************************
        private int           id;
        private String        course;
        private String        name;
        private List<Integer> scores;
        private int           totalScore;
        private double        averageScore;

//*******************************************************************************
// Constructors
//*******************************************************************************
        // default ctor in case Java needs one
        public Student() {}

        public Student(String course, int id, String name, List<Integer> scores) {
                this.course = course;
                this.id     = id;
                this.name   = name;
                this.scores = new ArrayList(scores);

                // Calculate totalScore a Lambda Expression
                totalScore =  totalScore = scores.stream().reduce(0,(total, aScore) -> total + aScore);

                averageScore = totalScore / scores.size();
        }
//*******************************************************************************
// getters/setters
//*******************************************************************************
        public String getCourse() { return course; }
        public void setCourse(String course) { this.course = course; }
        public int    getId()       { return id;   }
        public void   setId(int id) { this.id = id;}
        public String getName()     { return name; }
        public void   setName(String name) { this.name = name;    }
        public List<Integer> getScores()   { return new ArrayList(scores); }
        public int    getTotalScore()      { return totalScore;   }
        public double getAverageScore()    { return averageScore; }
        public void   setScores(List<Integer> scores) { this.scores = new ArrayList(scores); }

//*******************************************************************************
// Method Overrides
//*******************************************************************************
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Student)) return false;
                Student student = (Student) o;
                return getId() == student.getId() && getTotalScore() == student.getTotalScore() && Double.compare(student.getAverageScore(), getAverageScore()) == 0 && getCourse().equals(student.getCourse()) && getName().equals(student.getName()) && getScores().equals(student.getScores());
        }
        @Override
        public int hashCode() {
                return Objects.hash(getId(), getCourse(), getName(), getScores(), getTotalScore(), getAverageScore());
        }
        @Override
        public String toString() {
                return "student{" +
                        "id=" + id +
                        ", course='" + course + '\'' +
                        ", name='" + name + '\'' +
                        ", scores=" + scores +
                        ", totalScore=" + totalScore +
                        ", averageScore=" + averageScore +
                        '}';
        }
        @Override
        public Student clone() throws CloneNotSupportedException {
                Student newstudent = (Student) super.clone();  // Shallow copy object
                newstudent.setScores(this.getScores());        // Deep copy reference variables
                return newstudent;
        }

//*******************************************************************************
// Helper and Compare methods
//*******************************************************************************
        public String getScoresAsString() {
                return getScores().toString();
        }

        //**************************************************************************
        // methods to return how values in one student compare to values in another
        // static methods are used so they can be invoked without objects:
        //          Student::methodName()
        //
        // these compareByxxxxxxx() methods may be used in the calls to the
        // Collections class .sort() method in the appliction.
        //
        // the compareByxxxxxxxx() methods return how one object of the class
        // relates to another by:
        //       returning 0 if they are equal
        //       returning a negative value if the first is less than the second
        //       returning a positive value if the first is greater than the second
        //
        // Comparator methods are required due to Java having no idea how to
        //     compare objects of any class that is not part of Java
        //**************************************************************************
        public static int compareByName(Student student1, Student student2) {
                return student1.name.compareTo(student2.name);
        }
        public static int compareById(Student student1, Student student2) {
                return student1.id - student2.id;
        }
        public static int compareByCourse(Student student1, Student student2) {
                return student1.course.compareTo(student2.course);
        }
        public static int compareByCourseAndName(Student student1, Student student2) {
                if (student1.course.compareTo(student2.course) != 0) {     // If courses are not the same, no need to compare name
                        return student1.course.compareTo(student2.course); // return how the courses compare
                }
                return student1.name.compareTo(student2.name);  // If courses are the same, return how names compare
        }
        public static int compareByTotalScore(Student student1, Student student2) {
                return student1.totalScore - student2.totalScore;
        }
        public static int compareByAvgScore(Student student1, Student student2) {
                // Multiply by 10000 to make double value a meaningful int
                // so, .123, when cast to an int, is 1230 instead of 0
                return (int) student1.averageScore * 10000 - (int) student2.averageScore * 10000;
        }
}
