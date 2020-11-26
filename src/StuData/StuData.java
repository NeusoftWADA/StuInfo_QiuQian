package StuData;

public class StuData {
    private String ID;
    private String Name;
    private String Gender;
    private String Birthday;
    private String State;

    public StuData(String ID, String name, String gender, String birthday, String state) {
        this.ID = ID;
        Name = name;
        Gender = gender;
        Birthday = birthday;
        State = state;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getState() {
        return State;
    }
}
