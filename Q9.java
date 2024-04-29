import java.util.List;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Personagem implements Cloneable{
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

    @Override
        public Personagem clone() throws CloneNotSupportedException {
            try{
                //Personagem clonedPersonagem = (Personagem) super.clone();
                //clonedPersonagem.alternate_names = new ArrayList<>(this.alternate_names);
                //clonedPersonagem.dateOfBirth = this.dateOfBirth;
                return (Personagem) super.clone();
            }catch (CloneNotSupportedException e){
                System.err.println("Deu ruim meu nobre: " + e.getMessage());
                return null;
            }
            
        }
}

class Heap{
    private int tamanho;
    private Personagem[] arrayPersonagens;
	
    public Heap(Personagem[] arrayPersonagens){
        this.arrayPersonagens = arrayPersonagens;
        tamanho = arrayPersonagens.length-1;
    }
    public void sort() throws CloneNotSupportedException{
        //Contrucao do heap
        for(int tamHeap = 1; tamHeap <= tamanho; tamHeap++){
            construir(tamHeap);
        }

        //Ordenacao propriamente dita
        int tamHeap = tamanho;
        while(tamHeap > 0){
            swap(1, tamHeap--);
            reconstruir(tamHeap);
        }
    }

    public void construir(int tamHeap) throws CloneNotSupportedException{
        for(int i = tamHeap; i > 0 && arrayPersonagens[i].getHairColour().compareTo(arrayPersonagens[i/2].getHairColour()) > 0 ; i /= 2){
            swap(i, i/2);
        }
    }


    public void reconstruir(int tamHeap) throws CloneNotSupportedException{
        int i = 0;
        while(i <= (tamHeap/2)){
            int filho = getMaiorFilho(i, tamHeap);
            if(arrayPersonagens[i].getHairColour().compareTo(arrayPersonagens[filho].getHairColour()) > 0 ){
                swap(i, filho);
                i = filho;
            }else{
                i = tamHeap;
            }
        }
    }

    public int getMaiorFilho(int i, int tamHeap){
        int filho;
        if (2*i == tamHeap || arrayPersonagens[2*i].getHairColour().compareTo(arrayPersonagens[2*i+1].getHairColour()) >0 ){
            filho = 2*i;
        } else {
            filho = 2*i + 1;
        }
        return filho;
    }
    
    public void swap(int i, int j) throws CloneNotSupportedException{
		Personagem temp = arrayPersonagens[i].clone();
		arrayPersonagens[i] = arrayPersonagens[j];
		arrayPersonagens[j] = temp;
	}
    public Personagem criaPersonagem(Personagem tmp){
        String id = tmp.getId();
        String name = tmp.getName();
        List<String> alternate_names = tmp.getAlternate_names();
        String house = tmp.getHouse();
        String ancestry = tmp.getAncestry();
        String species = tmp.getSpecies();
        String patronus = tmp.getPatronus();
        Boolean hogwartsStaff = tmp.getHogwartsStaff();
        String hogwartsStudent = tmp.getHogwarstsStudent();
        String actorName = tmp.getActorName();
        Boolean alive = tmp.getAlive();
        Date dateOfBirth = tmp.getDateOfBirth();
        int yearOfBirth = tmp.getYearOfBirth();
        String eyeColour = tmp.getEyeColour();
        String gender = tmp.getGender();
        String hairColour = tmp.getHairColour();
        Boolean wizard = tmp.getWizard();
        Personagem novoPersonagem = new Personagem(id,name,alternate_names,house,ancestry,species,patronus,hogwartsStaff,hogwartsStudent,actorName,alive,dateOfBirth,
        yearOfBirth,eyeColour,gender,hairColour,wizard);                
        
        return novoPersonagem;
    }

    public void escreverOrdenado(){
        for(int j=0; j< tamanho-1; j++){
            MyIO.print("["+arrayPersonagens[j].getId()+" ## "+arrayPersonagens[j].getName()+" ## {");
            for(int i=0; i < arrayPersonagens[j].getAlternate_names().size();i++){
                if(i < arrayPersonagens[j].getAlternate_names().size()-1){
                    MyIO.print(arrayPersonagens[j].getAlternate_names().get(i)+",");
                }else{            
                    MyIO.print(arrayPersonagens[j].getAlternate_names().get(i));
                }
            }
            MyIO.print("} ## "+arrayPersonagens[j].getHouse()+" ## "+arrayPersonagens[j].getAncestry()+" ## "+arrayPersonagens[j].getSpecies()+" ## "+
            arrayPersonagens[j].getPatronus()+" ## "+arrayPersonagens[j].getHogwartsStaff()+" ## ");
            if(arrayPersonagens[j].getHogwarstsStudent().equals("VERDADEIRO")){MyIO.print("true");}else{MyIO.print("false");}
            MyIO.print(" ## "+arrayPersonagens[j].getActorName()+" ## "+arrayPersonagens[j].getAlive()+" ## ");
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");
            MyIO.print(dataFormatada.format(arrayPersonagens[j].getDateOfBirth()));
            MyIO.println(" ## "+arrayPersonagens[j].getYearOfBirth()+" ## "+arrayPersonagens[j].getEyeColour()+" ## "+arrayPersonagens[j].getGender()+" ## "+
            arrayPersonagens[j].getHairColour()+" ## "+arrayPersonagens[j].getWizard()+"]");
        }
    }
}


public class Q9{
    static private String[] lerLinha(String linha){
        String[] linhaLida = linha.split(";");
        for(int i=0; i<linhaLida.length;i++){
            if(linhaLida[i].equals("[]")){
                linhaLida[i] = "";
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

    static private Personagem[] procuraPorId(Personagem[] personagens, List<String> procura){
        int tamanho = procura.size();
        Personagem[] arrayPersonagens = new Personagem[tamanho];
        for(int i=0;i<tamanho;i++){     
            for(int j=0; j<404;j++){
                String idPersonagem = personagens[j].getId();
                if(idPersonagem.equals(procura.get(i))){
                    arrayPersonagens[i] = personagens[j];
                }
            } 
        }
        return arrayPersonagens;
    }

    public static void main(String[] args)throws CloneNotSupportedException{
        long inicio = System.currentTimeMillis();
        int i=0;
        Scanner teclado = new Scanner(System.in);
        Personagem[] personagens = criacaoDePersonagem();
        List<String> procura = new ArrayList<>();
        String leitura = teclado.nextLine();
        procura.add(leitura);
        while(!procura.get(i).equals("FIM")){    
            i++;
            leitura = teclado.nextLine();
            procura.add(leitura);
        }
        Heap ordenacaoHeap = new Heap(procuraPorId(personagens,procura));
        Arq.openWrite("824137_insercao.txt");
        ordenacaoHeap.sort();
        ordenacaoHeap.escreverOrdenado();
        teclado.close();
        long fim = System.currentTimeMillis(); 
        long tempo = (fim-inicio);
        Arq.print(tempo);
        Arq.close();
    }
}