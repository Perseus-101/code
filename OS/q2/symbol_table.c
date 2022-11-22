#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct symtab{
	char symb[10];
	int addr;
	int uf, df, cnt;
	struct symtab *next;
	
}*shead = NULL , *scur , *snew;

char *optab[11]={"STOP","ADD","SUB","MULT","MOVER","MOVEM","COMP","BC","READ","DIV","PRINT"};
char *regtab[4]={"AREG","BREG","CREG", "DREG"};
char *cc[6]={"LT", "LE","GT", "GE", "EQ", "ANY"};
char *ad[5]={"START", "END","LTORG", "ORIGIN", "EQU"};
char *ds[2] = {"DS", "DC"};
char *specialad[3] = {"STOP","LTORG","END"};

int plc , lc = 0;

void entersymtab(char a[] , int );

int searchopc(char sym[10])
{
	int i , flag = 0;
	for(i =0 ; i<=10 ; i++){
		if(strcmp(optab[i], sym)==0)
		{
			flag = 1;
			break;
		}
	}
	if(flag==1)
		return 1;
	else
		return 0;
}

void entersymtab(char sym[10] , int value)
{
	struct symtab *temp ;	
	int flag = 0;
	for(temp = shead; temp!=NULL;temp = temp->next)
	{
		if(strcmp(temp->symb, sym)==0)
		{
			flag = 1;
			break;
		}
	}
	
	if(flag ==0)
	{
		snew  = (struct symtab*)malloc(sizeof(struct symtab));
		strcpy(snew->symb,sym);
		switch(value)
		{
			case 0 :
					 snew->addr = -1;
					 snew->uf =1;
					 snew ->cnt  = 0;
					 break;
			case 1: 
					snew->addr = plc;
					snew->df = 1;
					snew->cnt++;
					break;		
		}
		snew->next = NULL;
		
		if(shead ==NULL)
			shead = scur = snew;
		else{
			scur->next = snew;
			scur = snew;
		}	
	}
	else
	{
	
		switch(value)
		{
			case 0 : temp->uf = 1;
					break;
			case 1:  if(temp->addr ==-1)
						temp->addr = plc;
					temp->cnt++;
					temp ->df = 1;
					break;						
		}
	}	
}

int main(int argc , char *argv[])
{
	struct symtab *s;
	FILE *fp;
	char progstmt[80] , fname[10];
	char lbl[10] , opc[10] , reg[10] , oper[10];
	int ntok;
	
	if(argc!= 2)
	{
		printf("Error : Invalid number of arguments");
		exit(1);
	}
	else
	{
		strcpy(fname, argv[1]);
	}

	fp = fopen(argv[1],"r");
	
	if(fp==NULL)
	{
		printf("File does not exist");
		exit(1);
	}

	while(!feof(fp))
	{
		strcpy(progstmt,"");
		strcpy(lbl,"");
		strcpy(opc,"");
		strcpy(reg,"");
		strcpy(oper,"");
		fgets(progstmt, 80, fp);
		
		ntok  = sscanf(progstmt, "%s%s%s%s",lbl,opc,reg,oper);
		
		switch(ntok)
		{
			case 1: 
					plc = lc;
					lc++;
				break;
			case 2: 
					if(strcmp(lbl, "START")==0)
					{
						strcpy(oper,opc);
						strcpy(opc,lbl);
						strcpy(lbl,"");
						lc = atoi(oper);	
					}
					else
					{
						if(searchopc(lbl))
						{
							plc = lc;
							strcpy(oper,opc);
							strcpy(opc,lbl);
							strcpy(lbl,"");
							lc++;
						}
						else
						{
							plc = lc;
							entersymtab(lbl,1);
							lc++;	
						}
					}
				break;
			case 3:  
					if(strcmp(opc,"DS")==0)
					{
						plc = lc;
						entersymtab(lbl,1);
						lc+=atoi(reg);
					}
					if(strcmp(opc,"DC")==0)
					{
						plc = lc;
						entersymtab(lbl,1);
						lc++;
					}
					if((strcmp(opc,"DS")!=0) && (strcmp(opc,"DC")!=0))
					{
							if(searchopc(lbl))
							{
								plc = lc;
								strcpy(oper , reg);
								strcpy(reg , opc);
								strcpy(opc, lbl);
								strcpy(lbl, "");
								entersymtab(oper,0);
								lc++;
							}
							else
							{
								plc = lc;
								strcpy(oper , reg);
								strcpy(reg , "");
								entersymtab(lbl,1);
								entersymtab(oper,0);
								lc++;
							}
					} 
				break;
			case 4 : 
					plc = lc;
					entersymtab(lbl,1);
					entersymtab(oper,0);
					lc++;
				break;
		}//end of switch
	}//end of while
	
	printf("Symbol table\n\n");
	printf("Name\tAddress\tUsed\tDefine\n");
	for(s=shead;s!=NULL;s=s->next){
		printf("\n%s \t %d \t%d \t%d \t%d",s->symb,s->addr,s->uf,s->df,s->cnt);
	}
	printf("\n");
	for(s=shead;s!=NULL;s=s->next){
			if(s->df == 0)
				printf("\nError : Symbol %s is used but not defined",s->symb);
			if(s->uf == 0)
				printf("\nWarning : Symbol %s is defined but not used",s->symb);
			if(s->df == 0)
				printf("\nError : Redeclaration of Symbol %s",s->symb);
	}
	printf("\n");
	fclose(fp);
	return 0;	
}


