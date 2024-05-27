import java.util.List;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Personagem{
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species; 
    private String patronus;
    private Boolean hogwartsStaff;
    private String hogwartsStudent;
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
        String species, String patronus, Boolean hogwartsStaff, String hogwartsStudent, String actorName, 
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
        this.hogwartsStudent = hogwartsStudent;
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
        return hogwartsStudent;
    }
    public void setHogwarstsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
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
        
    }

    public void escrever(){
        MyIO.print("["+id+" ## "+name+" ## {");
        for(int i=0; i<alternate_names.size();i++){
            if(i < alternate_names.size()-1){
                MyIO.print(alternate_names.get(i)+",");
            }else{            
                MyIO.print(alternate_names.get(i));
            }
        }
        MyIO.print("} ## "+house+" ## "+ancestry+" ## "
        +species+" ## "+patronus+" ## "+hogwartsStaff+" ## "+hogwartsStudent+" ## "+actorName+" ## "+alive+
        " ## ");
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
        MyIO.print(dataFormatada.format(dateOfBirth));
        MyIO.println(" ## "+yearOfBirth+" ## "+eyeColour+" ## "+gender+" ## "+hairColour+" ## "+wizard+"]");
    }
}

public class Q1{
    static private String[] lerLinha(String linha){
        String[] linhaLida = linha.split(";");
        for(int i=0; i<linhaLida.length;i++){
            if(linhaLida[i].equals("[]")){
                linhaLida[i] = "0";
            }else{
                linhaLida[i] = linhaLida[i].replace("[","");
                linhaLida[i] = linhaLida[i].replace("]","");
                linhaLida[i] = linhaLida[i].replace("'","");
            }
        }
        return linhaLida;
    }

    static private Personagem[] criacaoDePersonagem(){
        Personagem[] vetorPersonagens = new Personagem[406];
        Arq.openRead("characters.csv");
        for(int i=0 ;i<405 ;i++){
            String linhaArquivo = Arq.readLine();
            if(i>0){
                String[] linhaLida = lerLinha(linhaArquivo);
                String id = linhaLida[0];
                String name = linhaLida[1];
                String[] nomes = linhaLida[2].split(",");
                List<String> alternate_names = new ArrayList<>();
                for(int j=0; j<nomes.length;j++){
                    alternate_names.add(nomes[j]);
                }
                String house = linhaLida[3];
                String ancestry = linhaLida[4];
                String species = linhaLida[5];
                String patronus = linhaLida[6];
                Boolean hogwartsStaff = linhaLida[7].equals("VERDADEIRO") ? true : false ;
                String hogwartsStudent = linhaLida[8];
                String actorName = linhaLida[9];
                Boolean alive = linhaLida[10].equals("VERDADEIRO") ? true : false ;
                String data = linhaLida[12];
                SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
                Date dateOfBirth = new Date();
                try {
                    dateOfBirth = dataFormatada.parse(data);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int yearOfBirth = Integer.valueOf(linhaLida[13]);
                String eyeColour = linhaLida[14];
                String gender = linhaLida[15];
                String hairColour = linhaLida[16];
                Boolean wizard = linhaLida[17].equals("VERDADEIRO") ? true : false ;
                Personagem novoPersonagem = new Personagem(id,name,alternate_names,house,ancestry,species,patronus,hogwartsStaff,hogwartsStudent,actorName,alive,dateOfBirth,
                yearOfBirth,eyeColour,gender,hairColour,wizard); 
                vetorPersonagens[i-1] = novoPersonagem;               
            }     
        }
        Arq.close(); 
        return vetorPersonagens;
    }

    static private void procuraPorId(Personagem[] personagens, String procura){
        for(int i=0;i<404;i++){
            String idPersonagem = personagens[i].getId(); 
            if(idPersonagem.equals(procura)){
                personagens[i].escrever();
            }
        }
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Personagem[] personagens = criacaoDePersonagem();
        String procura = teclado.nextLine();
        while(!procura.equals("FIM")){    
            procuraPorId(personagens,procura);
            procura = teclado.nextLine();
        }
        teclado.close();
    }
}