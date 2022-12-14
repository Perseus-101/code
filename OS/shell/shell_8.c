#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<dirent.h>
#include<string.h>

void typeline(char *s,char *fn)
{
	int i=0,cnt=0,n, handle;
	char ch;
	if ((handle = open (fn, O_RDONLY)) == -1)
	{
		printf ("File %s not found\n", fn);
		return;
	}
	if(strcmp(s,"a")==0)
	{
		while(read(handle,&ch,1)!=0)
			printf("%c",ch);
		close(handle);
		return;
	}
	n=atoi(s);
	if(n>0)
	{
		while(read(handle,&ch,1)!=0)
		{
			if(ch=='\n')
				i++;
			if(i==n)
				break;
			printf("%c",ch);
		}
	printf("\n");
	close(handle);
	return;
	}
	if(n<0)
	{
	while(read(handle,&ch,1)!=0)
	{
		if(ch=='\n')
			cnt++;
	}
	lseek(handle,0,SEEK_SET);
	while(read(handle,&ch,1)!=0)
	{
	if(ch=='\n')
		i++;
	if(i==cnt+n)
	break;
	}
	while(read(handle,&ch,1)!=0)
		printf("%c",ch);
		printf("\n");
		close(handle);
	}
}


int main(int argc, char* argv[])
{
	char cmd[80],*token, t[10][20];
	int pid, ntoken, e, in;
	do
	{
		printf("\nMyShell$ ");
		gets(cmd);
		token=strtok(cmd, " ");
		strcpy(t[0],token);
		ntoken=0;
		while(token)
		{
			ntoken++;
			token=strtok(NULL," ");
			if(token!=NULL)
				strcpy(t[ntoken], token);
		}
		switch(ntoken)
		{
			case 1:
				if(strcasecmp(t[0],"exit")==0)
					exit(0);
				else
				{
					pid=fork();
					if(pid==0)
					{
						e=execlp(t[0],t[0],(char*)0);
						if(e<0)
							printf("Error Occurred\n");
					}
					else
						waitpid(NULL);
				}
				break;
  
			case 2:

				pid=fork();
				if(pid==0)
				{
					e=execlp(t[0],t[0],t[1],(char*)0);
					if(e<0)
						printf("Error Occurred\n");
				}
				else
					waitpid(NULL);
				break;
     
			case 3:
				if(strcasecmp(t[0],"typeline")==0)
				{
					typeline(t[1],t[2]);
					continue;
				}	
				pid=fork();
				if(pid==0)
				{
					e=execlp(t[0],t[0],t[1],t[2],(char*)0);
					printf("e=%d",e);
					if(e<0)
						printf("Error Occurred\n");
				}
   
				else
					waitpid(NULL);
				break;
     
			case 4:
				pid=fork();
				if(pid==0)
				{
					e=execlp(t[0],t[0],t[1],t[2],t[3],(char*)0);
					if(e<0)
						printf("Error Occurred\n");
				}
				else
					waitpid(NULL);
				break;
		}
	}while(1);
}

