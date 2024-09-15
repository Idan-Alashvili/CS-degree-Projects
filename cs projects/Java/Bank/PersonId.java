package exc2bank;
//author: Idan Alashvili
public class PersonId {
    private long IDnum;
    private String FirstName;
    private String LastName;
    private String Address;

    public long getIDnum() {
        return IDnum;
    }

    public void setIDnum(long IDnum) {
        if (IDnum < 0) IDnum = IDnum * -1;
        this.IDnum = IDnum;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    PersonId(long IDnum, String FirstName, String LastName, String Address) {
        this.IDnum = IDnum;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
    }

    PersonId() {
        this.IDnum = 0;
        this.Address = "";
        this.FirstName = "";
        this.LastName = "";
    }

    PersonId(PersonId other) {
        this.IDnum = other.IDnum;
        this.Address = other.Address;
        this.FirstName = other.FirstName;
        this.LastName = other.LastName;
    }

    @Override
    public String toString() {
        return "Person ID : " + this.IDnum + ", Name:" +
                this.FirstName + this.LastName + ", Address: " + this.Address;
    }

    public boolean equals(PersonId other) {
        return this.IDnum == other.IDnum;
    }
}
