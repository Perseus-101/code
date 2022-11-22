// tokenization and entering into linked list

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

//structure for linked list
char mnem[][6]={"STOP","ADD","SUB","MULT","MOVER","MOVEM","COMP","BC","READ","DIV","PRINT","READ"};
char reg[][6]={"AREG","BREG","CREG", "DREG"};
char cond[][5]={"LT", "LE","GT", "GE", "EQ", "ANY"};
char asmdr[][6]={"START", "END","LTORG", "ORIGIN", "EQU"};


//Functions to check whether the tokens match or not
int isMnem(char *token)
{
    for(int i=0;i<12;i++)
  	{
    	if(strcasecmp(mnem[i] , token)==0)
      		return 1;
   	}
   return 0;
}

int isAsm(char *token)
{
	for(int i =0 ; i<5; i++)
	{
		if(strcasecmp(asmdr[i],token)==0)
			return 1;
	}	
	return 0;
}

int isReg(char *token)
{
	for(int i =0 ; i<4; i++)
	{
		if(strcasecmp(reg[i],token)==0)
			return 1;
	}	
	return 0;
}

int isCond(char *token)
{
	for(int i =0 ; i<6; i++)
	{
		if(strcasecmp(cond[i],token)==0)
			return 1;
	}	
	return 0;
}
int i =0;

//void main
void main(int argc , char *argv[]){
	FILE *fp;
	char t1[10] = {},t2[10] = {},t3[10] = {},t4[10] = {},tmp[20];
	char line[50];
	int c,f=0,k=0,lno=0,num;
	if(argc!=2){
		printf("Invalid number of arguments...\n");
		exit(0);
	}
	
	fp = fopen(argv[1],"r");
	
	if(fp ==NULL){
		printf("File does not exist!");
		exit(0);
	}
	
	while(fgets(line,50,fp)!=NULL){
		strcpy(t1,"\0");
		strcpy(t2,"\0");
		strcpy(t3,"\0");
		strcpy(t4,"\0");
		lno++;
		c = sscanf(line,"%s%s%s%s", t1,t2,t3,t4);
		switch(c)
		{
			case 1: printf("\n\nLine %d: %s", lno, t1);
					if(strcasecmp(t1,"STOP")==0 || strcasecmp(t1,"LTORG")==0 || strcasecmp(t1,"END")==0)
						f=1;
					if(f==0)
					{
						printf("\nInvalid Mnemonic Instruction");
					}
				break;

			case 2:printf("\n\nLine %d: %s\t%s", lno, t1, t2);
				if(strcmp(t1,"ORIGIN")==0)
				{
						if(isMnem(t2)==1 || isCond(t2)==1 || isAsm(t2)==1 || isReg(t2)==1)
									printf("\nInvalid Label Name");	
				}
				else
				{
					if(strcasecmp(t1,"READ")==0 || strcasecmp(t1,"PRINT")==0 )
					{
						if(isMnem(t2)==1 || isCond(t2)==1 || isAsm(t2)==1 || isReg(t2)==1)
									printf("\nInvalid Memory Operand");	
					}
					else if(strcasecmp(t1,"START")==0)
					{
						num = atoi(t2);
						if(num<0 || num>999)
							printf("\nInvalid Location Operand");
							
					}
					else
					{
						if(isMnem(t1)==0 || isCond(t1)==0 || isAsm(t1)==0 || isReg(t1)==0)
							printf("\nInvalid Label Name");
						if(isMnem(t2)==1 || isCond(t2)==1 || isAsm(t2)==1 || isReg(t2)==1)
									printf("\nInvalid Mnemonic Operand");	
					}
						
				}
				break;

			case 3:printf("\n\nLine %d: %s\t%s\t%s ", lno, t1, t2, t3);
					if(isMnem(t1)==1)
					{
						if(strcmp(t1,"BC")==0)
						{
							if(isCond(t2)==0)
								printf("\nInvalid Condition Code");
							if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
								printf("\nInvalid Label Name");
						}
						else
						{
							if(strcmp(t1,"ADD") || strcmp(t1,"SUB") || strcmp(t1,"DIV") || strcmp(t1,"MULT"))
								{
									k = strlen(t2)-1;
									if(t2[k]!=',')
										printf("\nInvalid Register Operand");
									else
									{
										for(i=0;i<k;i++)
											tmp[i] = t2[i];
										tmp[i] = '\0';
										if(isReg(tmp)==0)
											printf("\nInvalid Register Operand");
											
									}
								if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
									printf("\nInvalid Memory Operand");	
								}
								else
								{
									k = strlen(t2)-1;
									if(t2[k]!=',')
										printf("\nInvalid Register Operand");
									else
									{
										for(i=0;i<k;i++)
											tmp[i] = t2[i];
											tmp[i] = '\0';
										if(isReg(tmp)==0)
											printf("\nInvalid Register Operand");
									}
								if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
									printf("\nInvalid Memory Operand");	
								}  
						}
					}
					else
					{
						if(isMnem(t1)==1 || isCond(t1)==1 || isAsm(t1)==1 || isReg(t1)==1)
							printf("\nInvalid Label Name");
						if(strcmp(t2,"DC")==0 || strcmp(t2,"DS")==0)
						{
							if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
									printf("\nInvalid Symbolic Name");	
						}
						else if(strcmp(t2,"EQU")==0)
						{
							if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
									printf("\nInvalid Address Specifier");	
						}
						else
						{
							if(isMnem(t2)==0)
								printf("\nInvalid Mnemonic Name");
							else
							{
								if(isMnem(t3)==1 || isCond(t3)==1 || isAsm(t3)==1 || isReg(t3)==1)
									printf("\nInvalid Memory Operand");	
							}
						}
					}
					break;

			case 4: printf("\n\nLine %d: %s\t%s\t%s\t%s", lno, t1, t2, t3, t4);
					if(isMnem(t1)==1 || isCond(t1)==1 || isAsm(t1)==1 || isReg(t1)==1)
						printf("\nInvalid Symbolic Name");
					if(isMnem(t2)==0)
						printf("\nInvalid Mnemonic Name");
					if(strcmp(t2,"BC")==0)
					{
						if(isCond(t3)==1)
							printf("\nInvalid Condition Code");		
					}
					k = strlen(t3)-1;
					if(t3[k] =',')
						printf("\nInvalid Register Operand");
					else
					{
						for(i=0;i<k;i++)
						{
							tmp[i]=t3[i];
							tmp[i] = '\0';
							if(isReg(tmp)==0)
								printf("\nInvalid Register Operand");
						}
					}
					if(isMnem(t4)==1 || isCond(t4)==1 || isAsm(t4)==1 || isReg(t4)==1)
						printf("\nInvalid Memory Operand");
				break;
		}
		
	}
	fclose(fp);
	}

	
	
	
	
