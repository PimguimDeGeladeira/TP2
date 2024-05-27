#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct Personagens
{
    char id[101];
    char name[101];
    char alternate_names[10001];
    char house[101];
    char ancestry[101];
    char species[101]; 
    char patronus[101];
    int hogwartsStaff;
    char hogwartsStudent[101];
    char actorName[101];
    int alive;
    char dateOfBirth[10];
    int yearOfBirth;
    char eyeColour[101];
    char gender[101];
    char hairColour[101];
    int wizard;
}Personagens;

Personagens *ponteiroParaPersonagens(){
    FILE *ponteiroArquivo = fopen("/tmp/characters.csv","r");
    const int totalPersonagens = 405;
    Personagens *listaPersonagens = malloc(totalPersonagens * sizeof(Personagens));
    char lixo[101], booleanoHogwartsStaff[101], booleanoAlive[101], dataNascimento[101], mago[101];
    if(ponteiroArquivo != NULL){ 
        for(int i=0; i<405; i++){
            if(i==0){
                char strlixo[201];
                fscanf(ponteiroArquivo," %[^\n]",strlixo);
            }
            if(i>0){
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].id);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].name);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].alternate_names); 
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].house);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].ancestry);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].species); 
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].patronus); 
                fscanf(ponteiroArquivo," %[^;];",booleanoHogwartsStaff);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].hogwartsStudent);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].actorName);
                fscanf(ponteiroArquivo," %[^;];",booleanoAlive);
                fscanf(ponteiroArquivo," %[^;];",lixo);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].dateOfBirth);
                fscanf(ponteiroArquivo," %[^;];",dataNascimento);          
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].eyeColour);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].gender);
                fscanf(ponteiroArquivo," %[^;];",listaPersonagens[i].hairColour);
                fscanf(ponteiroArquivo," %[^\n]",mago);
                if(strcmp(booleanoHogwartsStaff,"FALSO") == 0){
                    listaPersonagens[i].hogwartsStaff = 0;
                }else{
                    listaPersonagens[i].hogwartsStaff = 1;
                }
                if(strcmp(booleanoAlive,"FALSO") == 0){
                    listaPersonagens[i].alive = 0;
                }else{
                    listaPersonagens[i].alive = 1;
                }
                listaPersonagens[i].yearOfBirth = atoi(dataNascimento);
                if(strcmp(mago,"FALSO") == 0){
                    listaPersonagens[i].wizard = 0;
                }else{
                    listaPersonagens[i].wizard = 1;
                }
                         
            }  
        }
        
    }
    fclose(ponteiroArquivo);
    return listaPersonagens;

}

void remove_caracteres(char *str) {
    int i, j;
    int len = strlen(str);

    // Percorre a string e remove os caracteres específicos
    for (i = 0; i < len; i++) {
        if (str[i] == '[' || str[i] == ']' || str[i] == '\'') {
            for (j = i; j < len; j++) {
                str[j] = str[j + 1];
            }
            len--; // Decrementa o comprimento da string após remover o caractere
            i--;   // Mantém a mesma posição de i para verificar o próximo caractere
        }
    }
}

void imprimirPersonagem(Personagens *ptrPersonagens, int index){
        printf("[%s ##",ptrPersonagens[index].id);
        printf(" %s ##",ptrPersonagens[index].name);
        remove_caracteres(ptrPersonagens[index].alternate_names);
        printf(" {%s} ##",ptrPersonagens[index].alternate_names);
        printf(" %s ##",ptrPersonagens[index].house);
        printf(" %s ##",ptrPersonagens[index].ancestry);
        printf(" %s ##",ptrPersonagens[index].species);
        printf(" %s ##",ptrPersonagens[index].patronus);
        printf(" ##",ptrPersonagens[index].hogwartsStaff == 0 ? printf(" false"):printf(" true"));
        printf(" ##",ptrPersonagens[index].hogwartsStudent == 0 ? printf(" false"):printf(" true"));
        printf(" %s ##",ptrPersonagens[index].actorName);
        printf(" ##",ptrPersonagens[index].alive == 0 ? printf(" false"):printf(" true"));
        printf(" %s ##",ptrPersonagens[index].dateOfBirth);
        printf(" %d ##",ptrPersonagens[index].yearOfBirth);
        printf(" %s ##",ptrPersonagens[index].eyeColour);
        printf(" %s ##",ptrPersonagens[index].gender);
        printf(" %s ##",ptrPersonagens[index].hairColour);
        printf("]\n",ptrPersonagens[index].wizard == 0 ? printf(" false"):printf(" true"));   
}

Personagens *procuraPorId(Personagens *personagens, char procura[][101], int tamanho){
    Personagens *ptr = malloc(tamanho * sizeof(Personagens));
    for(int i=0;i< tamanho;i++){
        for(int j=1;j<405;j++){
            char idPersonagem[1001]; 
            strcpy(idPersonagem, personagens[j].id); 
            if(strcmp(idPersonagem,procura[i]) == 0){
                ptr[i] = personagens[j];
            }
        }
    }
    return ptr;
}
static int movimentacoes =0, comparacoes =0;
char* procurarNome(Personagens *personagens ,char procuraNome[][101],int tamanho, int i){
    int verifica =0;
    int dir = tamanho- 1, esq = 0, meio;
    while (esq <= dir){
        meio = (esq + dir) / 2;
        if (strcmp(procuraNome[i],personagens[meio].name) == 0){
            comparacoes++;
            verifica = 1;
            esq=tamanho;
        }else if(strcmp(procuraNome[i],personagens[meio].name) > 0){
            comparacoes++;
            esq = meio + 1;
        }else{
        comparacoes++;
        dir = meio - 1;
        }
        comparacoes++;
    }
    if(verifica == 0){ 
        return "NAO";
    }else{
        return "SIM";
    }
}

void insercao(Personagens *array, int tamanho){
    for (int i = 1; i < tamanho; i++) {
        Personagens tmp = array[i];
        int j = i - 1;

        while ((j >= 0) && (strcmp(array[j].name,tmp.name) > 0 )) {
            array[j + 1] = array[j];
            j--;
        }
        array[j+1] = tmp;
   }
}

int main(){
    clock_t inicio = clock();
    int indexMatriz=0, contadorTamanho=0, contadorTamanhoNomes=0;
    char idParaAchar[1001], nomeParaAchar[101];
    char arrayId[405][101];
    Personagens *ptrPersonagens = ponteiroParaPersonagens();
    scanf(" %s", idParaAchar);    
    strcpy(arrayId[indexMatriz++],idParaAchar); 
    while(strcmp(idParaAchar,"FIM") != 0){
        scanf(" %s", idParaAchar);
        strcpy(arrayId[indexMatriz++],idParaAchar);        
    }
    for(int i=0; i<sizeof(*arrayId);i++){
        contadorTamanho++;
        if(strcmp(arrayId[i],"FIM") ==0) break;
    };
    Personagens *ponteiroNovo = procuraPorId(ptrPersonagens, arrayId, contadorTamanho); 
    char arrayNomes[405][101];
    indexMatriz=0;
    scanf(" %[^\r\n]", nomeParaAchar);  
    strcpy(arrayNomes[indexMatriz++],nomeParaAchar);   
    while(strcmp(nomeParaAchar,"FIM") != 0){
        scanf(" %[^\r\n]", nomeParaAchar);
        strcpy(arrayNomes[indexMatriz++],nomeParaAchar);   
    }
    for(int i=0; i<sizeof(*arrayNomes);i++){
        contadorTamanhoNomes++;
        if(strcmp(arrayNomes[i],"FIM") ==0) break;
    }
    insercao(ponteiroNovo, contadorTamanho);
    for(int i =0; i < contadorTamanhoNomes-1;i++){
        printf("%s\n", procurarNome(ponteiroNovo,arrayNomes,contadorTamanho,i));    
    }
    clock_t final = clock();
    double tempo = ((double)(final - inicio))/CLOCKS_PER_SEC;
    FILE *ponteiroArquivo = fopen("824137_binaria.txt","w");
    fprintf(ponteiroArquivo,"824137\t%d\t%d\t%ld",comparacoes,movimentacoes,final-inicio);
    fclose(ponteiroArquivo); 
    free(ptrPersonagens);
    free(ponteiroNovo);
    return 0;
}
