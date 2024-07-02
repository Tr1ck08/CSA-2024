import java.util.ArrayList;

public class TitanicSimulator extends TitanicSimulatorBase {
    // Constructor(s)
    public TitanicSimulator() {
    }

    // Sorts students by the requested method, the returned list should contain the
    //  number of students equal to 'studentCount' and ordered by the requested method.
    public ArrayList<Student> pickStudents(Skyward skyward, int studentCount, SortMethod sortMethod) {
        ArrayList<Student> students = skyward.getStudents();
        int i = 0;
        while (i + 1 < students.size()) {
            if (compareStudents(students.get(i), students.get(i + 1), sortMethod) < 0) {
                i++;
            } else if (compareStudents(students.get(i), students.get(i + 1), sortMethod) > 0) {
                Student lower = students.get(i + 1);
                Student higher = students.get(i);
                students.set(i + 1, higher);
                students.set(i, lower);
                if (i > 0) i--;
            }
        }
        for (int h = students.size() - 1; h >= studentCount; h--) {
            students.remove(students.get(h));
        }
        return students;
    }
    
    // This is a helper method you can use. It compares two students using your the provided comparison method. 
    private int compareStudents(Student a, Student b, SortMethod sortMethod) {
        if (sortMethod == SortMethod.FIRST_NAME) {
            return a.getFirstName().toUpperCase().compareTo(b.getFirstName().toUpperCase());
        }
        else if (sortMethod == SortMethod.LAST_NAME) {
            return a.getLastName().toUpperCase().compareTo(b.getLastName().toUpperCase());
        }
        else if (sortMethod == SortMethod.STUDENT_ID) {
            return Integer.compare(a.getStudentId(), b.getStudentId());
        }
        else { // sortMethod == SortMethod.GRADE
            return Double.compare(b.getGrade(), a.getGrade());
        }
    }

    // Here's another helper method for you. It copies the first 'count' students into a new ArrayList for you.
    private ArrayList<Student> copyFirstN(ArrayList<Student> students, int count) {
        ArrayList<Student> copy = new ArrayList<Student>();
        for (int i = 0; (i < count) && (i < students.size()); i++) {
            copy.add( students.get(i) );
        }
        return copy;
    }
}
