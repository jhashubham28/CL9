 import mpi.MPI;

    public class ScatterGather {
   	 public static void main(String args[]){
	//Initialize MPI execution environment
   	 MPI.Init(args);
	//Get the id of the process
   	 int rank = MPI.COMM_WORLD.Rank();
	//total number of processes is stored in size
   	 int size = MPI.COMM_WORLD.Size();
   	 int root=0;
	//array which will be filled with data by root process
   	 int sendbuf[]=null;

   	 sendbuf= new int[size];

	//creates data to be scattered
   	 if(rank==root){
   		 sendbuf[0] = 1;
   		 sendbuf[1] = 2;
   		 sendbuf[2] = 3;
   		 sendbuf[3] = 4;

		//print current process number
   		 System.out.print("Processor "+rank+" has data: ");
   		 for(int i = 0; i < size; i++){
   			 System.out.print(sendbuf[i]+" ");
   		 }
   		 System.out.println();
   	 }
	//collect data in recvbuf
   	 int recvbuf[] = new int[1];
	
	//following are the args of Scatter method
	//send, offset, chunk_count, chunk_data_type, recv, offset, chunk_count, chunk_data_type, root_process_id
   	 MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);
   	 System.out.println("Processor "+rank+" has data: "+recvbuf[0]);
		int i,m=0,flag=0;
		m=recvbuf[0]/2;
		if(recvbuf[0]==0||recvbuf[0]==1)
		{
			System.out.println(recvbuf[0]+" is not a prime number .");
			flag=1;
		}	
		else
		{
			for(i=2;i<=m;i++)
			if(recvbuf[0]%i==0)
			{
				System.out.println(recvbuf[0]+" is not a prime number .");
				flag=1;
				break;
			}

		}
		if(flag==0)
		{
			System.out.println(recvbuf[0]+" is a prime number .");
   	 	}
	//following are the args of Gather method
	//Object sendbuf, int sendoffset, int sendcount, Datatype sendtype,
//Object recvbuf, int recvoffset, int recvcount, Datatype recvtype,
//int root)
   	 MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);
	//display the gathered result
   	 if(rank==root){
   		System.out.println("Process 0 has data: ");
   		 for(i=0;i<4;i++){
   			 System.out.print(sendbuf[i]+ " ");
   		 }
   	 }
	//Terminate MPI execution environment 
   	 MPI.Finalize();
    }
}





/*

aditya@ubuntu:~$ javac -cp $MPJ_HOME/lib/mpj.jar ScatterGather.java
aditya@ubuntu:~$ $MPJ_HOME/bin/mpjrun.sh -np 4 ScatterGather
MPJ Express (0.44) is started in the multicore configuration
Processor 0 has data: 1 2 3 4 
Processor 1 has data: 2
2 is a prime number .
Processor 0 has data: 1
1 is not a prime number .
Processor 3 has data: 4
4 is not a prime number .
Processor 2 has data: 3
3 is a prime number .
Process 0 has data: 
1 2 3 4 
aditya@ubuntu:~$ 

*/
