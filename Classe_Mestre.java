import java.util.List;
import java.util.Date;

class Personagem{
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species; 
    private String patronus;
    private Boolean hogwartsStaff;
    private String hogwarstsStudent;
    private String actorName;
    private Boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;
        
    public Personagem() {
    }

    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry, 
        String species, String patronus, Boolean hogwartsStaff, String hogwarstsStudent, String actorName, 
        Boolean alive,Date dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, 
        Boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwarstsStudent = hogwarstsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getAlternate_names() {
        return alternate_names;
    }
    public void setAlternate_names(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public String getAncestry() {
        return ancestry;
    }
    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getPatronus() {
        return patronus;
    }
    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }
    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }
    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }
    public String getHogwarstsStudent() {
        return hogwarstsStudent;
    }
    public void setHogwarstsStudent(String hogwarstsStudent) {
        this.hogwarstsStudent = hogwarstsStudent;
    }
    public String getActorName() {
        return actorName;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public String getEyeColour() {
        return eyeColour;
    }
    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getHairColour() {
        return hairColour;
    }
    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }
    public Boolean getWizard() {
        return wizard;
    }
    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    public void ler(){
        System.out.println("["+id+" ## "+name+" ## {"+alternate_names+"} ## "+house+" ## "+ancestry+" ## "
        +species+" ## "+patronus+" ## "+hogwartsStaff+" ## "+hogwarstsStudent+" ## "+actorName+" ## "+alive+
        " ## "+dateOfBirth+" ## "+yearOfBirth+" ## "+eyeColour+" ## "+gender+" ## "+hairColour+" ## "+wizard+"]");
    }
    public void escrever(){

    }
}
