import java.util.*;

class customer
{
  String name;
  String addrs;
  long ac; 
  customer()
  {
  }
  customer(String nm,String a,long n)
  {
    name=nm;
    addrs=a;
    ac=n;
  }
  void output()
  {
    System.out.println("\n\n	Customer name     	: " +name+"\n");
    System.out.println("	Customer address  	: " +addrs+"\n");
    System.out.println("	Customer account_no	: " +ac+"\n");
  }
}


class balance extends customer
{
  float b;
  balance()
  {
  }
  balance(String nm,String a,long n,float x)
  {
    super(nm,a,n); 
    b=x;
  }
  void output()
  {
    super.output();
    System.out.println("	Customer balance	: " +"Rs:"+b+"/-\n");
  }
  int search(balance x[], int n,long ac1)
   {
     int f=0,i;
     for(i=1;i<=n;++i)
      if(x[i].ac==ac1)
      {
        f=i;
        break;
      }
     return(f);
   }
  void showall(balance b[],int n)
  {
    int i; 
    System.out.println("	Name			A/c No.			Balance");
    System.out.println("            -------------------------------------------------------");
    for(i=1;i<=n;++i)
    System.out.println("         "+b[i].name+"               "+b[i].ac+"              "+b[i].b+"\n");  
  }
  void dep(float m)
  {
    b=m+b;
  }
  int withd(float m)
  {
    b=b-m;
    if(b<0)
    {
     b=b+m;
     return(1);
    }
    else
    {
     b=b;
     return(0);
    }
   }
   int transc(float m)
   {
     b=b-m;
     if(b<0)
    {
     b=b+m;
     return(1);
    }
    else
    {
     b=b;
     return(0);
    }
   }
   void transd(float m)
   {
     b=b+m;
   }
}



class bank
{
  public static void main(String s[])
  {
    balance b[];
    int n=0;
    b=new balance[10];
    String nm,ad;
    long acc;
    int op,opt,optn,i,c,d;
    float bl,am;    
    System.out.println("			WELCOME TO BANKING SYSTEM	\n\n");
    Scanner sc=new Scanner(System.in);
    while(true)
    {
    System.out.println("Choose your option: ");
    System.out.println("(1) Enter Customer Details\n(2) Print Customer Details\n(3) Transaction of Customer\n(0) Exit from Banking System\n");
    op=sc.nextInt();

    if(op==1)
    {
     System.out.println("\n	---Customer's Details Entry--- 		\n");
     System.out.println("How many customer's details to be entered : ");
     n=sc.nextInt();
     for(i=1;i<=n;i++)
     {
     nm=sc.nextLine();
     System.out.println("Enter customer name: ");
     nm=sc.nextLine();
     System.out.println("Enter customer address: ");
     ad=sc.nextLine();
     System.out.println("Enter customer account_no: ");
     acc=sc.nextLong();
     System.out.println("Enter customer balance: ");    
     bl=sc.nextFloat();
     b[i]=new balance(nm,ad,acc,bl);  
     System.out.println("\n		Recorded Successfully		\n");
     }
     System.out.println("\n	"+n+" Details Recorded Successfully		\n");
    }

    if(op==2)
    {
      System.out.println("\n	---Show Customer's Details---		\n");
      while(true)
      {
       System.out.println("Choose your option:\n(1)Show only searched Account\n(2)Show All Accounts\n(3)Exit from Customer Details\n");
       opt=sc.nextInt();
       if(opt==1)
       {
        System.out.print("Enter A/c no. to print details...");
        int ac1=sc.nextInt();
        int f=b[1].search(b,n,ac1);
        if(f==0)
        System.out.println("		Account not found		\n");
        else
        b[f].output();
       }
       if(opt==2)
       {
         b[1].showall(b,n);
       }
       if(opt==3)
       {
         break;
       }
      }
    }

    if(op==3)
    {
      System.out.println("\n	---Customer's Transaction---		\n");
      while(true)
      {
       System.out.println("Choose your option:\n(1)Cash Deposit\n(2)Cash Withdraw\n(3)Fund Transfer\n(4)Exit From Transaction\n");
       optn=sc.nextInt();
       if(optn==1)
       {
         System.out.println("Enter A/c no. to transact...");
         long ac1=sc.nextLong();
         int f=b[1].search(b,n,ac1);
         if(f==0)
         System.out.println("\n		Account not found		\n");
         else
         {
           System.out.println("Enter the amount to be deposited: ");
           am=sc.nextFloat();
           b[f].dep(am);
           System.out.println("\n		Deposited Successfully		\n"); 
         }
        }
        if(optn==2)
        {
         System.out.println("Enter A/c no. to transact...");
         long ac1=sc.nextLong();
         int f=b[1].search(b,n,ac1);
         if(f==0)
         System.out.println("\n		Account not found		\n");
         else
         {
           System.out.println("Enter the amount to be withdrawn: ");
           am=sc.nextFloat();       
           d=b[f].withd(am);
           if(d==0)
           {
            System.out.println("\n		  Withdrawn Successfully		\n");
           }
           else
           {
            System.out.println("\n           A/c no."+ac1+ " has no sufficient balance to withdraw		\n");
            System.out.println("\n		               Transaction Failed		\n");
           }
         }
        }
        if(optn==3)
        {
          System.out.println("Enter A/c no. from where to transfer...");
          int ac1=sc.nextInt();
          int f=b[1].search(b,n,ac1);
          if(f==0)
          System.out.println("\n		Account not found		\n");
          else
          System.out.println("Enter the amount to transfer...");
          float x=sc.nextFloat();
          System.out.println("Enter A/c no. to where to transfer...");
          long ac2=sc.nextLong();
          int g=b[1].search(b,n,ac2);
          if(g==0)
          System.out.println("\n		Account not found		\n");
          else
          {
           c=b[f].transc(x);
           if(c==0)
           {
            b[g].transd(x);
            System.out.println("\n		 Fund Transferred Successfully		\n");
           }
           else
           {
            System.out.println("\n           A/c no."+ac1+ " has no sufficient balance to transfer		\n");
            System.out.println("\n		            Transaction Failed		\n");
           }
          }
        }
        if(optn==4)
        {
          break;
        }
       }
      }

     if(op==0)
     {
       System.out.println("		THANK YOU FOR USING BANKING SYSTEM");
       break;
     }  
    }
   }
}