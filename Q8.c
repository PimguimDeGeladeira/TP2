#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>

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
    char dateOfBirth[11];
    int yearOfBirth;
    char eyeColour[101];
    char gender[101];
    char hairColour[101];
    int wizard;
}Personagens;

char** split(char* linha, char delim) {
    strcat(linha,";");
    int num_delimiters = 0;
    int len = strlen(linha);
    
    // Conta o número de delimitadores na string
    for (int i = 0; i < len; i++) {
        if (linha[i] == delim) {
            num_delimiters++;
        }
    }

    // Aloca memória para o array de strings
    char** atributos;
    atributos = malloc((num_delimiters + 1) * sizeof(char*));
    if (atributos == NULL) {
        printf("Erro ao alocar memória.\n");
        exit(1);
    }

    // Inicializa o array de strings
    for (int i = 0; i <= num_delimiters; i++) {
        atributos[i] = (char*)malloc((len + 1) * sizeof(char));
        if (atributos[i] == NULL) {
            printf("Erro ao alocar memória.\n");
            exit(1);
        }
    }

    // Realiza a divisão da string
    int atributo_index = 0;
    int start = 0;
    int i=0;
    for (int i = 0; i <= len; i++) {
        if (linha[i] == delim || linha[i] == '\0') {
            strncpy(atributos[atributo_index], linha+start, i - start);
            atributos[atributo_index][i - start] = '\0'; // Adiciona o terminador nulo
            start = i + 1;
            atributo_index++;
        }
    }
    return atributos;
}

Personagens *ptrteste(){
    FILE *ponteiroArquivo = fopen("/tmp/characters.csv","r");
    const int totalPersonagens = 405;
    Personagens *listaPersonagens = malloc(totalPersonagens * sizeof(Personagens));
    char lixo[101], booleanoHogwartsStaff[101], booleanoAlive[101], dataNascimento[101], mago[101], estudanteDeHogwarts[101],string[1001];
    if(ponteiroArquivo != NULL){ 
        for(int i=0; i<405; i++){
            if(i==0){
                char strlixo[201];
                fscanf(ponteiroArquivo," %[^\n]",strlixo);
            }
            if(i>0){
                fscanf(ponteiroArquivo," %[^\n]",string);
                char **atributos = split(string,';');
                strcpy(listaPersonagens[i].id,atributos[0]);
                strcpy(listaPersonagens[i].name,atributos[1]);
                strcpy(listaPersonagens[i].alternate_names,atributos[2]); 
                strcpy(listaPersonagens[i].house,atributos[3]);
                strcpy(listaPersonagens[i].ancestry,atributos[4]);
                strcpy(listaPersonagens[i].species,atributos[5]); 
                strcpy(listaPersonagens[i].patronus,atributos[6]); 
                strcpy(booleanoHogwartsStaff,atributos[7]);
                strcpy(estudanteDeHogwarts,atributos[8]);
                strcpy(listaPersonagens[i].actorName,atributos[9]);
                strcpy(booleanoAlive,atributos[10]);
                strcpy(lixo,atributos[11]);
                strcpy(listaPersonagens[i].dateOfBirth,atributos[12]);
                strcpy(dataNascimento,atributos[13]);          
                strcpy(listaPersonagens[i].eyeColour,atributos[14]);
                strcpy(listaPersonagens[i].gender,atributos[15]);
                strcpy(listaPersonagens[i].hairColour,atributos[16]);
                strcpy(mago,atributos[18]);
                if(strcmp(booleanoHogwartsStaff,"FALSO") == 0){
                    listaPersonagens[i].hogwartsStaff = 0;
                }else{
                    listaPersonagens[i].hogwartsStaff = 1;
                }
                if(strcmp(estudanteDeHogwarts,"FALSO") == 0){
                    strcpy(listaPersonagens[i].hogwartsStudent,"false");
                }else{
                    strcpy(listaPersonagens[i].hogwartsStudent,"true");    
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
        printf(" %s ##",ptrPersonagens[index].hogwartsStudent);
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

void swap(Personagens *i, Personagens *j) {
   Personagens temp= *i;
   *i = *j;
   *j = temp;
}

int compareEyeColour(Personagens p1, Personagens p2){
    int comparacao = strcmp(p1.eyeColour,p2.eyeColour);
    comparacoes++;
    if(comparacao == 0){
        comparacoes++;
        return strcmp(p1.name,p2.name);
    }
    return comparacao;
}

void insercaoPorCor(Personagens *array, int tamanho, int cor, int h){
    for (int i = (h + cor); i < tamanho; i+=h) {
        Personagens tmp = array[i];
        int j = i - h;
        while ((j >= 0) && (compareEyeColour(array[j],tmp) > 0)) {
            array[j + h] = array[j];
            movimentacoes++;
            j-=h;
        }
        array[j + h] = tmp;
        movimentacoes++;
    }
}

void shellsort(Personagens *array, int tamanho) {
    int h = 1;

    do { h = (h * 3) + 1; } while (h < tamanho);

    do {
        h /= 3;
        for(int cor = 0; cor < h; cor++){
            insercaoPorCor(array, tamanho, cor, h);
        }
    } while (h != 1);
}

int main(){
    clock_t inicio = clock();
    int indexMatriz=0, contadorTamanho=0, contadorTamanhoNomes=0;
    char idParaAchar[1001], nomeParaAchar[101];
    char arrayId[405][101];
    Personagens *ptrPersonagens = ptrteste();
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
    shellsort(ponteiroNovo, contadorTamanho);
    for(int i = 1; i < contadorTamanho; i++){
        imprimirPersonagem(ponteiroNovo,i);
    }
    clock_t final = clock();
    double tempo = ((double)(final - inicio))/CLOCKS_PER_SEC;
    FILE *ponteiroArquivo = fopen("824137_shellsort.txt","w");
    fprintf(ponteiroArquivo,"824137\t%d\t%d\t%ld",comparacoes,movimentacoes,final-inicio);
    fclose(ponteiroArquivo); 
    free(ptrPersonagens);
    free(ponteiroNovo);
    return 0;
}
