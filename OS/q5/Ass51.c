//Name : Vikas Sharma
//Roll No. : 228778
//Assignment No. 5
//Simulator

#include<stdio.h>
#include<stdlib.h>
int mem[1000], reg[4], flag=0, h=0, temp1, f=0;
int lc=0, PC=0;

void load()
{
	FILE *fp;
	flag=0, temp1=0;
	char fname[30];
	int t=0,tk1[20];
	lc = 0, PC=0;
	printf("Enter the File Name:\t");
	scanf("%s",&fname);
	fp=fopen(fname,"r");
	if(fp==NULL)
		printf("File Does Not Exists\n");
	else
	{
		while(!feof(fp))
		{
			fscanf(fp,"%d %d",&tk1[t],&mem[lc]);
			if(tk1[t]!=-1)
			{
				if(tk1[t]<0 || tk1[t]>999)
				{
					printf("Invalid Memory Location %d\n",tk1[t]);
					return;
				}
			}
			t++;lc++;
		}
		t=0;lc=0;
		rewind(fp);
		fscanf(fp,"%d %d ",&lc, &tk1[0]);
		rewind(fp);
		PC=h=lc;
		while(!feof(fp))
		{
			fscanf(fp," %d %d ",&tk1[t],&mem[lc]);
			//printf("%d\t%d\n",tk1[t],mem[lc]);
			if(tk1[t]==-1)
			{
				temp1=mem[lc];
				break;
			}
			lc++;
			t++;
		}
		fclose(fp);
		flag=1;
		printf("Value of PC = %d\n",PC,lc);
	}
}

void print()
{
	PC=h;
	printf("Value of PC = %d\n", PC);
	while(1)
	{
		printf("%d %d\n",PC, mem[PC]);
		PC++;
		if(PC==lc)
			return;
	}
}


void execute(int f1)
{
	int op1, op2, inst, addr, opcode, r, i, eflag=0, temp2;
	PC=h;
	while(1)
	{
		inst = mem[PC]; temp2=inst;
		if(inst==temp1)
			break;
		addr = inst%1000;
		inst=inst/1000;
		opcode=inst/10;
		r=inst%10;
		if(r>4 && opcode!=7)
		{
			printf("Invalid Choice of Register for inst %d\n",temp2);
			eflag++;
			exit(0);
		}
		if(f1==0)
		{
			printf("OPCODE = %d ADDRESS = %d AREG = %d BREG = %d CREG = %d DREG = %d\n",opcode,addr,reg[0],reg[1],reg[2],reg[3]);
		}
		switch(opcode)
		{
			case 0 : return;
				 break;
			case 1 : reg[r-1]=reg[r-1] + mem[addr];
				 break;
			case 2 : reg[r-1]=reg[r-1] - mem[addr];
				 break;
			case 3 : reg[r-1]=reg[r-1] * mem[addr];
				 break;
			case 8 : if(mem[addr]==0)
				 {
					 printf("Error: Divison by Zero\n");
					 eflag++;
					 break;
				 }
				 else
				 {
					 reg[r-1]=reg[r-1]/mem[addr];
				 }
				 break;
			case 4 : reg[r-1]=mem[addr];
				 break;
			case 5 : mem[addr]=reg[r-1];
				 break;
			case 7 : switch(r)
				 {
					 case 1 : if(op1 < op2)
							  PC=addr-1;
						  break;
					 case 2 : if(op1<=op2)
							  PC=addr-1;
						  break;
					 case 3 : if(op1==op2)
							  PC=addr-1;
								  break;
					 case 4 : if(op1>op2)
							  PC = addr-1;
						  break;
					 case 5 : if(op1>=op2)
							  PC=addr-1;
						  break;
					 case 6 : PC=addr-1;
						  break;
					 default : printf("You have Entered Wrong Choice\n");
						   eflag++;
						   break;
				 }
			case 9 : printf("Enter Number:\t");
				 scanf("%d",&mem[addr]);
				 break;
			case 10 : if(eflag==0)
					  printf("Output: %d\n",mem[addr]);
				  break;
			default : printf("Invalid Instruction %d\n",temp2);
				  eflag++;
				  break;
		}
		PC++;
	}
}
int main()
{
	int ch, i;
	while(1)
	{
		printf("1.Load\n2.Print\n3.Execute\n4.Exit\nEnter Your Choice:\t");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 : load();
				 break;
			case 2 : print();
				 break;
			case 3 : if(flag==0)
					 printf("Program Not in Memory!!\n");
				 else
					 execute(1);
				 break;
			case 4 : exit(0);
				 break;
			default : printf("Invalid Choice\nEnter your Choice:\t");
		}
	}
	printf("\n\n");
}
