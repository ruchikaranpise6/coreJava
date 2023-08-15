package leetcode;

public final class Student {

    private Name name;

    public Student(Name name) {
        Name immutable = new Name();
        immutable.setFirstName(name.getFirstName());
        immutable.setLastName(name.getLastName());
        this.name = immutable;
    }

    public Name getFullName() {
        Name dummyName = new Name();
        dummyName.setFirstName(name.getFirstName());
        dummyName.setLastName(name.getLastName());
        return dummyName;
    }
}
