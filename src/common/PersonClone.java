package common;

/**
 * User: Amos
 * Date: 2019/4/10
 * Time: 15:19
 */
public class PersonClone implements Cloneable{

    private  String name;

    private  PersonClone person;

    public PersonClone(String name, PersonClone person) {
        this.name = name;
        this.person = person;
    }

    public PersonClone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonClone getPerson() {
        return person;
    }

    public void setPerson(PersonClone person) {
        this.person = person;
    }

    @Override
    public PersonClone clone(){
       PersonClone personClone=null;
        try {
            personClone = (PersonClone)super.clone();
            //深拷贝
            personClone.setPerson(new PersonClone(personClone.getPerson().getName()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return personClone;
    }

    @Override
    public String toString() {
        return "PersonClone{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
